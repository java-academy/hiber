package ja.workshops.hibernate.parts.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bartosz Kupajski
 */
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "title", updatable = false, nullable = false)
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    private Set<Author> authors = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy="book")
    private Set<BookstoreBook> bookstoreBooks = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Book() {

    }
    public Book(String title, Set<Author> authors, Genre genre) {
        this.title = title;
        this.authors = authors;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Set<BookstoreBook> getBookstoreBooks() {
        return bookstoreBooks;
    }

    public void setBookstoreBooks(Set<BookstoreBook> bookstoreBooks) {
        this.bookstoreBooks = bookstoreBooks;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", genre=" + genre +
                '}';
    }
}
