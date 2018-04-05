package game.ennemies;

import game.Perso;
import game.Warrior;
import game.items.attack.Weapon;

public class Succubus extends Enemy {

    public Succubus(String name, int attack, int life) {
        super(name, attack, life);
    }

    @Override
    public void fight(Perso perso) {
        if (perso instanceof Warrior) {
            Weapon currentWeapon = ((Warrior) perso).getWeapon();
            int currentWeaponLevel = currentWeapon.getLevel() / 2;

            System.out.println("Original weapon strength : " + currentWeapon.getLevel());
            System.out.println("Current weapon strength : " + currentWeaponLevel);
            System.out.println("fight Warrior");
        }
    }
}
