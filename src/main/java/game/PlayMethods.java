package game;

import game.ennemies.Enemy;
import game.items.attack.Spell;
import game.items.attack.Weapon;
import game.items.powerup.Bonus;
import game.items.powerup.Joker;
import game.items.powerup.Malus;

import java.util.Scanner;

import static game.Methods.choiceString;

public class PlayMethods {

    public static Boolean newGame(Perso character) {
        Board newBoard = new Board();
        newBoard.generateNewBoard();

        Boolean endThisGame = false;
        Boolean endGame = false;

        System.out.println("Let's go! (type 'return' to move forward)");

        while (!endThisGame) {
            // Type return to move forward
            Scanner sc = new Scanner(System.in);
            String typeReturn = sc.nextLine();

            Boolean lastSquare = !playTurn(character, newBoard);
            if (lastSquare) {
                //call the exit menu
                endGame = playNewGameMenu();
                endThisGame = true;
            }
        }
        return endGame;
    }

    private static Boolean playNewGameMenu() {
        char yesNoAnswer = 'o';
        while (yesNoAnswer != '1' && yesNoAnswer != '2') {
            System.out.println("Do you want to \n1. Start a new game or \n2. Exit ?");
            try {
                Scanner sc = new Scanner(System.in);
                yesNoAnswer = sc.nextLine().charAt(0);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("No answer, please try again :");
            }
            System.out.println("You typed : " + yesNoAnswer);
        }

        if (yesNoAnswer == '2') {
            return false;
        }
        return true;
    }

    private static Boolean playTurn(Perso player, Board newBoard) {

        int getCurrentSquare = newBoard.getCurrentSquare();
        System.out.println("current square : " + newBoard.currentSquare);

        int diceResult = Methods.generateRandomNum(1, 6);
        System.out.println("dice result : " + diceResult);

        int newCurrentSquareIndex = getCurrentSquare + diceResult;
        Object newCurrentSquare;

        try {
            newCurrentSquare = Board.Squares[newCurrentSquareIndex];
        } catch (Exception e) {
            newBoard.setCurrentSquare(Board.boardSize);
            System.out.println("You reached the last square");
            return false;
        }

        newBoard.setCurrentSquare(newCurrentSquareIndex);

        if (newCurrentSquare != null) {
            System.out.println(newCurrentSquare.toString());

            if (newCurrentSquare instanceof Bonus) {
                if (newCurrentSquareIndex <= (Board.boardSize - ((Bonus) newCurrentSquare).getBonus())) {
                    newCurrentSquareIndex += ((Bonus) newCurrentSquare).getBonus();
                    newBoard.setCurrentSquare(newCurrentSquareIndex);
                } else {
                    newBoard.setCurrentSquare(Board.boardSize);
                    System.out.println("You reached the last square");
                    return false;
                }
            }

            if (newCurrentSquare instanceof Malus) {
                newCurrentSquareIndex -= ((Malus) newCurrentSquare).getMalus();
                newBoard.setCurrentSquare(newCurrentSquareIndex);
            }

            if (newCurrentSquare instanceof Joker) {
                int bonusLife = ((Joker) newCurrentSquare).getBonusLife();
                int newPlayerLife = player.getLife() + bonusLife;
                player.setLife(newPlayerLife);
                System.out.println("Congratulations ! You've earned " + bonusLife + " bonus life. Your new life is set to : " + player.getLife());
                return true;
            }

            if (newCurrentSquare instanceof Spell && player instanceof Wizard) {
                Spell spell = ((Wizard) player).getSpell();
                String spellName = spell.getName();
                String spellLevel = spell.getAttackLevel().toString();
                System.out.println("\nYour spell : " + spellName + "\nAttack level " + spellLevel + "\nWould you like to choose this spell ? yes/no");
                Boolean userChoice = choiceString("yes", "no");
                if (userChoice == true) {
                    ((Wizard) player).setSpell((Spell) newCurrentSquare);
                    System.out.println("Congratulation ! Your new Spell is " + ((Spell) newCurrentSquare).getName());
                } else {
                    System.out.println("You haven't change your spell");
                }
                return true;
            }

            if (newCurrentSquare instanceof Weapon && player instanceof Warrior) {
                Weapon weapon = ((Warrior) player).getWeapon();
                String weaponName = weapon.getName();
                String weaponLevel = weapon.getAttackLevel().toString();
                System.out.println("\nYour weapon : " + weaponName + "\nAttack level " + weaponLevel + "\nWould you like to choose this weapon ? yes/no");
                Boolean userChoice = choiceString("yes", "no");
                if (userChoice == true) {
                    ((Warrior) player).setWeapon((Weapon) newCurrentSquare);
                    System.out.println("Congratulation ! Your new Weapon is " + ((Weapon) newCurrentSquare).getName());

                } else {
                    System.out.println("You haven't change your weapon");
                }
                return true;
            }

            if (newCurrentSquare instanceof Enemy) {
                String fightResult = ((Enemy) newCurrentSquare).fight(player);
                switch (fightResult) {
                    case "win":
                        newCurrentSquareIndex += 2;
                        newBoard.setCurrentSquare(newCurrentSquareIndex);
                        break;
                    case "lose":
                        newCurrentSquareIndex -= 2;
                        newBoard.setCurrentSquare(newCurrentSquareIndex);
                        break;
                    case "dead":
                        System.out.println("You're dead \n");
                        return false;
                    default:
                        break;
                }
                return true;
            }
        }
        return true;
    }
}
