package game.combat;

import game.interfaces.TypeCombat;

public class CombatWizard implements TypeCombat{
    String name = "Wizard";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getBonusDamageModifier() {
        return 1;
    }

}
