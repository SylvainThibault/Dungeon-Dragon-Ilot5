package game;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Methods {

    public static int generateRandomNum(int between, int and){
        return ThreadLocalRandom.current().nextInt(between, and + 1);
    }

    public static Boolean choiceString(String isTrue,String isFalse){
        Scanner sc =new Scanner(System.in);
        String userChoice = sc.next();
        if (userChoice.equals(isTrue)){
            return true;
        }else if (userChoice.equals(isFalse)){
            return false;
        }
        return null;
    }

    public static int chooseNumber() {
        System.out.println("Pick a Number :");
        int answer;
        Scanner sc = new Scanner(System.in);
        try {
            answer = sc.nextInt();
        } catch (Exception e) {
            System.out.println("A number dummy.");
            return chooseNumber();
        }
        System.out.println("You typed : " + answer);
        return answer;
    }

    public static int checkIfAnswerIsInResults(int numberChosen, int resultLength) {
        try {
            if (1 > numberChosen || numberChosen > resultLength) {
                throw new InputMismatchException();
            }
            return numberChosen;
        } catch (InputMismatchException e) {
            System.out.println("Wrong Entry");
            numberChosen = chooseNumber();
            return checkIfAnswerIsInResults(numberChosen, resultLength);
        }
    }
}

