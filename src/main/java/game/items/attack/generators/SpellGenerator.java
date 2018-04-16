package game.items.attack.generators;

import game.combat.combatenemy.CombatDragon;
import game.combat.combatperso.CombatWarrior;
import game.combat.combatenemy.CombatSorcier;

import game.items.attack.Spell;

import java.util.HashMap;
import java.util.Map;

public class SpellGenerator {
    public static Spell eclair(String name){
        Spell monEclair = new Spell();
        monEclair.setName(name);

        /** Définition des dégats de l'éclair contre les ennemis **/

        monEclair.setPowerAgainst(new CombatSorcier(), 50);
        monEclair.setPowerAgainst(new CombatDragon(), 25);

        return monEclair;
    }

    public static Spell invisibilite(String name){
        Spell monInvisi = new Spell();
        monInvisi.setName(name);

        /** Définition des dégats de l'invisibilité contre les ennemis**/

        monInvisi.setPowerAgainst(new CombatSorcier(), 30);
        monInvisi.setPowerAgainst(new CombatDragon(), 30);
        monInvisi.setPowerAgainst(new CombatWarrior(), 30);

        return monInvisi;
    }

    public static Spell murDeFeu(String name){
        Spell monMur = new Spell();
        monMur.setName(name);

        /** Définition des dégats du mur de feu contre les ennemis**/

        monMur.setPowerAgainst(new CombatSorcier(), 25);
        monMur.setPowerAgainst(new CombatDragon(), 25);
        monMur.setPowerAgainst(new CombatWarrior(), 25);

        monMur.setDefenseLevel(new CombatSorcier(), 3);

        return monMur;
    }

    public static Map<Integer,Spell> getBaseSpells() {
        Map<Integer,Spell> spells = new HashMap<>();
        spells.put(1,eclair("éclair de base"));
        spells.put(2,invisibilite("invisibilité de base"));
        spells.put(3,murDeFeu("mur de feu de base"));

        return spells;
    }
}
