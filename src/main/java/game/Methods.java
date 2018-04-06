package game;

import java.util.concurrent.ThreadLocalRandom;

public class Methods {

    public static int generateRandomNum(int between, int and){
        return ThreadLocalRandom.current().nextInt(between, and + 1);
    }
}

