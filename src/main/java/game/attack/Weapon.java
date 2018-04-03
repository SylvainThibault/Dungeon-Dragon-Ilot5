package game.attack;

import java.util.HashMap;
import java.util.Map;

public class Weapon extends Attack {

    Weapon(String name, int level){
        super(name, level);
    }

    public static Map<String, Weapon> getWeapons() {
        Map<String,Weapon> weaponMap = new HashMap<>();

        weaponMap.put("arc", new Weapon("arc", 50));
        weaponMap.put("massue", new Weapon("massue", 30));
        weaponMap.put("epée", new Weapon("epée", 25));

        return weaponMap;
    }
}
