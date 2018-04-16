package game;

import game.combat.CombatPersonnage;
import game.interfaces.TypeCombat;
import game.items.attack.Weapon;

public class Warrior extends Perso {
    private Weapon weapon;
    private int shield;

    public Warrior(String name, Weapon weapon, int shield) {
        super(name);
        this.weapon = weapon;
        this.shield = shield;
    }

    public Warrior(String name, Weapon weapon) {
        super(name);
        this.weapon = weapon;
        this.shield = 0;
    }

    public Warrior(){}

    @Override
    public String getPersoType() {
        return "warrior";
    }

    @Override
    public String getWeaponType() {
        return "weapon";
    }

    //SETTERS

    public void setWeapon (Weapon weapon) {
        this.weapon = weapon;
    }

    public void setTypeCombat(TypeCombat typeCombat){
        weapon.setTypeCombat(typeCombat);
    }

    //GETTERS

    @Override
    public int getBonusDamage() {
        int bonusDamage = 0;
        if (weapon != null){
            bonusDamage = (int) (weapon.getPower() * weapon.getBonusDamageModifier());
        }
        return bonusDamage;
    }
    @Override
    public int getDefenseBonus() {
        if (weapon != null){
            return shield + weapon.getDefenseBonus();
        }
        return shield;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}