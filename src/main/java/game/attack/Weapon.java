package game.attack;

import java.util.HashMap;
import java.util.Map;

public class Weapon extends Attack {

    Weapon(String name, int level){
        super(name, level);
    }

    public static Map<Integer, Weapon> getWeapons() {
        Map<Integer,Weapon> weaponMap = new HashMap<>();
        weaponMap.put(1, new Weapon("bow", 0));
        weaponMap.put(2, new Weapon("mace", 30));
        weaponMap.put(3, new Weapon("sword", 25));

        return weaponMap;
    }

}
