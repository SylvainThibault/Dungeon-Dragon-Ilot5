package game.items;

import java.util.Map;

public abstract class Item {

    private String name;

    public Item(String name) {
        this.name = name;
    }

    /**
     * Name Setter
     * @param name name of the weapon
     */

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
