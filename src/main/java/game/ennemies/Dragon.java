package game.ennemies;

public class Dragon extends Enemy {

    private int age;

    public Dragon(String name, int attack, int age) {
        super(name, attack);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
