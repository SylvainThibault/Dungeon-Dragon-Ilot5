package game.items.powerup;

public class Joker extends PowerUp {
    private int bonusLife;
    public Joker(String name, int bonusLife) {
        super(name);
        this.bonusLife = bonusLife;
    }

    public int getBonusLife() {
        return bonusLife;
    }

    public void setBonusLife(int bonusLife) {
        this.bonusLife = bonusLife;
    }
}
