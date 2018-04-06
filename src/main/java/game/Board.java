package game;

import game.ennemies.EnemiesGenerator;
import game.ennemies.Enemy;
import game.items.ItemGenerator;
import game.items.attack.Spell;
import game.items.attack.Weapon;
import game.items.powerup.Bonus;
import game.items.powerup.Joker;
import game.items.powerup.Malus;
import java.util.ArrayList;
import java.util.Arrays;

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
    public static Object Squares[] = new Object[63];
    public static int boardSize = Squares.length;

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

    public Board generateNewBoard() {
        Arrays.fill(Squares, null);
        this.randomizeSquareContent(EnemiesGenerator.getEnemies());
        this.randomizeSquareContent(ItemGenerator.getItems());

        return this;
    }

    public Object[] getSquares() {
        return Squares;
    }

    public void randomizeSquareContent(ArrayList contentArray) {
        int numberOfItems = contentArray.size();
        while (numberOfItems > 0) {
            Integer randomNum = Methods.generateRandomNum(0,boardSize-1);
            if (Squares[randomNum] == null) {
                Squares[randomNum] = contentArray.get(numberOfItems - 1);
                numberOfItems--;
            }
        }
    }
}


