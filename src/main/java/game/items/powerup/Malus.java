package game.items.powerup;

public class Malus extends PowerUp{
    private int malus;

    public int getMalus() {
        return malus;
    }

    public void setMalus(int malus) {
        this.malus = malus;
    }

    public Malus(String name, int malus) {
        super(name);
        this.setMalus(malus);

    }
    @Override
    public String toString() {
        return "name: " + this.getName() + ", malus: " + this.getMalus();
    }

}
