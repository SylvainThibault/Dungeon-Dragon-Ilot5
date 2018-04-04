package game.items.defense;

import game.items.Item;

public abstract class Defense extends Item{

    private int level;

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
