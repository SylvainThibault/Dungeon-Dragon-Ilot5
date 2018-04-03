package game.attack;

public abstract class Attack {

    private String name;
    private int level;

    /**
     * Name Getter
     * @return Name of the weapon / spell
     */

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


}
