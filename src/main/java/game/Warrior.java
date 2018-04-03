package game;

public class Warrior extends Perso {
    private String weapon;
    private int shield;


    //ACCESSEURS//

    public String getWeapon() {
        return this.weapon;
    }

    public int getShield() {
        return this.shield;
    }

    // MUTATEURS//

    public void setWeapon(String Weapon){
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