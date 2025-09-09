import java.util.Scanner;

public class Animal {
    String name;
    String sound;
    String foodBehavior;

    public Animal(String name, String sound, String foodBehavior) {
        this.name = name;
        this.sound = sound;
        this.foodBehavior = foodBehavior;
    }

    public String getName() {
        return name;
    }

    public String getSound() {
        return sound;
    }

    public String getBehavior() {
        return foodBehavior;
    }

    public void printAnimal() {
        System.out.println("A " + name + " is a kind of " + foodBehavior);
        System.out.println("They make a " + sound);
    }
}
