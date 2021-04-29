package hu.nive.ujratervezes.kepesitovizsga.army;

public class Swordsman extends MilitaryUnit {
    private boolean shield;

    public Swordsman(Boolean armor) {
        setHealthPoints(100);
        setDamagePoints(10);
        setArmor(armor);
        shield = true;
    }

    public boolean isShield() {
        return shield;
    }

    public void setShield(boolean shield) {
        this.shield = shield;
    }
}
