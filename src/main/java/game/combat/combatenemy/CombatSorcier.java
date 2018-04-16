package game.combat.combatenemy;

import game.interfaces.TypeCombat;

public class CombatSorcier implements TypeCombat{
    private String name = "Sorcier";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getBonusDamageModifier() {
        return 1;
    }
}
