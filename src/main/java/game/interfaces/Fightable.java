package game.interfaces;

public interface Fightable {
    /** Pour renvoyer le type de l'entité Fightable en cours**/
    TypeCombat getTypeCombat();
    /** Pour définir le type de l'adversaire du Fightable en cours**/
    void setTypeCombat(TypeCombat typeCombat);

//    void printAttack();
    /**Renvoie la vie du Fightable**/
    int getLife();
    /**Renvoie l'attaque du Fightable **/
    int getPower();
    /** Calcul et applique la perte de PV en fonction des éventuelles résistances du Fightable**/
    void takeDamage(int damageTaken);
    /** Récupère les dégats bonus du Fightable, liés à une arme ou un sort par exemple,
     * en fonction de l'adversaire en cours**/
    int getBonusDamage();
    /** Récupère le bonus de défense du Fightable, lié à un ou plusieurs équipements
     * fonction de l'ennemi en cours**/
    int getDefenseBonus();
    /** Récupère le total des dégats infligés à l'ennemi, fonction de l'ennemi et des différents
     * bonus éventuels de dégats**/
    int getTotalDamage();
    /** Récupère le nom du Fightable**/
    String getName();

    public Boolean doesFight();
}
