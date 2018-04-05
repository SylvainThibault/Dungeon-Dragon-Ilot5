package game;


import game.ennemies.Dragon;
import game.ennemies.Enemy;
import game.ennemies.Sorcerer;
import game.ennemies.Succubus;
import game.items.powerup.Bonus;
import game.items.powerup.Malus;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Board.
 */
public class Board {
    /**
     * The Current square.
     */
    public int currentSquare = 0;

    /**
     * The Squares.
     */
    public Object Squares[] = new Object[63];
    private static ArrayList<Enemy> enemies = new ArrayList<>();


    /**
     * Gets current square.
     *
     * @return the current square
     */
    public int getCurrentSquare() {
        return currentSquare;
    }

    /**
     * Sets current square.
     *
     * @param currentSquare the current square
     */
    public void setCurrentSquare(int currentSquare) {
        this.currentSquare = currentSquare;
        System.out.println("Your Character is now at Square n°" + currentSquare);
    }

    public Object[] getSquares() {
        return Squares;
    }


    public Boolean playTurn() {

        int getCurrentSquare = this.getCurrentSquare();
        System.out.println("current square : " + currentSquare);

        int diceResult = diceResult();
        System.out.println("dice result : " + diceResult);

        int newCurrentSquareIndex = getCurrentSquare + diceResult;
        Object newCurrentSquare;

        try {
            newCurrentSquare = this.Squares[newCurrentSquareIndex];
        } catch (Exception e) {
            this.setCurrentSquare(63);
            System.out.println("You reached the last square");
            return false;
        }

        this.setCurrentSquare(newCurrentSquareIndex);

        if (newCurrentSquare != null) {
            System.out.println(newCurrentSquare.toString());
            if (newCurrentSquare instanceof Bonus) {
                newCurrentSquareIndex += 5;
                this.setCurrentSquare(newCurrentSquareIndex);
            }
            if (newCurrentSquare instanceof Malus) {
                newCurrentSquareIndex -= 5;
                this.setCurrentSquare(newCurrentSquareIndex);
            }
            if (newCurrentSquare instanceof Enemy){
                ((Enemy) newCurrentSquare).fight();
            }
        }
        return true;
    }

    /**
     * Roll dice integer.
     *
     * @return the integer
     */
    public Integer diceResult() {
        Integer randomNum = ThreadLocalRandom.current().nextInt(1, 7);
        return randomNum;
    }

    public ArrayList createEnnemies() {
        int[] dragAttack = {80, 60, 40, 30, 20, 15};
        int[] otherAttack = {75, 50, 25, 15};

        for (int i = 0; i < 6; i++) {
            enemies.add(new Dragon("Drago" + i, dragAttack[i], 1));
        }

        for (int i = 0; i < 4; i++) {
            enemies.add(new Sorcerer("Sorcerer" + i, otherAttack[i]));
        }

        for (int i = 0; i < 4; i++) {
            enemies.add(new Succubus("Succ" + i, otherAttack[i]));
        }
        return enemies;
    }

    public void randomizeSquareContent(ArrayList contentArray) {
        int numberOfItems = contentArray.size();
        while (numberOfItems > 0) {
            Integer randomNum = ThreadLocalRandom.current().nextInt(0, 63);
            if (this.Squares[randomNum] == null) {
                this.Squares[randomNum] = contentArray.get(numberOfItems - 1);
                numberOfItems--;
            }
        }
    }
}


