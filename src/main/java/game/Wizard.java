package game;

public class Wizard extends Perso {
    private String spell;
    private int philter;


    //ACCESSEURS//

    public String getSpell() {
        return this.spell;
    }

    public int getPhilter() {
        return this.philter;
    }

    // MUTATEURS//

    public void setSpell(String Spell) {
        this.spell = Spell;
    }

    public void setPhilter(int Philter) {
        this.philter = Philter;
    }

    // Méthode toString : Affiche les informations d'un objet
    public String toString() {
        return super.toString() + "\nSpell : " + spell + "\nPhilter : " + philter;
    }
}
