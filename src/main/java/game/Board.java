package game;

import game.gameDB.SQLQueries;
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
    public Object Squares[] = new Object[63];
    public int boardSize = Squares.length;

    /**
     * Gets current square.
     *
     * @return the current square
     */
    public int getCurrentSquare() {
        return currentSquare;
    }

    public Object[] getSquares() {
        return Squares;
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

    public void generateNewBoard() {
        Arrays.fill(Squares, null);
        this.randomizeSquareContent(SQLQueries.getEnemiesFromDB());
        this.randomizeSquareContent(SQLQueries.getPowerUpsFromDB());
        this.randomizeSquareContent(SQLQueries.getBonusItemsFromDB());
    }

    private void randomizeSquareContent(ArrayList contentArray) {
        int numberOfItems = contentArray.size();
        int emptySquares = emptySquaresLeft();
        while (numberOfItems > 0 && emptySquares > 0) {
            Integer randomNum = Methods.generateRandomNum(0, boardSize - 1);
            if (this.Squares[randomNum] == null) {
                this.Squares[randomNum] = contentArray.get(numberOfItems - 1);
                numberOfItems--;
                emptySquares--;
            }
        }
    }

    private int emptySquaresLeft() {
        int arraySize = boardSize;
        int emptySquares = 0;
        for (int i = 0; i < arraySize; i++) {
            if (this.Squares[i] == null) {
                emptySquares++;
            }
        }
//        System.out.println("Il reste " + emptySquares + " cases vides");
        return emptySquares;
    }

    @Override
    public String toString() {
        int squareIndex = 1;
        for (Object square : Squares) {
            System.out.print("Case n°" + squareIndex + " : ");
            try {
                System.out.println(square.toString());
            } catch (NullPointerException e) {
                System.out.println("empty");
            }
            squareIndex++;
        }
        return super.toString();
    }
}


