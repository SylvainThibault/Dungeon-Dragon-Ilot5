package game.attack;

public abstract class Attack {

    private int level;

    /**
     * Getter of the level attribute
     * @return power level of the weapon / spell
     */
    public int getLevel() {
        return level;
    }

    /**
     * Setter of the level attribute
     * @param level integer value of the power level of the weapon / spell
     */

    public void setLevel(int level) {
        this.level = level;
    }


}
