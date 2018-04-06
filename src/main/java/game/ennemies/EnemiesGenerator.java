package game.ennemies;

import java.util.ArrayList;

public class EnemiesGenerator {

    public static ArrayList<Enemy> getEnemies() {

        ArrayList<Enemy> enemies = new ArrayList<>();

        int[] dragAttack = {80, 60, 40, 30, 20, 15};
        int[] otherAttack = {40, 50, 25, 15};

        int[] dragLife = {80, 60, 40, 30, 20, 15};
        int[] otherLife = {40, 50, 25, 15};

        int[] dragAge = {10, 15, 40, 30, 20, 15};

        for (int i = 0; i < 6; i++) {
            enemies.add(new Dragon("Drago" + i, dragAttack[i], dragLife[i], dragAge[i]));
        }

        for (int i = 0; i < 4; i++) {
            enemies.add(new Sorcerer("Sorcerer" + i, otherAttack[i], otherLife[i]));
        }

        for (int i = 0; i < 4; i++) {
            enemies.add(new Succubus("Succ" + i, otherAttack[i], otherLife[i]));
        }
        return enemies;
    }
}
