import java.util.Scanner;

public class AnimalProgram {
    public static void main(String[] args) {
        Animal capybara = new Capybara("capybara", "Squeak", "herbivore");
        Animal lion = new Lion("lion", "Roar!!", "carnivore");
        Animal alligator = new Alligator("alligator", "Snap!!", "carnivore");
        Animal hawk = new Hawk("hawk", "Caw!!", "carnivore");

        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter what animal you want to know about:");
        String animal = scnr.nextLine();

        if (animal.equals(capybara.getName())) {
            capybara.printAnimal();
        } else if (animal.equals(lion.getName())) {
            lion.printAnimal();
        } else if (animal.equals(alligator.getName())) {
            alligator.printAnimal();
        } else if (animal.equals(hawk.getName())) {
            hawk.printAnimal();
        }
    }
}