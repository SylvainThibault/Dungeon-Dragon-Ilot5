package game;

public class Warrior extends Perso {
    private String weapon;
    private int shield;


    //ACCESSEURS//

    public String getWeapon() {
        return weapon;
    }

    public int getShield() {
        return shield;
    }

    // MUTATEURS//

    public void setWeapon(String pWeapon){
        weapon = pWeapon;
    }

    public void setShield(int pShield){
        shield = pShield;
    }

    // Méthode toString : Affiche les informations d'un objet
    public String toString(){
        return super.toString() + "\nWeapon : " + weapon + "\nShield : " + shield;
    }

}