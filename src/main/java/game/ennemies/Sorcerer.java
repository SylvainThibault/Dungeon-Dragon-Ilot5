package game.ennemies;

import game.Perso;
import game.Wizard;

public class Sorcerer extends Enemy {

    public Sorcerer(String name, int attack, int life) {
        super(name, attack, life);
    }

    @Override
    public Boolean fight(Perso perso){
        if( perso instanceof Wizard){
            int persoPower = perso.getPower();
            int spellLevel=perso.getBonusDamage(this);
            int degat = persoPower+spellLevel;
            int lifeEnemy =this.getLife();
            System.out.println("puissance d'attaque "+degat);
            System.out.println("Vie du méchant "+ lifeEnemy);
            lifeEnemy = lifeEnemy-degat;

            return fightResult(lifeEnemy, perso);
        }
        return null;
    }
}
