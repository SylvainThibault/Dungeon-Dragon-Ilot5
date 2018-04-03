package game;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

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

        char diceYesNo = 'y';
        do {
            System.out.println("Do you want to roll the dice ? (y/n)");
            try {
                Scanner sc = new Scanner(System.in);
                diceYesNo = sc.nextLine().charAt(0);
                System.out.println(rollDice());
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("!!! On a dit 'y' ou 'n' bouletto\n !!!");
            }
        } while (diceYesNo == 'y');
    }

    public static Integer rollDice() {
        Integer randomNum = ThreadLocalRandom.current().nextInt(1, 7);
        return randomNum;
    }
}
