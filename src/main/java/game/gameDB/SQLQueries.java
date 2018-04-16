package game.gameDB;
import game.Perso;
import game.Warrior;
import game.Wizard;
import game.ennemies.Dragon;
import game.ennemies.Enemy;
import game.ennemies.Sorcerer;
import game.ennemies.Succubus;
import game.items.Item;
import game.items.attack.*;
import game.items.defense.Philter;
import game.items.defense.Shield;
import game.items.powerup.Bonus;
import game.items.powerup.Joker;
import game.items.powerup.Malus;
import java.sql.*;
import java.util.ArrayList;
import static game.Methods.checkIfAnswerIsInResults;
import static game.Methods.chooseNumber;

public class SQLQueries {

    private static Connection connexionToDB() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/donjon-ilot5?" + "user=root&password=");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }

    public static void createPersoInDB(Perso perso) {
        String namePerso = perso.getName();
        String typePerso = perso.getPersoType();
        int lifePerso = perso.getLife();
        int powerPerso = perso.getPower();

        try {
            Connection conn = connexionToDB();
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "INSERT INTO persos (`name`, `type`, `life`, `power`) VALUES (? , ? , ? , ?)";
            PreparedStatement prepare = conn.prepareStatement(query);
            prepare.setString(1, namePerso);
            prepare.setString(2, typePerso);
            prepare.setInt(3, lifePerso);
            prepare.setInt(4, powerPerso);
            prepare.executeUpdate();

            prepare.close();
            state.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static int choosePersoFromDB() {
        int numberChosen = 0;
        try {
            Connection conn = connexionToDB();
            Statement state = conn.createStatement();
            String query = "SELECT * FROM persos";
            ResultSet result = state.executeQuery(query);

            int resultLength = displayQueryResultsNameAndReturnLength(result);
            numberChosen = chooseNumber();
            numberChosen = checkIfAnswerIsInResults(numberChosen, resultLength);
            state.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        int indexOfChosenPerso = numberChosen;
        return indexOfChosenPerso;
    }

    public static Perso createPersoFromDB(int indexOfChosenPerso) {
        try {
            Connection conn = connexionToDB();
            Statement state = conn.createStatement();
            String query = "SELECT * FROM persos WHERE id = ?";
            PreparedStatement prepare = conn.prepareStatement(query);
            prepare.setInt(1, indexOfChosenPerso);
            ResultSet result = prepare.executeQuery();
            result.first();

            Perso perso;

            if (result.getString("type").equals("Wizard")) {
                String persoName = result.getString("name");
                perso = new Wizard();
                perso.setName(persoName);
                return perso;
            }

            if (result.getString("type").equals("Warrior")) {
                String persoName = result.getString("name");
                perso = new Warrior();
                perso.setName(persoName);
                return perso;
            }

            prepare.close();
            state.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Attack createItem(int indexOfChosenWeapon) {
        try {
            Connection conn = connexionToDB();
            Statement state = conn.createStatement();
            String query = "SELECT * FROM items WHERE id = ?";
            PreparedStatement prepare = conn.prepareStatement(query);
            prepare.setInt(1, indexOfChosenWeapon);
            ResultSet result = prepare.executeQuery();
            result.first();

            Attack item;

            if (result.getString("type").equals("Weapon")) {
                String weaponName = result.getString("name");
                AttackLevel attackLevels = getAttackLevel(result);
                DefenseLevel defenseLevels = getDefenseLevel(result);
                item = new Weapon(weaponName, attackLevels, defenseLevels);
                return item;
            }

            if (result.getString("type").equals("Spell")) {
                String spellName = result.getString("name");
                AttackLevel attackLevels = getAttackLevel(result);
                DefenseLevel defenseLevels = getDefenseLevel(result);
                item = new Spell(spellName, attackLevels, defenseLevels);
                return item;
            }

            prepare.close();
            state.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static int chooseItemFromDB(Perso perso) {
        String typeWeapon = perso.getWeaponType();
        int numberChosen = 0;

        try {
            Connection conn = connexionToDB();
            Statement state = conn.createStatement();
            String query = "SELECT name FROM items WHERE type = ?";
            PreparedStatement prepare = conn.prepareStatement(query);
            prepare.setString(1, typeWeapon);
            ResultSet result = prepare.executeQuery();

            int resultLength = displayQueryResultsNameAndReturnLength(result);
            numberChosen = chooseNumber();
            numberChosen = checkIfAnswerIsInResults(numberChosen, resultLength);

            prepare.close();
            state.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (typeWeapon.equals("Spell")) {
            numberChosen += 3;
        }
        int indexOfChosenWeapon = numberChosen;
        return indexOfChosenWeapon;
    }

    public static ArrayList<Enemy> getEnemiesFromDB() {

        ArrayList<Enemy> enemies = new ArrayList<>();

        try {
            Connection conn = connexionToDB();
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM enemies";
            ResultSet result = state.executeQuery(query);

            while (result.next()) {
                if (result.getString("type").equals("Dragon")) {
                    String dragName = result.getString("name");
                    int dragAttack = result.getInt("power");
                    int dragLife = result.getInt("life");
                    int dragAge = result.getInt("age");
                    Dragon newDragon = new Dragon(dragName, dragAttack, dragLife, dragAge);
                    enemies.add(newDragon);
                }
                if (result.getString("type").equals("Succubus")) {
                    String sucName = result.getString("name");
                    int sucAttack = result.getInt("power");
                    int sucLife = result.getInt("life");
                    Succubus newSuccubus = new Succubus(sucName, sucAttack, sucLife);
                    enemies.add(newSuccubus);
                }
                if (result.getString("type").equals("Sorcerer")) {
                    String sorceName = result.getString("name");
                    int sorceAttack = result.getInt("power");
                    int sorceLife = result.getInt("life");
                    Sorcerer newSorcerer = new Sorcerer(sorceName, sorceAttack, sorceLife);
                    enemies.add(newSorcerer);
                }
            }
            state.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return enemies;
    }

    public static ArrayList<Item> getPowerUpsFromDB() {

        ArrayList<Item> powerUps = new ArrayList<>();

        try {
            Connection conn = connexionToDB();
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM powerups";
            ResultSet result = state.executeQuery(query);

            while (result.next()) {
                if (result.getString("type").equals("Bonus")) {
                    String bonusName = result.getString("name");
                    int bonusValue = result.getInt("value");

                    Bonus newBonus = new Bonus(bonusName, bonusValue);
                    powerUps.add(newBonus);
                }
                if (result.getString("type").equals("Malus")) {
                    String malusName = result.getString("name");
                    int malusValue = result.getInt("value");

                    Malus newMalus = new Malus(malusName, malusValue);
                    powerUps.add(newMalus);
                }
                if (result.getString("type").equals("Joker")) {
                    String jokerName = result.getString("name");
                    int jokerValue = result.getInt("value");

                    Joker newJoker = new Joker(jokerName, jokerValue);
                    powerUps.add(newJoker);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return powerUps;
    }

    public static ArrayList<Item> getBonusItemsFromDB() {
        ArrayList<Item> powerUps = new ArrayList<>();
        try {
            Connection conn = connexionToDB();
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "SELECT * FROM bonusitems";
            ResultSet result = state.executeQuery(query);

            while (result.next()) {
                if (result.getString("type").equals("Weapon")) {
                    String weaponName = result.getString("name");
                    int weaponLevel = result.getInt("level");

                    Weapon newWeapon = new Weapon(weaponName, new AttackLevel(weaponLevel));
                    powerUps.add(newWeapon);
                }
                if (result.getString("type").equals("Spell")) {
                    String spellName = result.getString("name");
                    int spellValue = result.getInt("level");

                    Spell newSpell = new Spell(spellName, new AttackLevel(spellValue));
                    powerUps.add(newSpell);
                }
                if (result.getString("type").equals("Shield")) {
                    String shieldName = result.getString("name");
                    int shieldValue = result.getInt("level");

                    Shield newShield = new Shield(shieldName, shieldValue);
                    powerUps.add(newShield);
                }
                if (result.getString("type").equals("Philter")) {
                    String philterName = result.getString("name");
                    int philterValue = result.getInt("level");

                    Philter newPhilter = new Philter(philterName, philterValue);
                    powerUps.add(newPhilter);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return powerUps;
    }

    private static int displayQueryResultsNameAndReturnLength(ResultSet result) {
        int i = 0;
        try {
            i++;
            while (result.next()) {
                System.out.println(i + ": " + result.getString("name"));
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return (i-1);
    }

    private static DefenseLevel getDefenseLevel(ResultSet result) throws SQLException {
        int defenseDra = result.getInt("defense-dra");
        int defenseSor = result.getInt("defense-sor");
        int defenseSuc = result.getInt("defense-suc");
        return new DefenseLevel(defenseDra, defenseSor, defenseSuc);
    }

    private static AttackLevel getAttackLevel(ResultSet result) throws SQLException {
        int attackDra = result.getInt("attack-dra");
        int attackSor = result.getInt("attack-sor");
        int attackSuc = result.getInt("attack-suc");
        return new AttackLevel(attackDra, attackSor, attackSuc);
    }
}
