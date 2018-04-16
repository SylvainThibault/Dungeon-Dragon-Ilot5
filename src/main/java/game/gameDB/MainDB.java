package game.gameDB;

import game.Methods;
import game.Perso;
import game.PlayMethods;
import game.items.attack.Attack;

import static game.Methods.checkIfAnswerIsInResults;

public class MainDB {

    public static void main(String[] args) {
        int createOrChoseCharacter = characterMenu();
        Perso character = createCharacter(createOrChoseCharacter);

        int chosenItem = SQLQueries.chooseItemFromDB(character);
        Attack newItem = SQLQueries.createItem(chosenItem);
        PlayMethods.addWeaponToPerso(character, newItem);
        System.out.println(character.toString());

        boolean play;
        do {
            character.setLife(100);
            play = PlayMethods.newGame(character);
        } while (play);
    }

    public static int characterMenu() {
        System.out.println("Welcome to DD-ilot5");
        System.out.println("What do you want to do :\n 1. Create Character\n 2. Choose Character in database");
        int numberChosen = Methods.chooseNumber();
        numberChosen = checkIfAnswerIsInResults(numberChosen, 2);

        return numberChosen;
    }

    public static Perso createCharacter(int characterMenuAnswer) {
        Perso character = null;
        switch (characterMenuAnswer) {
            case 1:
                character = PlayMethods.createCharacterFromScratch();
                SQLQueries.createPersoInDB(character);
                break;
            case 2:
                int chosenPerso = SQLQueries.choosePersoFromDB();
                character = SQLQueries.createPersoFromDB(chosenPerso);
                break;
            default:
                System.out.println("You're in createCharacter Switch default case (HINT : You shouldn't)");
                break;
        }
        return character;
    }
}

