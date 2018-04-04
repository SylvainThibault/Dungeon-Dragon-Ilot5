package game;

import game.attack.Spell;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

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
        playDice();
        createCharacter();
        choseSpell();
    }

    public static Integer rollDice() {
        Integer randomNum = ThreadLocalRandom.current().nextInt(1, 7);
        return randomNum;
    }

    public static void playDice() {
        char diceYesNo = 'y';
        System.out.println("Do you want to roll the dice ? (y/whatever)");
        try {
            diceYesNo = sc.nextLine().charAt(0);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("!!! On a dit 'y' ou 'n' bouletto !!!\n");
            playDice();
        }
        if (diceYesNo == 'y') {
            System.out.println(rollDice());
            playDice();
        } else {
            return;
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

        //Affiche le nom du personnage
        System.out.println("***********************************************");
        System.out.println("Your warrior " + warrior1.getName() + " has been created");
        System.out.println("***********************************************");
        System.out.println("Do you want to create another character  :\n1.Yes or \n2.No ");
        String choiceCreate;
        choiceCreate = sc.nextLine();
        if (choiceCreate.equals("1")) {
            createCharacter();
        } else {
            playDice();
        }
    }


    public static void createWizard() {

        Wizard wizard1 = new Wizard();
        System.out.println("Choose the name  : ");
        String newName = sc.nextLine();
        wizard1.setName(newName);
        //Affiche le nom du personnage créé avec le message "personnage créé"
        System.out.println("***********************************************");
        System.out.println("Your wizard " + wizard1.getName() + " has been created");
        System.out.println("***********************************************");
        System.out.println("Do you want to create another character  :\n1.Yes or \n2.No ");
        String choiceCreate;
        choiceCreate = sc.nextLine();
        if (choiceCreate.equals("1")) {
            createCharacter();
        } else {
            playDice();
        }
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
}

