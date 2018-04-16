package game.items.attack;
import game.interfaces.AttackItem;
import game.interfaces.DefenseItem;
import game.interfaces.TypeCombat;
import game.items.Item;
import game.items.attack.levels.AttackLevel;
import game.items.attack.levels.DefenseLevel;
import game.items.defense.Defense;

import java.util.HashMap;
import java.util.Map;

public class Spell extends Item implements DefenseItem, AttackItem {
    private TypeCombat typeCombat;
    private String name;
    private DefenseLevel defenseLevel = new DefenseLevel();
    private AttackLevel attackLevel = new AttackLevel();

    public Spell(){
    }

    public Spell (String name, AttackLevel attackLevel, DefenseLevel defenseLevel){
        this.name = name;
        this.attackLevel = attackLevel;
        this.defenseLevel = defenseLevel;
    }
    public Spell (String name, AttackLevel attackLevel){
        this.name = name;
        this.attackLevel = attackLevel;
    }

    public TypeCombat getCurrentEnemyTypeCombat() {
        return typeCombat;
    }

    public void setTypeCombat(TypeCombat typeCombat) {
        this.typeCombat = typeCombat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printAttack(String name) {
        System.out.println(name + " attaque avec " + this.name);
    }

    @Override
    public int getDefenseBonus() {
        return this.defenseLevel.getDefenseBonusAgainst(typeCombat);
    }

    public void setPowerAgainst(TypeCombat typeCombat, int attackValue){
        this.attackLevel.setAttackAgainstEnemies(typeCombat, attackValue);
    }

    public int getPower() {
        return this.attackLevel.getAttackBonusAgainst(this.typeCombat);
    }

    public double getBonusDamageModifier() {
        return typeCombat.getBonusDamageModifier();
    }

    public void setDefenseLevel(TypeCombat typeCombat, int defenseValue){
        this.defenseLevel.setDefenseAgainstEnemies(typeCombat,defenseValue);
    }

    public AttackLevel getAttackLevel() {
        return attackLevel;
    }

//    public static void showSpell() {
//        for (Map.Entry<Integer, Spell> entry : Spell.getSpell().entrySet()) {
//            System.out.println(entry.getKey()+"\n"+ entry.getValue().toString()+"\n");
//        }
//    }


}
