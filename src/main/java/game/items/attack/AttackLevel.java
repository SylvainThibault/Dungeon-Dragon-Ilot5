package game.items.attack;

import game.ennemies.Dragon;
import game.ennemies.Enemy;
import game.ennemies.Sorcerer;
import game.ennemies.Succubus;

public class AttackLevel {
    private int attackDragon;
    private int attackSuccubus;
    private int attackSorcerer;

    public AttackLevel(int attack){
        this.attackDragon = attack;
        this.attackSorcerer = attack;
        this.attackSuccubus = attack;
    }

    public AttackLevel(int attackDragon, int attackSorcerer, int attackSuccubus){
        this.attackDragon = attackDragon;
        this.attackSuccubus = attackSuccubus;
        this.attackSorcerer = attackSorcerer;
    }

    public int getAttack(Enemy enemy){
        if (enemy instanceof Dragon){
            return this.attackDragon;
        } else if (enemy instanceof Succubus){
            return this.attackSuccubus;
        } else if (enemy instanceof Sorcerer){
            return this.attackSorcerer;
        }
        return 0;
    }

    @Override
    public String toString() {
        String message;
        if (this.attackSorcerer == this.attackDragon && this.attackSuccubus == this.attackSorcerer){
            if (this.attackSorcerer != 0){
                message = this.attackSorcerer + " damage against all ennemies";
            } else {
                message = "this does nothing -_-";
            }
        } else{
            message = "damage against dragons: " + this.attackDragon +
                    "\ndamage against succubus: " + this.attackSuccubus +
                    "\ndamage against sorcerers: " + this.attackSorcerer;
        }
        return message;
    }
}
