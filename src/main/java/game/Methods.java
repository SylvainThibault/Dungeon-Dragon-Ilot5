package game;

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
}

