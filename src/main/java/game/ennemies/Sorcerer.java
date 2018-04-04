package game.ennemies;

import game.Perso;
import game.Wizard;

public class Sorcerer extends Enemy {

    public Sorcerer(String name, int attack) {
        super(name, attack);
    }

    public void fight(Perso perso){
        if( perso instanceof Wizard){
            System.out.println("fight Wizard");
        }
    }
}
