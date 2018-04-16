package game.combat.combatenemy;
import game.interfaces.TypeCombat;

public class CombatDragon implements TypeCombat{
    String name = "Dragon";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getBonusDamageModifier() {
        return 1;
    }
}
