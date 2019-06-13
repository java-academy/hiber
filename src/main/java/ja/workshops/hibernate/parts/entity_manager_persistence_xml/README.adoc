# Entity Manager

Do tej pory do operacji na kontekście persystencji używałeś API hibernatowego interfejsu Session.
Obecnie przyjrzymy się EntityManagerowi, który jest interfejsem standardu JPA.
Zadanie polega na stworzeniu odpowiedniego pliku konfiguracyjnego xml. Plik ma umożliwić konfigurację EntityManagera
dla połączenia się z jedną z baz danych (H2 lub PostgreSQL lub MySQL). Plik ma mieć zgodną z konwencją nazwę (jaką?).
Plik musi byc umieszczony w katalogu META-INF.
Zauważ, że istotne są nazwy poszczególnych ``persistence-unit``, które ustawiasz w tymże pliku konfiguracyjnym,
identyfikowane są one potem po tych nazwach przy konstruowaniu EntityManagera metodą Persistence.createEntityManagerFactory("nazwa").".
Jest cały szereg potrzebnych
Dokumentacja opisująca potrzebne tagi xml-owe jest tutaj:
https://docs.jboss.org/hibernate/stable/entitymanager/reference/en/html/configuration.html

https://www.youtube.com/watch?v=uQrUs4ojU3k&list=PLU2dl_1LV_SQWZI2R_RSEeYm1tfueszOc&index=5

Dla ułatwienia poniższe tagi powinny być wykorzystane:



 <persistence-unit name="" transaction-type="RESOURCE_LOCAL">

        <description>Moj opis</description>

        <provider>scieżka do klasy implemetującej PersistenceProvider</provider>
        <properties>
            <property name="javax.persistence.jdbc.driver" value="xxx"/>
            <property name="javax.persistence.jdbc.user" value="xxx"/>
            <property name="javax.persistence.jdbc.password" value="xxx"/>
            <property name="javax.persistence.jdbc.url" value="url do bazy"/>
            <property name="hibernate.dialect" value="xxx"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.hbm2ddl.auto" value="xxx"/>
        </properties>
    </persistence-unit>


Jak znaleźć, jaki provider nalezy wykorzystać? Wejdż to paczki hibernate-core-xxx.jar,
znajdź pakiet org.hibernate.jpa i znajdź klasę HibernatePersistenceProvider. To ta klasa, wklej jej FQN.

Jak znaleźc driver? Jest to klasa z paczki np. org.postgresql.Driver, wklej jej FQN do odpowiedniego tagu.

Jak znaleźc dialekt? Wejdż to paczki hibernate-core-xxx.jar,
znajdź pakiet org.hibernate.dialect  i znajdź klasę dialektu własciwego dla bazy, z którą się łączysz, wklej jej FQN.

Jaką ustawić wartość dla ``hibernate.hbm2ddl.auto``? Zobacz na prezentację Schemat_bazy_a_Hibernate.pdf, która jest w katalogu projektu.


Gdy połączysz się z bazą danych, popatrz na API EntityManagera. Zauważ, że jest inne, niż API Session.
Tutaj jest dokumentacja:
https://docs.oracle.com/javaee/7/api/javax/persistence/EntityManager.html




