package game;

public abstract class Perso {

    //Stocke variable
    private String name;
    private int power;
    private int life;
    private String image;
    private int armor;

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
    public void setName(String Name){
        this.name = Name;
    }

    public void setPower(int Power){
        this.power = 15;
    }

    public void setLife(int Life){
        this.life = 100;
    }

    public void setImage(String Image){
        this.image = Image;
    }

    public void setArmor(int Armor){
        this.armor = Armor;
    }

    public String toString(){
        return "Name : "+ name + "\nPower : " + power + "\nLife : " + life + "\nImage : " + image + "\nArmor : " + armor;
    }
}