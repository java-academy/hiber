package pl.ksundaysky.workshops.model;

import javax.persistence.*;

/**
 * @author Kamil Rojek
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Champion {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    
    @Enumerated(EnumType.STRING)
    private Sex sex;

    public Champion() { }

    public Champion(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
