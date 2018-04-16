package game.items.attack.levels;

import game.combat.combatenemy.CombatDragon;
import game.combat.combatenemy.CombatSorcier;
import game.combat.combatenemy.CombatSuccube;
import game.interfaces.TypeCombat;

import java.util.HashMap;
import java.util.Map;

public class AttackLevel {
    private Map<String, Integer> attackAgainstEnemies = new HashMap<>();

    public AttackLevel(){}

    public AttackLevel(int attackDra, int attackSor, int attackSuc){
        this.setAttackAgainstEnemies(new CombatDragon(), attackDra);
        this.setAttackAgainstEnemies(new CombatSuccube(), attackSuc);
        this.setAttackAgainstEnemies(new CombatSorcier(), attackSor);
    }

    public AttackLevel(int attack){
        this.setAttackAgainstEnemies(new CombatDragon(), attack);
        this.setAttackAgainstEnemies(new CombatSuccube(), attack);
        this.setAttackAgainstEnemies(new CombatSorcier(), attack);
    }

    public void setAttackAgainstEnemies(TypeCombat typeCombat, int attackValue){
        attackAgainstEnemies.put(typeCombat.getName(), attackValue);
    }

    public int getAttackBonusAgainst(TypeCombat typeCombat) {
        int attackBonus = 0;
        if (attackAgainstEnemies.containsKey(typeCombat.getName())) {
            attackBonus = attackAgainstEnemies.get(typeCombat.getName());
        }
        return attackBonus;
    }
}
