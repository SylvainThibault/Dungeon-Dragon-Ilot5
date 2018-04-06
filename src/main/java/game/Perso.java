package game;

import game.ennemies.Enemy;

public abstract class Perso {

    //Stocke variable
    private String name;
    private int power = 15;
    private int life;
    private String image;
    private int armor;

    public Perso(String name) {
        this.name = name;
        setPower(0);
        setLife(10);
    }

    //Accesseurs//

    //Return variable
    public String getName(){
        return this.name;
    }

    public int getPower(){
        return this.power;
    }

    public int getLife(){
        return this.life;
    }

    public String getImage(){
        return this.image;
    }

    public int getAmor(){
        return this.armor;
    }

    //mutateurs//

    // Définit variable
    public void setName(String name){
        this.name = name;
    }

    public void setPower(int power){
        this.power = power;
    }

    public void setLife(int life){
        this.life = life;
    }

    public void setImage(String image){
        this.image = image;
    }

    public void setArmor(int armor){
        this.armor = armor;
    }

    public String toString(){
        return "Name : "+ name + "\nPower : " + power + "\nLife : " + life + "\nImage : " + image + "\nArmor : " + armor;
    }

    public abstract int getBonusDamage(Enemy enemy);
}