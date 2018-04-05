package game.items.attack;

import game.ennemies.Dragon;
import game.ennemies.Enemy;
import game.ennemies.Sorcerer;
import game.ennemies.Succubus;

public class DefenseLevel {
    private int defenseSuccubus, defenseDragon, defenseSorcerer;

    public DefenseLevel(){
        this.defenseDragon = 0;
        this.defenseSorcerer = 0;
        this.defenseSuccubus = 0;
    }

    public DefenseLevel(int defense){
        this.defenseDragon = defense;
        this.defenseSuccubus= defense;
        this.defenseSorcerer = defense;
    }

    public DefenseLevel(int defenseDragon, int defenseSorcerer, int defenseSuccubus){
        this.defenseSuccubus = defenseSuccubus;
        this.defenseSorcerer = defenseSorcerer;
        this.defenseDragon = defenseDragon;
    }

    public int getDefenseBonus(Enemy enemy){
        if (enemy instanceof Dragon){
            return this.defenseDragon;
        } else if (enemy instanceof Succubus){
            return this.defenseSuccubus;
        } else if (enemy instanceof Sorcerer){
            return this.defenseSorcerer;
        }
        return 0;
    }

    @Override
    public String toString() {
        String message;
        if (this.defenseSorcerer == this.defenseDragon && this.defenseSuccubus == this.defenseSorcerer){
            if (this.defenseSorcerer != 0){
                message = this.defenseDragon + " defense against all ennemies";
            } else {
                message = "this does nothing -_-";
            }
        } else{
            message = "defense against dragons: " + this.defenseDragon +
                    "\ndefense against succubus: " + this.defenseSuccubus +
                    "\ndefense against sorcerers: " + this.defenseSorcerer;
        }
        return message;
    }
}
