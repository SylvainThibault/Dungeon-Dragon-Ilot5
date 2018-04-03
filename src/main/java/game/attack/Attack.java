package game.attack;

import game.Enemy;

public abstract class Attack {

    private String name;
    private int level;

    /**
     * Name Getter
     * @return Name of the weapon / spell
     */

    Attack(){
    }

    Attack(String name, int level){
        this.setName(name);
        this.setLevel(level);
    }

    public String getName() {
        return this.name;
    }

    /**
     * Name Setter
     * @param name name of the weapon
     */

    public void setName(String name) {
        this.name = name;
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
