package exams.final_exam;


import java.util.Scanner;

public class DungeonFacade {
    private static final int totalTextWidth = 80;
    private static StatsController statsController;

    //Asks whether the user wants to play the game
    public boolean enterTheDungeon(Scanner userInputScanner){
        String userInput;
        boolean shouldEnter = false;
        System.out.println("Do you wish to enter the oubliette?");
        userInput = userInputScanner.nextLine().trim();
        System.out.println("");
        if(yesChoice(userInput)){
            shouldEnter = true;
        } else {
            System.out.println("You never enter the oubliette, and you go home.");
            System.out.println("There was no peril, but also no riches.");
        }

        return shouldEnter;
    }

    public void greeting(){
        lineOfText("*");
        displayTextWithStars("Welcome to the Oubliettes Of Peril (OOP)!");
        displayTextWithStars("In this oubliette you will find monsters, loot, and... peril!");
        displayTextWithStars("If you make it to the end, you can defeat the boss and escape!");
        displayTextWithStars(" ");
        lineOfText("*");
        displayTextWithStars("Each floor contains monsters, a boss, and a key.");
        displayTextWithStars("To advance you need to find the key and defeat the boss.");
        displayTextWithStars("Then you will be able to go to the next floor using the key in the boss room.");
        displayTextWithStars(" ");
        lineOfText("*");
    }

    public void lineOfText(String text){
        char[] charArry = new char[totalTextWidth];
        String line = new String(charArry).replace("\0", text);
        System.out.println(line);
    }

    public static void displayTextWithStars(String displayText){
        String textFormat = "* %-" + (totalTextWidth -3) + "s*\n";
        System.out.printf(textFormat, displayText);
    }

    //Winner screen
    public void congratualtionsOnWinning(Player player){
        System.out.println("You have conquered the Oubliettes Of Peril!!");
        System.out.println("Congratulations!!!!");
        System.out.println("Score:");
        System.out.println(player.stats());
    }

    //Loser screen
    public boolean sorryAboutLosing(Scanner userInputScanner, Player player){
        String userInput;
        boolean playAgain = false;
        System.out.println("Sorry. You have been defeated.");
        System.out.println("Would you like to play again?");
        userInput = userInputScanner.nextLine().trim();
        System.out.println("");
        if(yesChoice(userInput)){
            playAgain = true;
        } else {
            System.out.println("Thank you for playing! I hope you try again!");
            System.out.println("Goodbye!!");
        }

        return playAgain;
    }

    public boolean yesChoice(String choice){
        boolean result = false;
        if(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")){
            result = true;
        }
        return result;
    }

    public boolean noChoice(String choice){
        boolean result = false;
        if(choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")){
            result = true;
        }
        return result;
    }

    public void commands(){
        System.out.println("You may use the following commands:");
        System.out.println("  - commands:     Shows this menu");
        System.out.println("  - look:         Looks around the room");
        System.out.println("  - al:           Toggle always look, when moving");
        System.out.println("  - check:        Look yourself");
        System.out.println("  - attack or a:  Attack an enemy if there is one");
        System.out.println("  - run or r:     Try to run from an enemy");
        System.out.println("  - map:          Look the map");
        System.out.println("  - am:           Toggle always map, when moving");
        System.out.println("  - bag:          Look in your bag");
        System.out.println("  - take:         Take an item if there is one");
        System.out.println("  - potion or p:  Use a health potion if you have one");
        System.out.println("  - equip:        Check your inventory and try to equip a new item");
        System.out.println("  - north or n:   Try to move north");
        System.out.println("  - south or s:   Try to move south");
        System.out.println("  - east or e:    Try to move east");
        System.out.println("  - west or w:    Try to move west");
        System.out.println("  - key:          Use the key on the dungeon trap door");
        System.out.println("  - rest:         Get some rest and heal. But be careful a monster can appear");
        System.out.println("  - exit:         Immediately escape the dungeon  dropping all your loot");
    }
}
