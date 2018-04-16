package game;

import game.interfaces.Fightable;
import game.interfaces.TypeCombat;

public abstract class Perso implements Fightable{

    //Stocke variable
    private String name;
    private int power;
    private int life;
    private String image;
    private int armor;

    public Perso(String name) {
        this.name = name;
        setPower(15);
        setLife(100);
    }
    // Contructeur
    public Perso(){
        setPower(15);
        setLife(100);
    }

    //Accesseurs//

    //Return variable
    public String getName() {
        return this.name;
    }

    public int getPower() {
        return this.power;
    }

    public int getLife() {
        return this.life;
    }

    public String getImage() {
        return this.image;
    }

    public int getAmor() {
        return this.armor;
    }

    public abstract TypeCombat getTypeCombat();

    //mutateurs//

    // Définit variable
    public void setName(String name) {
        this.name = name;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String toString() {
        return "Name : " + name + "\nPower : " + power + "\nLife : " + life + "\nImage : " + image + "\nArmor : " + armor;
    }

    public int getTotalDamage(){
        return this.getPower() + this.getBonusDamage();
    }

    public void takeDamage(int damageTaken) {
        int defense = this.getDefenseBonus();
        if (defense == 0){
            defense = 1;
        }
        this.setLife(this.getLife() - (damageTaken / defense));
    }


    public abstract String getPersoType();
//
    public abstract String getWeaponType();
}