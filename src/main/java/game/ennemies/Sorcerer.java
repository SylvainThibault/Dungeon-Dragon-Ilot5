package game.ennemies;

import game.Perso;
import game.Wizard;

public class Sorcerer extends Enemy {

    public Sorcerer(String name, int attack) {
        super(name, attack);
    }

@Override
    public void fight(Perso perso){
        if( perso instanceof Wizard){
            int persoPower = perso.getPower();
            int spellLevel=((Wizard) perso).getSpell().getLevel();
            int degat = persoPower+spellLevel;
            System.out.println(degat);
            System.out.println(this.getAttack());
        }
    }
}
