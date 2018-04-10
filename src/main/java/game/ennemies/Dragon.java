package game.ennemies;

import game.Perso;

public class Dragon extends Enemy {

    private int age;

    public Dragon(String name, int attack, int life, int age) {
        super(name, attack, life);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String fight(Perso perso){
        if( perso instanceof Perso){
            int persoPower = perso.getPower();
            int attackLevel= perso.getBonusDamage(this);
            int degat = persoPower + attackLevel;
            int lifeEnemy =this.getLife();

            System.out.println("Perso strength : " + degat + " // " + lifeEnemy + " : Enemy's life");

            lifeEnemy = lifeEnemy-degat;

            return fightResult(lifeEnemy, perso);
        }
        return "no fight";
    }

}
