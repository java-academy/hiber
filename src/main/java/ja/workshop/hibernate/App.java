package ja.workshop.hibernate;

import ja.workshop.hibernate.connectors.H2Connector;
import ja.workshop.hibernate.model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author bartosz.kupajski
 */
class App {
    public static void main(String[] args) {
        dodajKordiana();
        tworzenieWalczącychWątków(1L);
    }

    private static void tworzenieWalczącychWątków(long id) {
        Thread wątekPrzegrywający = new Thread(new WątekWalczącyPrzegrywający(id), "WątekPrzegrywający");
        Thread wątekWygrywający = new Thread(new WątekWalczącyWygrywający(id), "WątekWygrywający");

        wątekPrzegrywający.start();
        wątekWygrywający.start();
    }

    private static void dodajKordiana() {
        Author pisarzJuliusz = new Author("Juliusz", "Słowacki");
        Book ksiażkaKordian = new Book("Kordian", Set.of(pisarzJuliusz), Genre.CLASSIC);
        Bookstore ksiegarniaPodGlobusem = new Bookstore("Ksiegarnia Pod Globusem");
        BookstoreBook summary = new BookstoreBook(ksiegarniaPodGlobusem, ksiażkaKordian, 12);
        Transaction transaction = null;

        try (Session session = new H2Connector().getSession()) {
            transaction = session.beginTransaction();

            session.save(ksiażkaKordian);
            session.save(summary);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

    private static class WątekWalczącyPrzegrywający implements Runnable {

        Session session1 = new H2Connector().getSession();
        Transaction tx = null;
        long personId;

        WątekWalczącyPrzegrywający(long personId) {
            this.personId = personId;
        }

        @Override
        public void run() {
            BookstoreBook summary = session1.get(BookstoreBook.class, personId);
            if (summary != null) {
                tx = session1.beginTransaction();

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                summary.setPrice(18);
                session1.update(summary);
                tx.commit();
            }
        }
    }

    private static class WątekWalczącyWygrywający implements Runnable {

        Session session2 = new H2Connector().getSession();
        Transaction tx = null;
        long personId;

        public WątekWalczącyWygrywający(long personId) {
            this.personId = personId;
        }

        @Override
        public void run() {
            BookstoreBook summary = session2.get(BookstoreBook.class, personId);
            if (summary != null) {
                tx = session2.beginTransaction();
                summary.setPrice(25);
                session2.update(summary);
                tx.commit();
            }
        }
    }
}

