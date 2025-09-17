package assignments.strategy_pattern;

import java.util.ArrayList;
import java.util.Scanner;

public class StrategyGame {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String chosenCharacter;
        String chosenWeapon;
        Character player = null;

        ArrayList<String> characterSpecies = new ArrayList<>();

        characterSpecies.add("knight");
        characterSpecies.add("archer");
        characterSpecies.add("mage");
        characterSpecies.add("rogue");
        characterSpecies.add("barbarian");

        System.out.println("Hello!");
        System.out.println("What class are you?");
        System.out.println("Choose:");
        System.out.print("\t");
        for (String characterChar : characterSpecies) {
            System.out.print(characterChar + " ");
        }
        System.out.println("");

        chosenCharacter = userInput.nextLine();

        if (chosenCharacter.equalsIgnoreCase("knight")) {
            player = new Character(new Knight(), new Sword());
        } else if (chosenCharacter.equalsIgnoreCase("archer")) {
            player = new Character(new Archer(), new Arrows());
        } else if (chosenCharacter.equalsIgnoreCase("mage")) {
            player = new Character(new Mage(), new Fireball());
        } else if (chosenCharacter.equalsIgnoreCase("rogue")) {
            player = new Character(new Rogue(), new Sword());
        } else if (chosenCharacter.equalsIgnoreCase("barbarian")) {
            player = new Character(new Barbarian(), new Arrows());
        }

        System.out.println("Oh no! A Dragon!!!");
        System.out.println("           ,  ,");
        System.out.println("           \\\\ \\\\");
        System.out.println("           ) \\\\ \\\\    _p_");
        System.out.println("           )^\\))\\))  /  *\\");
        System.out.println("            \\_|| || / /^`-'");
        System.out.println("   __       -\\ \\\\--/ /");
        System.out.println(" <'  \\___/   ___. )'");
        System.out.println("      `====\\ )___/\\\\");
        System.out.println("           //     `\"");
        System.out.println("           \\    /  \\");

        ArrayList<String> characterWeapons = new ArrayList<>();

        characterWeapons.add("sword");
        characterWeapons.add("arrows");
        characterWeapons.add("fireball");

        System.out.println("Attack it!!");
        System.out.println("Please choose the weapon you want for this battle!");
        System.out.print("\t");
        for (String characterChar : characterWeapons) {
            System.out.print(characterChar + " ");
        }
        System.out.println("");

        chosenWeapon = userInput.nextLine();

        if (chosenWeapon.equalsIgnoreCase("sword")) {
            player.setCharacterWeapon(new Sword());
        } else if (chosenWeapon.equalsIgnoreCase("arrows")) {
            player.setCharacterWeapon(new Arrows());
        } else if (chosenWeapon.equalsIgnoreCase("fireball")) {
            player.setCharacterWeapon(new Fireball());
        }

        System.out.println("The " + player.turnSpecies() + " swings a " + player.fireWeapon() + "!");

        userInput.close();
    }
}
