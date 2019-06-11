package ja.workshop.hibernate.model;

import javax.persistence.*;

/**
 * @author Bartosz Kupajski
 */
@Entity
public class Bookstore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String nameOfBookstore;

    public Bookstore(String nameOfBookstore) {
        this.nameOfBookstore = nameOfBookstore;
    }

    public Long getId() {
        return id;
    }

    public String getNameOfBookstore() {
        return nameOfBookstore;
    }

    public void setNameOfBookstore(String nameOfBookstore) {
        this.nameOfBookstore = nameOfBookstore;
    }
}
