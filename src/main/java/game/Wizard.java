package game;

public class Wizard extends Perso {
    private String spell;
    private int philter;


    //ACCESSEURS//

    public String getSpell() {
        return spell;
    }

    public int getPhilter() {
        return philter;
    }

    // MUTATEURS//

    public void setSpell(String pSpell) {
        spell = pSpell;
    }

    public void setPhilter(int pPhilter) {
        philter = pPhilter;
    }

    // Méthode toString : Affiche les informations d'un objet
    public String toString() {
        return super.toString() + "\nSpell : " + spell + "\nPhilter : " + philter;
    }
}
