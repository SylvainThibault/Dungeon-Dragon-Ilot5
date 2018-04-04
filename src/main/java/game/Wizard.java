package game;

import game.items.attack.Spell;

public class Wizard extends Perso {
    private Spell spell;
    private int philter;


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

    // Méthode toString : Affiche les informations d'un objet
    public String toString() {
        return super.toString() + "\nSpell : " + spell.toString() + "\nPhilter : " + philter;
    }
}
