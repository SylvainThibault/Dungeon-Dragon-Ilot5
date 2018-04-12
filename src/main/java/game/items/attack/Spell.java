package game.items.attack;
import game.items.defense.Defense;

import java.util.HashMap;
import java.util.Map;

public class Spell extends Attack {

    public Spell(String name,AttackLevel attackLevel){
        super(name,attackLevel, new DefenseLevel());
    }

    public Spell(String name, AttackLevel attackLevel, DefenseLevel defenseLevel){
        super(name, attackLevel, defenseLevel);
    }

    public static Map<Integer,Spell>getSpell(){
        Map<Integer,Spell>spellMap =new HashMap<>();
        spellMap.put(1,new Spell("Lightning",new AttackLevel(25,50,0)));
        spellMap.put(2,new Spell("Invisibility",new AttackLevel(30)));
        spellMap.put(3,new Spell("Fire wall",new AttackLevel(25), new DefenseLevel(0,3,0)));
        return spellMap;
    }

//    public static void showSpell() {
//        for (Map.Entry<Integer, Spell> entry : Spell.getSpell().entrySet()) {
//            System.out.println(entry.getKey()+"\n"+ entry.getValue().toString()+"\n");
//        }
//    }


}
