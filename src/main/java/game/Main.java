package game;

import game.attack.Weapon;
import java.util.InputMismatchException;
import java.util.Map;
import game.attack.Spell;

import java.util.Scanner;

/**
 * The type Main.
 */
public class Main {
    static Scanner sc = new Scanner(System.in);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */


    public static void main(String[] args) {
        createCharacter();
        Board newGame = new Board();
        Boolean endGame = true;
        while (endGame) {
            Scanner sc = new Scanner(System.in);
            String test = sc.nextLine();
            if (!newGame.playTurn()) {
                endGame = exitGame();
            }
        }
    }

    public static void createCharacter() {
        String choiceCharacter;
        System.out.println("Choose your character : \n1.Warrior or \n2.Wizard");
        choiceCharacter = sc.nextLine();

        if (choiceCharacter.equals("1")) {
            System.out.println("You chose to create a warrior");
            createWarrior();
        }
        if (choiceCharacter.equals("2")) {
            System.out.println("You chose to create a wizard");
            createWizard();
        }
    }


    public static void createWarrior() {
        //************** création du personnage*****************//
        Warrior warrior1 = new Warrior();

        //****************choix du nom************************************************//
        System.out.println("Choose the name  : ");
        String newName = sc.nextLine();
        warrior1.setName(newName);
        warrior1.setWeapon(choseWeapon());

        //Affiche le nom du personnage
        System.out.println("***********************************************");
        System.out.println("Your warrior " + warrior1.getName() + " has been created\n" +
                "He is armed with a " + warrior1.getWeapon().getName());
        System.out.println("***********************************************");
        System.out.println("Do you want to create another character  :\n1.Yes or \n2.No ");
        String choiceCreate;
        choiceCreate = sc.nextLine();
        if (choiceCreate.equals("1")) {
            createCharacter();
        } else {
            System.out.println("Start Playing!");
        }
    }


    public static void createWizard() {

        Wizard wizard1 = new Wizard();
        System.out.println("Choose the name  : ");
        String newName = sc.nextLine();
        wizard1.setName(newName);
        wizard1.setSpell(choseSpell());
        //Affiche le nom du personnage créé avec le message "personnage créé"
        System.out.println("***********************************************");
        System.out.println("Your wizard " + wizard1.getName() + " has been created\n" +
                "he can launch the spell " + wizard1.getSpell().getName());
        System.out.println("***********************************************");
        System.out.println("Do you want to create another character  :\n1.Yes or \n2.No ");
        String choiceCreate;
        choiceCreate = sc.nextLine();
        if (choiceCreate.equals("1")) {
            createCharacter();
        } else {
            System.out.println("Start Playing!");
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



    private static Spell choseSpell(){
        Map<Integer,Spell> spellMap= Spell.getSpell();
        System.out.println("Choose a spell");
        for( Map.Entry<Integer, Spell> entry : spellMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getName());
        }
        try {
            int spellId = sc.nextInt();
//            sc.nextLine();
            if (spellId < 1 || spellId >3){
                throw new InputMismatchException();
            }
            return spellMap.get(spellId);
        } catch (InputMismatchException e){
            System.out.println("Wrong Entry");
            sc.nextLine();
            return choseSpell();
        }
    }

    private static Weapon choseWeapon(){
        Map<Integer,Weapon> weaponMap= Weapon.getWeapons();
        System.out.println("Choose a weapon");
        for( Map.Entry<Integer, Weapon> entry : weaponMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getName());
        }
        try {
            int armeId = sc.nextInt();
            if (armeId < 1 || armeId >3){
                throw new InputMismatchException();
            }
            return weaponMap.get(armeId);
        } catch (InputMismatchException e){
            System.out.println("Wrong Entry");
            sc.nextLine();
            return choseWeapon();
        }
    }
}

