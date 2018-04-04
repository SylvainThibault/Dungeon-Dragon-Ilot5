package game.items.attack;
import java.util.HashMap;
import java.util.Map;

public class Spell extends Attack {
    Spell(String name,int level){
        super(name,level);
    }

    public static Map<Integer,Spell>getSpell(){
        Map<Integer,Spell>spellMap =new HashMap<>();
        spellMap.put(1,new Spell("Lightning",50));
        spellMap.put(2,new Spell("Invisibility",30));
        spellMap.put(3,new Spell("Fire wall",25));
        return spellMap;
    }

//    public static void showSpell() {
//        for (Map.Entry<Integer, Spell> entry : Spell.getSpell().entrySet()) {
//            System.out.println(entry.getKey()+"\n"+ entry.getValue().toString()+"\n");
//        }
//    }


}
