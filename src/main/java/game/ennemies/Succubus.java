package game.ennemies;

import game.combat.combatenemy.CombatSuccube;
import game.interfaces.TypeCombat;

public class Succubus extends Enemy {

    TypeCombat typeCombat;

    @Override
    public TypeCombat getTypeCombat() {
        return new CombatSuccube();
    }

    @Override
    public void setTypeCombat(TypeCombat typeCombat) {
        this.typeCombat = typeCombat;
    }

    public Succubus(String name, int attack, int life) {
        super(name, attack, life);
    }

//    @Override
//    public String fight(Perso perso) {
//        if (perso instanceof Warrior) {
//
//            int weaponLevel = perso.getBonusDamage(this) / 2;
//            int persoPower = weaponLevel + perso.getPower();
//
//            int degat = persoPower + weaponLevel;
//            int lifeEnemy = this.getLife();
//            System.out.println("Perso strength : " + degat + " // " + lifeEnemy + " : Enemy's life");
//
//            lifeEnemy = lifeEnemy - degat;
//
//            return fightResult(lifeEnemy, perso);
//        }
//        return "no fight";
//    }

    @Override
    public Boolean doesFight() {
        if(typeCombat.getName().equals("Wizard")){
            return false;
        }
        return true;
    }
}
