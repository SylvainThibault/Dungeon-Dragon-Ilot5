package game.items.attack;

import java.util.HashMap;
import java.util.Map;

public class Weapon extends Attack {

    public Weapon(String name, AttackLevel attackLevel, DefenseLevel defenseLevel){
        super(name, attackLevel, defenseLevel);
    }

    public Weapon(String name, AttackLevel attackLevel){
        super(name, attackLevel, new DefenseLevel());
    }

    public static Map<Integer, Weapon> getWeapons() {
        Map<Integer,Weapon> weaponMap = new HashMap<>();
        weaponMap.put(1, new Weapon("bow", new AttackLevel(50,0,25)));
        weaponMap.put(2, new Weapon("mace", new AttackLevel(30)));
        weaponMap.put(3, new Weapon("sword", new AttackLevel(25), new DefenseLevel(2)));

        return weaponMap;
    }

}
