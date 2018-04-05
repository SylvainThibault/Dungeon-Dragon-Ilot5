package game.ennemies;

public class Enemy {

    private String name;
    private int attack;

    public Enemy(String name, int attack) {
        this.name = name;
        this.attack = attack;
    }

    public Enemy() {
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                '}';
    }

    public void fight() {
        System.out.println("FIIIIIIIIIIIIIIIIIIIIIGHT!!!!!!!!!!!");
    }
}
