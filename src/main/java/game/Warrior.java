package game;

import game.attack.Weapon;

public class Warrior extends Perso {
    private Weapon weapon;
    private int shield;


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

}