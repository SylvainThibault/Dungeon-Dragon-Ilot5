package game.items.attack;

import game.items.Item;

public abstract class Attack extends Item{

    private int level;

    Attack(){
    }

    Attack(String name, int level){
        this.setName(name);
        this.setLevel(level);
    }

    /**
     * Getter of the level attribute
     * @return power level of the weapon / spell
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * Setter of the level attribute
     * @param level integer value of the power level of the weapon / spell
     */

    public void setLevel(int level) {
        this.level = level;
    }

//    public abstract int getDamage(Enemy enemy);

    @Override
    public String toString() {
        return "name: " + this.getName() + ", level: " + this.getLevel();
    }
}
