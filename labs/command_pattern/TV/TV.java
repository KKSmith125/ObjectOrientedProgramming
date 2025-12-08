package labs.command_pattern.TV;

public class TV {
    String name = "TV";

    public TV(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println("The " + name + " is on!");
    }

    public void off() {
        System.out.println("The " + name + " is off!");
    }

    public void up() {
        System.out.println("The " + name + " volume is going up!");
    }

    public void down() {
        System.out.println("The " + name + " volume is going down!");
    }
}
