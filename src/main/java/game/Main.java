package game;

import game.items.attack.Weapon;

import java.util.*;

import game.items.attack.Spell;
import game.items.attack.generators.SpellGenerator;
import game.items.attack.generators.WeaponGenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The type Main.
 */
public class Main {
    private static Scanner sc = new Scanner(System.in);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */

    public static void main(String[] args) {

        Perso character = createCharacter();
        boolean play = true;
        do {
            character.setLife(100);
            play = PlayMethods.newGame(character);
        } while (play);
    }

    private static Perso createCharacter() {
        String choiceCharacter;
        System.out.println("Choose your character : \n1.Warrior or \n2.Wizard");
        choiceCharacter = sc.nextLine();

        if (choiceCharacter.equals("1")) {
            System.out.println("You chose to create a warrior");
            return createWarrior();
        }
        if (choiceCharacter.equals("2")) {
            System.out.println("You chose to create a wizard");
            return createWizard();
        }
        System.out.println("Wrong Entry");
        return createCharacter();
    }


    private static Warrior createWarrior() {

        //**************** choix du nom et de l'arme ************************************************//
        System.out.println("Choose the name  : ");
        String newName = sc.nextLine();
        Weapon newWeapon = choseWeapon();

        //************** création du personnage*****************//
        Warrior warrior1 = new Warrior(newName, newWeapon);

        //Affiche le nom du personnage
        System.out.println("***********************************************");
        System.out.println("Your warrior " + warrior1.getName() + " has been created\n" +
                "He is armed with a " + warrior1.getWeapon().getName());
        System.out.println("***********************************************");

        System.out.println("Start Playing!");

        return warrior1;
    }

    private static Wizard createWizard() {

        //**************** choix du nom et de l'arme ************************************************//
        System.out.println("Choose the name  : ");
        String newName = sc.nextLine();
        Spell newSpell = choseSpell();

        //************** création du personnage*****************//
        Wizard wizard1 = new Wizard(newName, newSpell);

        //Affiche le nom du personnage créé avec le message "personnage créé"
        System.out.println("***********************************************");
        System.out.println("Your wizard " + wizard1.getName() + " has been created\n" +
                "he can launch the spell " + wizard1.getSpell().getName());
        System.out.println("***********************************************");

        System.out.println("Start Playing!");

        return wizard1;
    }

    private static Spell choseSpell() {
        Map<Integer, Spell> spellMap = SpellGenerator.getBaseSpells();
        System.out.println("Choose a spell");
        for (Map.Entry<Integer, Spell> entry : spellMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getName());
        }
        try {
            int spellId = sc.nextInt();
//            sc.nextLine();
            if (spellId < 1 || spellId > 3) {
                throw new InputMismatchException();
            }
            return spellMap.get(spellId);
        } catch (InputMismatchException e) {
            System.out.println("Wrong Entry");
            sc.nextLine();
            return choseSpell();
        }
    }

    private static Weapon choseWeapon() {
        Map<Integer, Weapon> weaponMap = WeaponGenerator.getBaseWeapons();
        System.out.println("Choose a weapon");

        for (Map.Entry<Integer, Weapon> entry : weaponMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getName());
        }
        try {
            int armeId = sc.nextInt();
            if (armeId < 1 || armeId > 3) {
                throw new InputMismatchException();
            }
            return weaponMap.get(armeId);
        } catch (InputMismatchException e) {
            System.out.println("Wrong Entry");
            sc.nextLine();
            return choseWeapon();
        }
    }
}

