package hu.nive.ujratervezes.kepesitovizsga.army;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Army {
    private int armySize;
    private int armyDamage;
    private List<MilitaryUnit> army = new ArrayList<>();

    public int getArmySize() {
        return armySize;
    }

    public int getArmyDamage() {
        return armyDamage;
    }

    public void setArmySize(int armySize) {
        this.armySize = armySize;
    }

    public void setArmyDamage(int armyDamage) {
        this.armyDamage = armyDamage;
    }

    public void addUnit(MilitaryUnit unit) {
        army.add(unit);
        setArmySize(getArmySize() + 1);
        if (unit instanceof HeavyCavalry) {
            setArmyDamage(getArmyDamage() + unit.getDamagePoints() * 3);
        } else {
            setArmyDamage(getArmyDamage() + unit.getDamagePoints());
        }
    }

    public void damageAll(int damage) {
        for (MilitaryUnit item : army) {
            changeHealthPoints(item, damage);
            changeArmySize(item);
        }

        //int i = 0;
        //for (Iterator<MilitaryUnit> item = army.iterator(); item.hasNext();){
        //    if (army.get(i).getHealthPoints() < 25){
        //        item.remove();
        //    }
        //    i++;
        //}

    }

    private void changeArmySize(MilitaryUnit item) {
        if (item.getHealthPoints() < 25) {
            setArmySize(getArmySize() - 1);

        }
    }

    private void changeHealthPoints(MilitaryUnit item, int damage) {
        if (item instanceof Archer) {
            item.setHealthPoints(item.getHealthPoints() - damage);
        }
        if (item instanceof HeavyCavalry) {
            item.setHealthPoints(item.getHealthPoints() - damage);
            if (((HeavyCavalry) item).isDoDamage()) {
                ((HeavyCavalry) item).setDoDamage(false);
                setArmyDamage(getArmyDamage() - item.getDamagePoints() * 2);
            }
        }
        if (item instanceof Swordsman) {
            if (((Swordsman) item).isShield()) {
                ((Swordsman) item).setShield(false);
            } else {
                item.setHealthPoints(item.getHealthPoints() - damage);
            }
        }

    }

}
