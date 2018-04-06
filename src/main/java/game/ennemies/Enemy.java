package game.ennemies;

import game.Perso;


public abstract class Enemy {

    private String name;
    private int attack;
    private int life;



    protected int getLife() {
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

    public abstract String fight(Perso perso);

    protected String fightResult(int lifeEnemy, Perso perso){
        if (lifeEnemy <= 0) {
            System.out.println("you win against " + this.getName());
            return "win";
        } else {
            int persoLife = perso.getLife();
            int attackEnemy = this.getAttack();
            if(this instanceof Dragon){
                attackEnemy += ((Dragon) this).getAge();
            }
            System.out.println("Enemy strength : " + attackEnemy);

            int newPersoLife = persoLife - attackEnemy;
            if(newPersoLife <= 0){
                return "dead";
            }

            System.out.println("you lose");
            perso.setLife(newPersoLife);
            System.out.println("new life personnage " + perso.getLife());
            return "lose";
        }
    }
}
