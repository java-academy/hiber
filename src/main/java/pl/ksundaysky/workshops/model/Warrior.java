package pl.ksundaysky.workshops.model;

import javax.persistence.Entity;

/**
 * @author Kamil Rojek
 */
@Entity
public class Warrior extends Champion {
    private int engergy;

    public Warrior() {
    }

    public Warrior(String name, Sex sex, int stamina) {
        super(name, sex);
        this.engergy = stamina;
    }

    public int getEngergy() {
        return engergy;
    }

    public void setEngergy(int engergy) {
        this.engergy = engergy;
    }
}
