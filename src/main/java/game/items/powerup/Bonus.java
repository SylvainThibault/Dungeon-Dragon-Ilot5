package game.items.powerup;

public class Bonus extends PowerUp{
    private int bonus;

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public Bonus(String name, int bonus) {

        super(name);
        this.bonus = bonus;
    }
}
