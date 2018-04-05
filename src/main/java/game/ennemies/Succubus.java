package game.ennemies;

import game.Perso;
import game.Warrior;
import game.Wizard;
import game.items.attack.Weapon;

public class Succubus extends Enemy {

    public Succubus(String name, int attack, int life) {
        super(name, attack, life);
    }

    @Override
    public Boolean fight(Perso perso) {
        if (perso instanceof Warrior) {

            int weaponLevel = ((Warrior) perso).getWeapon().getLevel(this) / 2;
            int persoPower = weaponLevel + perso.getPower();

            int degat = persoPower + weaponLevel;
            int lifeEnemy = this.getLife();
            System.out.println("Perso strength : " + degat + " // " + lifeEnemy + " : Enemy's life");

            lifeEnemy = lifeEnemy - degat;

            if (lifeEnemy <= 0) {
                System.out.println("you win");
                return true;
            } else {
                int persoLife = perso.getLife();
                int attackEnemy = this.getAttack();
                int changePersoLife = persoLife - attackEnemy;
                System.out.println("you lose");
                System.out.println(" life personnage " + persoLife);
                perso.setLife(changePersoLife);
                System.out.println("new life personnage " + changePersoLife);
                return false;
            }
        }
        return null;
    }
}
