package game.gameDB;
import game.Perso;
import game.PlayMethods;
import game.items.attack.Attack;
import java.util.*;

public class MainDB {

    public static void main(String[] args) {

        Perso character = PlayMethods.createCharacter();
        SQLQueries.createPersoInDB(character);
        int chosenItem = SQLQueries.chooseItemFromDB(character);
        Attack newItem = SQLQueries.createItem(chosenItem);
        PlayMethods.addWeaponToPerso(character, newItem);
//        System.out.println(character.toString());

        boolean play;
        do {
            character.setLife(100);
            play = PlayMethods.newGame(character);
        } while (play);
    }
}

