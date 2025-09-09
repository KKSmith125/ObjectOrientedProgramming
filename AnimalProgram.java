import java.util.Scanner;

public class AnimalProgram {
    public static void main(String[] args) {
        Animal animalType1 = new Animal("capybara", "Squeak", "herbivore");
        Animal animalType2 = new Animal("lion", "Roar!!", "carnivore");
        Animal animalType3 = new Animal("alligator", "Snap!!", "carnivore");
        Animal animalType4 = new Animal("hawk", "Caw!!", "carnivore");

        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter what animal you want to know about:");
        String animal = scnr.nextLine();

        if (animal.equals(animalType1.getName())) {
            animalType1.printAnimal();
        } else if (animal.equals(animalType2.getName())) {
            animalType2.printAnimal();
        } else if (animal.equals(animalType3.getName())) {
            animalType3.printAnimal();
        } else if (animal.equals(animalType4.getName())) {
            animalType4.printAnimal();
        }
    }
}