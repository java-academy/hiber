package ja.workshops.hibernate.parts.model;

import javax.persistence.*;

/**
 * @author Agnieszka Trzewik
 */
@Entity
@Table(name = "bookstore_book")
public class BookstoreBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookstore_id", nullable = false)
    private Bookstore bookstore;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "price", nullable = false)
    private int price;

    public BookstoreBook() { }

    public BookstoreBook(Bookstore bookstore, Book book, int price) {
        this.bookstore = bookstore;
        this.book = book;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Bookstore getBookstore() {
        return bookstore;
    }

    public void setBookstore(Bookstore bookstore) {
        this.bookstore = bookstore;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
