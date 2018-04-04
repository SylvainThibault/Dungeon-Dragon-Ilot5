package game.items.defense;

public class Philter extends Defense{

    public Philter(String name, int level) {
        super(name, level);
    }

    @Override
    public String toString() {
        return "name: " + this.getName() + ", level: " + this.getLevel();
    }
}
