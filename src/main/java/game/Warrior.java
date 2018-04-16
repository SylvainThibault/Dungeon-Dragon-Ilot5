package game;

        import game.ennemies.Enemy;
        import game.items.attack.Weapon;

/**
 * The type Warrior.
 */
public class Warrior extends Perso {
    private Weapon weapon;
    private int shield;

    /**
     * Instantiates a new Warrior.
     *
     * @param name   the name
     * @param weapon the weapon
     * @param shield the shield
     */
    public Warrior(String name, Weapon weapon, int shield) {
        super(name);
        this.weapon = weapon;
        this.shield = shield;
    }

    /**
     * Instantiates a new Warrior.
     *
     * @param name   the name
     * @param weapon the weapon
     */
    public Warrior(String name, Weapon weapon) {
        super(name);
        this.weapon = weapon;
        this.shield = 0;
    }

    /**
     * Instantiates a new Warrior.
     */
    public Warrior(){}

    //ACCESSEURS//

    /**
     * Gets weapon.
     *
     * @return the weapon
     */
    public Weapon getWeapon() {
        return this.weapon;
    }

    /**
     * Gets shield.
     *
     * @return the shield
     */
    public int getShield() {
        return this.shield;
    }

    // MUTATEURS//

    /**
     * Set weapon.
     *
     * @param Weapon the weapon
     */
    public void setWeapon(Weapon Weapon){
        this.weapon = Weapon;
    }

    /**
     * Set shield.
     *
     * @param Shield the shield
     */
    public void setShield(int Shield){
        this.shield = Shield;
    }

    // Méthode toString : Affiche les informations d'un objet
    public String toString(){
        return super.toString() + "\nWeapon : " + weapon + "\nShield : " + shield;
    }


    /**
     * Cette méthode sert à trouver le niveau de l'arme en fonction de l'ennemi
     *
     * @param enemy est l'enemi concerné
     * @return : renvoie un int qui est le niveau d'attaque
     */
    @Override
    public int getBonusDamage(Enemy enemy) {
        return this.getWeapon().getLevel(enemy);
    }

    @Override
    public String getPersoType() {
        return "Warrior";
    }

    @Override
    public String getWeaponType() {
        return "Weapon";
    }

}