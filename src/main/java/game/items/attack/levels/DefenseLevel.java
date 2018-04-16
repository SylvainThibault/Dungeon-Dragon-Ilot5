package game.items.attack.levels;

import game.combat.CombatDragon;
import game.combat.CombatSorcier;
import game.combat.CombatSuccube;
import game.interfaces.TypeCombat;

import java.util.HashMap;
import java.util.Map;

public class DefenseLevel {
    private Map<String, Integer> defenseAgainstEnemies = new HashMap<>();

    public DefenseLevel(){

    }

    public DefenseLevel(int defenseDra,int defenseSor,int defenseSuc){
        this.setDefenseAgainstEnemies(new CombatSorcier(), defenseSor);
        this.setDefenseAgainstEnemies(new CombatSuccube(), defenseSuc);
        this.setDefenseAgainstEnemies(new CombatDragon(), defenseDra);
    }

    public void setDefenseAgainstEnemies(TypeCombat typeCombat, int defenseValue){
        defenseAgainstEnemies.put(typeCombat.getName(), defenseValue);
    }

    public int getDefenseBonusAgainst(TypeCombat typeCombat) {
        int defenseBonus = 0;
        if (defenseAgainstEnemies.containsKey(typeCombat.getName())) {
            defenseBonus = defenseAgainstEnemies.get(typeCombat.getName());
        }
        return defenseBonus;
    }
}
