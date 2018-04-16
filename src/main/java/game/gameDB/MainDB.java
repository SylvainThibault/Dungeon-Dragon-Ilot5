package game.gameDB;

import game.Perso;
import game.PlayMethods;
import game.items.Item;

public class MainDB {

    public static void main(String[] args) {
        int createOrChoseCharacter = PlayMethods.characterMenu();
        Perso character = PlayMethods.createCharacter(createOrChoseCharacter);

        int chosenItem = SQLQueries.chooseItemFromDB(character);
        Item newItem = SQLQueries.createItem(chosenItem);
        PlayMethods.addWeaponToPerso(character, newItem);
        System.out.println(character.toString());

        boolean play;
        do {
            character.setLife(100);
            play = PlayMethods.newGame(character);
        } while (play);
    }
}