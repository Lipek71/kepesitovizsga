package hu.nive.ujratervezes.kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit {
    boolean doDamage;

    public HeavyCavalry() {
        setHealthPoints(150);
        setDamagePoints(20);
        setArmor(true);
        doDamage = true;
    }

    public boolean isDoDamage() {
        return doDamage;
    }

    public void setDoDamage(boolean doDamage) {
        this.doDamage = doDamage;
    }
}
