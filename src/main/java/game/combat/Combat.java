package game.combat;

import game.interfaces.Fightable;

public class Combat {
    private Fightable attaquant, defenseur;

    public Combat(Fightable attaquant, Fightable defenseur){
        this.attaquant = attaquant;
        this.defenseur = defenseur;
    }

    public String start(){

        attaquant.setTypeCombat(defenseur.getTypeCombat());
        defenseur.setTypeCombat(attaquant.getTypeCombat());

        if (!attaquant.doesFight() || !defenseur.doesFight()){
            return "no fight";
        }
        int damageTaken;
        /** Affichage de qui attaque **/
//        attaquant.printAttack();

        /** Calcul des dégats infligés **/

        damageTaken = attaquant.getTotalDamage();

        /** Réduction de la vie du défenseur **/

        defenseur.takeDamage(damageTaken);

        System.out.println(attaquant.getName() + " inflige " + damageTaken + " à " + defenseur.getName() + "(Force :"
                            + attaquant.getPower() + " dégats de l'arme :" + attaquant.getBonusDamage() + ")");
        System.out.println(defenseur.getName() + " : nouvelle vie : " + defenseur.getLife());

        /** Si le défenseur survit : **/

        if (defenseur.getLife() > 0) {
            System.out.println(defenseur.getName() + " réplique !");

            /** Calcul des dégats infligés **/

            damageTaken = defenseur.getTotalDamage();

            /** Réduction de la vie de l'attaquant **/

            attaquant.takeDamage(damageTaken);

            System.out.println(defenseur.getName() + " inflige " + damageTaken + " à " + attaquant.getName() +" qui a " + attaquant.getDefenseBonus() +" de défense!");
            System.out.println(attaquant.getName() + " : nouvelle vie : " + attaquant.getLife());

            if (attaquant.getLife() <= 0){
                return "dead";
            }
            return "lose";
        }

        System.out.println("Vous avez vaincu " + defenseur.getName() + "!");
        return "win";
    }
}
