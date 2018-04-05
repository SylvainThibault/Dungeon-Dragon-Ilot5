package game.ennemies;

import game.Perso;
import game.Wizard;

public class Sorcerer extends Enemy {

    public Sorcerer(String name, int attack, int life) {
        super(name, attack, life);
    }

    @Override
    public void fight(Perso perso){
        if( perso instanceof Wizard){
            int persoPower = perso.getPower();
            int spellLevel=((Wizard) perso).getSpell().getLevel(this);
            int degat = persoPower+spellLevel;
            int lifeEnemy =this.getLife();
            System.out.println("puissance d'attaque "+degat);
            System.out.println("Vie du méchant "+ lifeEnemy);
            lifeEnemy = lifeEnemy-degat;
            if (lifeEnemy<=0){
                System.out.println("you win");
            }else {
                int persoLife = perso.getLife();
                int attackEnemy = this.getAttack();
                int changePersoLife = persoLife - attackEnemy;
                System.out.println("you lose");
                System.out.println(" life personnage "+persoLife);
                perso.setLife(changePersoLife);
                System.out.println("new life personnage "+persoLife);

            }
        }
    }
}
