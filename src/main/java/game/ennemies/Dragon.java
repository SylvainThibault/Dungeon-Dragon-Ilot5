package game.ennemies;

import game.Perso;
import game.Wizard;

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
    public Boolean fight(Perso perso){
        if( perso instanceof Perso){
            int persoPower = perso.getPower();
            int attackLevel= perso.ge.getLevel(this);
            int degat = persoPower+spellLevel;
            int lifeEnemy =this.getLife();
            System.out.println("puissance d'attaque " + degat);
            System.out.println("Vie du méchant "+ lifeEnemy);
            lifeEnemy = lifeEnemy-degat;

            fightResult(lifeEnemy, perso);
        }
        return null;
    }
}
