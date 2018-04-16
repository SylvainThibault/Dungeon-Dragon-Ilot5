package game;

import game.ennemies.Enemy;
import game.interfaces.TypeCombat;
import game.items.attack.Spell;

public class Wizard extends Perso {
    private Spell spell;
    private int philter;

    public Wizard(String name, Spell spell, int philter) {
        super(name);
        this.spell = spell;
        this.philter = philter;
    }

    public Wizard(String name, Spell spell) {
        super(name);
        this.spell = spell;
        this.philter = 0;
    }

    public Wizard(){}

    //ACCESSEURS//

    public Spell getSpell() {
        return this.spell;
    }

    public int getPhilter() {
        return this.philter;
    }

    // MUTATEURS//

    public void setSpell(Spell Spell) {
        this.spell = Spell;
    }

    public void setPhilter(int Philter) {
        this.philter = Philter;
    }

    public void setTypeCombat(TypeCombat typeCombat){
        spell.setTypeCombat(typeCombat);
    }

    // Méthode toString : Affiche les informations d'un objet
    public String toString() {
        return super.toString() + "\nSpell : " + spell.toString() + "\nPhilter : " + philter;
    }

    @Override
    public String getPersoType() {
        return "wizard";
    }

    @Override
    public String getWeaponType() {
        return "spell";
    }

    @Override
    public int getBonusDamage() {
        int bonusDamage = 0;
        if (spell != null){
            bonusDamage = (int) (spell.getPower() * spell.getBonusDamageModifier());
        }
        return bonusDamage;
    }
    @Override
    public int getDefenseBonus() {
        if (spell != null){
            return philter + spell.getDefenseBonus();
        }
        return philter;
    }

//    @Override
//    public String getPersoType() {
//        return "Wizard";
//    }
//
//    @Override
//    public String getWeaponType() {
//        return "Spell";
//    }

}
