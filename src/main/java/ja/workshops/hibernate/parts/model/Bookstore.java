package ja.workshops.hibernate.parts.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Agnieszka Trzewik
 */
@Entity
public class Bookstore {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "name", updatable = false, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="bookstore")
    private Set<BookstoreBook> bookstoreBooks = new HashSet<BookstoreBook>();

    public Bookstore() { }

    public Bookstore(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BookstoreBook> getBookstoreBooks() {
        return bookstoreBooks;
    }

    public void setBookstoreBooks(Set<BookstoreBook> bookstoreBooks) {
        this.bookstoreBooks = bookstoreBooks;
    }
}
