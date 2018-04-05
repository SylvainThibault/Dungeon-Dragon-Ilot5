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

            int weaponLevel = perso.getBonusDamage(this) / 2;
            int persoPower = weaponLevel + perso.getPower();

            int degat = persoPower + weaponLevel;
            int lifeEnemy = this.getLife();
            System.out.println("Perso strength : " + degat + " // " + lifeEnemy + " : Enemy's life");

            lifeEnemy = lifeEnemy - degat;

            return fightResult(lifeEnemy, perso);
        }
        return null;
    }
}
