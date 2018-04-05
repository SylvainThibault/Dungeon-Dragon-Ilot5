package game.ennemies;

import game.Perso;

public class Enemy {

    private String name;
    private int attack;
    private int life;


    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public Enemy(String name, int attack, int life) {
        this.life = life;
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

    public void fight(Perso perso) {
        System.out.println("FIIIIIIIIIIIIIIIIIIIIIGHT!!!!!!!!!!!");
    }
}
