package pl.ksundaysky.workshops.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Kamil Rojek
 */
@Entity
public class DarkKnight extends Warrior {
    @Enumerated(EnumType.STRING)
    private WarriorUltimates warriorUltimates;

    public DarkKnight() {
    }

    public DarkKnight(String name, Sex sex, int stamina, WarriorUltimates warriorUltimates) {
        super(name, sex, stamina);
        this.warriorUltimates = warriorUltimates;
    }

    public WarriorUltimates getWarriorUltimates() {
        return warriorUltimates;
    }

    public void setWarriorUltimates(WarriorUltimates warriorUltimates) {
        this.warriorUltimates = warriorUltimates;
    }
}
