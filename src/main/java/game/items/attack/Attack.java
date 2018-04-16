package game.items.attack;

import game.ennemies.Enemy;
import game.items.Item;

public abstract class Attack extends Item{

    private AttackLevel attackLevel;
    private DefenseLevel defenseLevel;

    public Attack(String name, AttackLevel attackLevel, DefenseLevel defenseLevel) {
        super(name);
        this.attackLevel = attackLevel;
        this.defenseLevel = defenseLevel;
    }


//    public int getLevel() {
//        return this.level;
//    }


    public void setAttackLevel(AttackLevel attackLevel) {
        this.attackLevel= attackLevel;
    }

//    public abstract int getDamage(Enemy enemy);

    @Override
    public String toString() {
        return "name: " + this.getName() + "\nattack level: " + this.attackLevel.toString() +
                "\ndefense level: " + this.defenseLevel.toString();
    }

    public int getLevel(Enemy enemy){
        return this.attackLevel.getAttack(enemy);
    }

    public int getDefense(Enemy enemy){
        return this.defenseLevel.getDefenseBonus(enemy);
    }

    public AttackLevel getAttackLevel() {
        return this.attackLevel;
    }
}
