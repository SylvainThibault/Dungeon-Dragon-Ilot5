package game.combat.combatperso;
import game.interfaces.TypeCombat;

public class CombatWarrior implements TypeCombat{
    String name = "Warrior";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getBonusDamageModifier() {
        return 1;
    }

}
