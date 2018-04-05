package game.items.powerup;

public class Joker extends PowerUp {
    private int bonusLife;

    public Joker(String name, int bonusLife) {
        super(name);
        this.setBonusLife(bonusLife);
    }

    public int getBonusLife() {
        return bonusLife;
    }

    public void setBonusLife(int bonusLife) {
        this.bonusLife = bonusLife;
    }

    @Override
    public String toString() {
        return "name: " + this.getName() + ", bonus life: " + this.getBonusLife();
    }
}
