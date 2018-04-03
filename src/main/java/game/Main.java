package game;

import java.util.Scanner;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Board newGame = new Board();
        Boolean endGame = true;
        while (endGame) {
            Scanner sc = new Scanner(System.in);
            char test = sc.nextLine().charAt(0);
            if (!newGame.playTurn()) {
                endGame = exitGame();
            }
        }
    }

    public static Boolean exitGame() {
        char yesNoAnswer = 'o';

        while (yesNoAnswer != 'y') {
            System.out.println("Do you want to exit Game ? (y/n)");
            try {
                Scanner sc = new Scanner(System.in);
                yesNoAnswer = sc.nextLine().charAt(0);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("No answer, please try again :");
            }
            if (yesNoAnswer == 'n') {
                System.out.println("Please exit the game");
            }
            System.out.println("You typed : " + yesNoAnswer);
        }
        return false;
    }
}

