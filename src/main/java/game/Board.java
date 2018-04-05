package game;


import game.ennemies.Dragon;
import game.ennemies.Enemy;
import game.ennemies.Sorcerer;
import game.ennemies.Succubus;
import game.items.powerup.Bonus;
import game.items.powerup.Joker;
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

    private int boardSize = Squares.length;

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


    public Boolean playTurn(Perso player) {

        int getCurrentSquare = this.getCurrentSquare();
        System.out.println("current square : " + currentSquare);

        int diceResult = diceResult();
        System.out.println("dice result : " + diceResult);

        int newCurrentSquareIndex = getCurrentSquare + diceResult;
        Object newCurrentSquare;

        try {
            newCurrentSquare = this.Squares[newCurrentSquareIndex];
        } catch (Exception e) {
            this.setCurrentSquare(boardSize);
            System.out.println("You reached the last square");
            return false;
        }

        this.setCurrentSquare(newCurrentSquareIndex);

        if (newCurrentSquare != null) {
            System.out.println(newCurrentSquare.toString());

            if (newCurrentSquare instanceof Bonus) {
                if (newCurrentSquareIndex <= (boardSize - ((Bonus) newCurrentSquare).getBonus())) {
                    newCurrentSquareIndex += ((Bonus) newCurrentSquare).getBonus();
                    this.setCurrentSquare(newCurrentSquareIndex);
                } else {
                    this.setCurrentSquare(boardSize);
                    System.out.println("You reached the last square");
                    return false;
                }
            }

            if (newCurrentSquare instanceof Malus) {
                newCurrentSquareIndex -= ((Malus) newCurrentSquare).getMalus();
                this.setCurrentSquare(newCurrentSquareIndex);
            }

            if(newCurrentSquare instanceof Joker){
                int bonusLife = ((Joker) newCurrentSquare).getBonusLife();
                int newPlayerLife = player.getLife() + bonusLife;
                player.setLife(newPlayerLife);
                System.out.println("Congratulations ! You've earned " + bonusLife + " bonus life. Your new life is set to : " + player.getLife());
                return true;
            }

            if (newCurrentSquare instanceof Enemy) {
                Boolean fightResult = ((Enemy) newCurrentSquare).fight(player);
                if(fightResult == null){
                    System.out.println("You lost the game");
                    System.out.println("You will never be a Eric\n");
                    return true;
                }
                if(fightResult){
                    newCurrentSquareIndex += 2;
                    this.setCurrentSquare(newCurrentSquareIndex);
                    return true;
                }
                newCurrentSquareIndex -= 2;
                this.setCurrentSquare(newCurrentSquareIndex);
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

    public void randomizeSquareContent(ArrayList contentArray) {
        int numberOfItems = contentArray.size();
        while (numberOfItems > 0) {
            Integer randomNum = ThreadLocalRandom.current().nextInt(0, boardSize);
            if (this.Squares[randomNum] == null) {
                this.Squares[randomNum] = contentArray.get(numberOfItems - 1);
                numberOfItems--;
            }
        }
    }
}


