package game.items;

import game.items.attack.AttackLevel;
import game.items.attack.Spell;
import game.items.attack.Weapon;
import game.items.defense.Philter;
import game.items.defense.Shield;
import game.items.powerup.Bonus;
import game.items.powerup.Joker;
import game.items.powerup.Malus;

import java.util.ArrayList;

public class ItemGenerator {

    public static ArrayList<Item> getItems(){
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Shield("small shield", 2));
        items.add( new Shield("shield", 2));
        items.add( new Shield("large shield", 5));
        items.add( new Philter("small philter", 2));
        items.add( new Philter("philter", 3));
        items.add( new Philter("large philter", 5));
        items.add( new Spell("indignation", new AttackLevel(50)));
        items.add( new Spell("teamEric", new AttackLevel(100)));
        items.add( new Weapon("frostmourne", new AttackLevel(50)));
        items.add( new Weapon("soul edge", new AttackLevel(60)));
        items.add( new Malus("carton rouge", 5));
        items.add( new Malus("boule noire", 5));
        items.add( new Bonus("drop the mic", 5));
        items.add( new Joker("whiteboard", 25));
        items.add( new Joker("skooma",50));

        return items;
    }
}
