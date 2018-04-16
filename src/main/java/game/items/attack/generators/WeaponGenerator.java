package game.items.attack.generators;

import game.combat.combatenemy.CombatDragon;
import game.combat.combatperso.CombatWarrior;
import game.combat.combatenemy.CombatSuccube;
import game.items.attack.Weapon;

import java.util.HashMap;
import java.util.Map;

public class WeaponGenerator {
    public static Weapon arc(String name){
        Weapon monArc = new Weapon();
        monArc.setName(name);

        /** Définition des dégats de l'arc contre les ennemis **/

        monArc.setPowerAgainst(new CombatDragon(), 50);
        monArc.setPowerAgainst(new CombatSuccube(), 25);

        return monArc;
    }

    public static Weapon epee(String name){
        Weapon monEpee = new Weapon();
        monEpee.setName(name);
        
        /** Définition des dégats de l'épée contre les ennemis**/

        monEpee.setPowerAgainst(new CombatSuccube(), 25);
        monEpee.setPowerAgainst(new CombatDragon(), 25);
        monEpee.setPowerAgainst(new CombatWarrior(), 25);

        /** Définition des défenses de l'épée contre les ennemis**/

        monEpee.setDefenseLevel(new CombatSuccube(), 2);
        monEpee.setDefenseLevel(new CombatDragon(), 2);
        monEpee.setDefenseLevel(new CombatWarrior(), 2);
        return monEpee;
    }

    public static Weapon massue(String name) {
        Weapon massue = new Weapon();
        massue.setName(name);

        massue.setPowerAgainst(new CombatSuccube(), 30);
        massue.setPowerAgainst(new CombatDragon(), 30);
        massue.setPowerAgainst(new CombatWarrior(), 30);

        return massue;
    }

    public static Map<Integer,Weapon> getBaseWeapons() {
        Map<Integer,Weapon> weapons = new HashMap<>();
        weapons.put(1,epee("épée de base"));
        weapons.put(2,arc("arc de base"));
        weapons.put(3,massue("massue de base"));

        return weapons;
    }
}
