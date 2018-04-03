package game;


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
    public Object Squares[] = new Object[64];


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
    }

    public Boolean playTurn() {
        int diceResult = diceResult();
        System.out.println("dice result : "+ diceResult);
        int getCurrentSquare = this.getCurrentSquare();
        System.out.println("current square : "+ currentSquare);
        int newCurrentSquare = getCurrentSquare + diceResult;

        if (newCurrentSquare >= 10){
            this.setCurrentSquare(10);
            System.out.println("You reached the last square");
            return false;
        } else {
            this.setCurrentSquare(newCurrentSquare);
            System.out.println("Your Character is now at Square n°" + currentSquare);
            return true;
        }
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
}
