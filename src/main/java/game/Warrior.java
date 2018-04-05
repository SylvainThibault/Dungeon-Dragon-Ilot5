package game;

import game.ennemies.Enemy;
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

    //ACCESSEURS//

    public Weapon getWeapon() {
        return this.weapon;
    }

    public int getShield() {
        return this.shield;
    }

    // MUTATEURS//

    public void setWeapon(Weapon Weapon){
        this.weapon = Weapon;
    }

    public void setShield(int Shield){
        this.shield = Shield;
    }

    // Méthode toString : Affiche les informations d'un objet
    public String toString(){
        return super.toString() + "\nWeapon : " + weapon + "\nShield : " + shield;
    }

    @Override
    public int getBonusDamage(Enemy enemy) {
        return this.getWeapon().getLevel(enemy);
    }
}