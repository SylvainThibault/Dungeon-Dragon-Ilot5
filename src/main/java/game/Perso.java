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
        return name;
    }

    public int getPower(){
        return power;
    }

    public int getLife(){
        return life;
    }

    public String getImage(){
        return image;
    }

    public int getAmor(){
        return armor;
    }

    //mutateurs//

    // Définit variable
    public void setName(String pName){
        name = pName;
    }

    public void setPower(int pPower){
        power = pPower;
    }

    public void setLife(int pLife){
        life = 100;
    }

    public void setImage(String pImage){
        image = pImage;
    }

    public void setArmor(int pArmor){
        armor = pArmor;
    }

    public String toString(){
        return "Name : "+ name + "\nPower : " + power + "\nLife : " + life + "\nImage : " + image + "\nArmor : " + armor;
    }
}