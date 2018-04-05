package game.ennemies;

import game.Perso;
import game.Wizard;

public class Dragon extends Enemy {

    private int age;

    public Dragon(String name, int attack, int life, int age) {
        super(name, attack, life);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void fight(Perso perso){
        if( perso instanceof Wizard){
            System.out.println("fight Wizard");
        }
    }
}
