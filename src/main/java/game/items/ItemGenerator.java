package game.items;

import game.items.attack.Spell;
import game.items.attack.Weapon;
import game.items.defense.Philter;
import game.items.defense.Shield;
import game.items.powerup.Bonus;
import game.items.powerup.Joker;
import game.items.powerup.Malus;

public class ItemGenerator {

    public static Item[] getItems(){
        Item[] items = new Item[15];

        items[0] = new Shield("small shield", 2);
        items[1] = new Shield("shield", 2);
        items[2] = new Shield("large shield", 5);
        items[3] = new Philter("small philter", 2);
        items[4] = new Philter("philter", 3);
        items[5] = new Philter("large philter", 5);
        items[6] = new Spell("indignation", 50);
        items[7] = new Spell("teamEric", 100);
        items[8] = new Weapon("frostmourne", 50);
        items[9] = new Weapon("soul edge", 60);
        items[10] = new Malus("carton rouge", 5);
        items[11] = new Malus("boule noire", 5);
        items[12] = new Bonus("drop the mic", 5);
        items[13] = new Joker("whiteboard", 25);
        items[14] = new Joker("skooma",50);

        return items;
    }
}
