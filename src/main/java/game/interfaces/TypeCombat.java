package game.interfaces;

public interface TypeCombat {

    /** Renvoie le nom du type de l'adversaire **/

    String getName();

    /** Renvoie le multiplicateur à appliquer aux dégats bonus
     * (arme ou spell) contre cet ennemi.
     * Exemple, la succube divise par 2 l'efficacité des armes du guerrier
     * la méthode getBonusDamageModifier() d'une instance de CombatSuccube renverra donc la valeur 0.5**/
    double getBonusDamageModifier();
}
