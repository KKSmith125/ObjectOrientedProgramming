package assignments.strategy_pattern;

import java.util.Scanner;

public class TemplateMethodRecipe {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String userChoice;
        Food userFood = null;
        Drink userDrink = null;

        System.out.println("Hello! We are going to learn how to make breakfast!");
        System.out.println("What do you want for breakfast?");
        System.out.println("Choose eggs or pancakes.");

        userChoice = userInput.nextLine();

        if (userChoice.equalsIgnoreCase("eggs")) {
            userFood = new Egg();
        } else if (userChoice.equalsIgnoreCase("pancakes")) {
            userFood = new Pancakes();
        }

        userFood.gatherIngredients();
        userFood.prepareFood();
        userFood.serveFood();

        System.out.println("Would you like coffee or tea as well?");

        userChoice = userInput.nextLine();

        if (userChoice.equalsIgnoreCase("coffee")) {
            userDrink = new Coffee();
        } else if (userChoice.equalsIgnoreCase("tea")) {
            userDrink = new Tea();
        }

        userDrink.boilWater();
        userDrink.createDrink();
        userDrink.serveDrink();

        if (userChoice.equalsIgnoreCase("coffee")) {
            System.out.println("Would you like milk and sugar with your coffee (y/n)?");
            userChoice = userInput.nextLine();
            if (userChoice.equalsIgnoreCase("y") || userChoice.equalsIgnoreCase("yes")) {
                userDrink.addMore();
            }
        }

        System.out.println("Enjoy your Breakfast!");

        userInput.close();
    }
}