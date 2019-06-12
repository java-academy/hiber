package pl.ksundaysky.workshops.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Kamil Rojek
 */
@Entity
public class SoulMaster extends Wizard {
    @Enumerated(EnumType.STRING)
    private WizzarUltimate wizzarUltimate;

    public SoulMaster() {
    }

    public SoulMaster(String name, Sex sex, int mana, WizzarUltimate wizzarUltimate) {
        super(name, sex, mana);
        this.wizzarUltimate = wizzarUltimate;
    }

    public WizzarUltimate getWizzarUltimate() {
        return wizzarUltimate;
    }

    public void setWizzarUltimate(WizzarUltimate wizzarUltimate) {
        this.wizzarUltimate = wizzarUltimate;
    }
}
