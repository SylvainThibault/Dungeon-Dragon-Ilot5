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

        char diceYesNo;
        do {
            System.out.println("Do you want to roll the dice ?");
            Scanner sc = new Scanner(System.in);
            diceYesNo = sc.nextLine().charAt(0);
            System.out.println(rollDice());
        } while (diceYesNo == 'y');
    }

    public static Integer rollDice() {
        Integer randomNum = ThreadLocalRandom.current().nextInt(1, 7);
        return randomNum;
    }
}
