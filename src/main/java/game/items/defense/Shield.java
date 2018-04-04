package game.items.defense;

public class Shield extends Defense{
    public Shield(String name, int level) {
        super(name, level);
    }

    @Override
    public String toString() {
        return "name: " + this.getName() + ", level: " + this.getLevel();
    }
}
