package game.combat.combatenemy;
import game.interfaces.TypeCombat;

public class CombatSuccube implements TypeCombat {
    private String name = "Succube";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getBonusDamageModifier() {
        return 0.5;
    }
}
