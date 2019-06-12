package pl.ksundaysky.workshops.model;

import javax.persistence.Entity;

/**
 * @author Kamil Rojek
 */
@Entity
public class Wizard extends Champion {
    private int mana;

    public Wizard() {
    }

    public Wizard(String name, Sex sex, int mana) {
        super(name, sex);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
