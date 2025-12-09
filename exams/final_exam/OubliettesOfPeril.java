package exams.final_exam;

import java.util.Scanner;

public class OubliettesOfPeril {
    private static boolean notEscaped = true;
    private static boolean moreDungeonToGo = true;
    private static boolean alwaysLookWhenMoving = true;
    private static boolean alwaysMapWhenMoving = true;
    private static StatsController statsController;
    private static DungeonFacade dungeonFacade = new DungeonFacade();

    public static void main(String[] args){
        // This code should be refacted but there should be no difference for the end user
        // There are several "necessary updates and changes"
        // You should identify where design patterns will improve the architecture
        // in addition there are updates that should happen that are just base Object Oriented Design best practices and
        // and do not necessarily fall into a design pattern.
        boolean playGame = true;
        Scanner userInputScanner = new Scanner(System.in);
        while(playGame){
            dungeonFacade.greeting();
            //Player decides whether to start the game
            playGame = dungeonFacade.enterTheDungeon(userInputScanner);
            if (playGame){ 
                Dungeon dungeon = new Dungeon();               
                Player player = new Player();
                //Setting player commands
                statsController = new StatsController();
                IncreasePlayerHealthCommand increasePlayerHealth = new IncreasePlayerHealthCommand(player);
                DecreasePlayerHealthCommand decreasePlayerHealth = new DecreasePlayerHealthCommand(player);
                IncreasePlayerXPCommand increasePlayerXP = new IncreasePlayerXPCommand(player);
                statsController.setCommand(1, increasePlayerHealth, decreasePlayerHealth, increasePlayerXP);
                notEscaped = true;
                moreDungeonToGo = true;

                System.out.println("Input 'commands' to see a list of commands");

                while(player.alive() && moreDungeonToGo && notEscaped){
                    //Loops through player decisions while they haven't beat the dungeon and are still alive
                    playerDecision(player, dungeon, userInputScanner);
                    moreDungeonToGo = !dungeon.beaten();
                }
                
                //Winning Screen
                if(!moreDungeonToGo){
                    dungeonFacade.congratualtionsOnWinning(player);
                }

                //Losing Screen
                if(!player.alive()){
                    playGame = dungeonFacade.sorryAboutLosing(userInputScanner, player);
                }
            }
        }

        userInputScanner.close();
    }

    private static void playerDecision(Player player, Dungeon dungeon, Scanner userInputScanner){
        dungeonFacade.lineOfText("-");
        System.out.println("What do you want to do?");
        String userInput = userInputScanner.nextLine().trim();
        System.out.println("");
        boolean advanceBattle = false; 
        
        //Prints command list
        if(userInput.equalsIgnoreCase("commands") || userInput.equalsIgnoreCase("command")){
            dungeonFacade.commands();
        //Gets the current room the user is in
        } else if(userInput.equalsIgnoreCase("look")){
            System.out.println(dungeon.getCurrentRoom());
        //Sets it so that the user no longer looks around when they move
        } else if(userInput.equalsIgnoreCase("al")){
            alwaysLookWhenMoving = !alwaysLookWhenMoving;
        //Same as above but not map displayed upon movement
        } else if(userInput.equalsIgnoreCase("am")){
            alwaysMapWhenMoving = !alwaysMapWhenMoving;
        //Checks player stats
        } else if(userInput.equalsIgnoreCase("check")){
            System.out.println(player);
        //Attack and run logic
        } else if(userInput.equalsIgnoreCase("attack") || 
                  userInput.equalsIgnoreCase("a") ||
                  userInput.equalsIgnoreCase("run") ||
                  userInput.equalsIgnoreCase("r")){
            //Check if there is an enemy in the room and if there is advance the battle with attack or run
            if(dungeon.getCurrentRoom().isEnemyInRoom()){
                advanceBattle = true;
                battle(player, dungeon, userInput);
            } else {
                System.out.println("There is no enemy alive in here. So you dont need to do that.");
            }
        //Display map
        } else if(userInput.equalsIgnoreCase("map")){
            dungeon.map();
        //Display bag
        } else if(userInput.equalsIgnoreCase("bag")){
            player.checkBag();
        //Grab item logic
        } else if(userInput.equalsIgnoreCase("take")){
            advanceBattle = true;
            //If there is an enemy in the room the take fails and you get attacked
            if(dungeon.getCurrentRoom().isEnemyInRoom()){
                System.out.println("You foolishly try to grab the item right in front of the enemy.");
                System.out.println("It attacks you!");
            } else {
                //If there is no enemy and there is an item, the item is taken
                if(dungeon.getCurrentRoom().itemInRoom()){
                    player.addItemToBag(dungeon.getCurrentRoom().takeRoomItem());
                } else {
                    System.out.println("There is no item in here.");
                }
            }
        //Take health potion
        } else if(userInput.equalsIgnoreCase("p") || userInput.equalsIgnoreCase("potion")){
            player.useHealthPotion();
            advanceBattle = true;
        //Equip logic (based on user input)
        } else if(userInput.equalsIgnoreCase("equip")){
            advanceBattle = true;
            System.out.println("What would you like to equip?");
            System.out.println("(Choose something from your bag)");
            String equipInput = userInputScanner.nextLine().trim();
            player.equipItem(equipInput);
        //Player wants to move in a direction
        } else if(userInput.equalsIgnoreCase("north") || 
                  userInput.equalsIgnoreCase("n") || 
                  userInput.equalsIgnoreCase("south") || 
                  userInput.equalsIgnoreCase("s") || 
                  userInput.equalsIgnoreCase("east") || 
                  userInput.equalsIgnoreCase("e") ||
                  userInput.equalsIgnoreCase("west") ||  
                  userInput.equalsIgnoreCase("w")){
            //Must run or attack enemy if present to move
            if(dungeon.getCurrentRoom().isEnemyInRoom()){
                System.out.println("You cannot move while an enemy is in the room unless you run");
            //Move player if no enemy and display chosen movement settings
            } else {
                dungeon.movePlayer(userInput);
                if(alwaysMapWhenMoving){
                    dungeon.map();
                }
                if(alwaysLookWhenMoving){
                    System.out.println(dungeon.getCurrentRoom());
                }
            }
        //Use key if present and move player up floor if key is used
        } else if(userInput.equalsIgnoreCase("key")){
            if(dungeon.getCurrentRoom().getCanUseKey()){
                if(player.useKey()){
                    dungeon.newFloor();
                }
            } else {
                System.out.println("You cannot use a dungeon key in this room.");
            }
        //Rest and heal logic (can't if enemy is present and enemy spawns after rest)
        } else if(userInput.equalsIgnoreCase("rest")){
            if(dungeon.getCurrentRoom().isEnemyInRoom()){
                System.out.println("You cannot rest while an enemy is in the room.");
            } else {
                player.rest();
                dungeon.getCurrentRoom().spawnNewEnemy();
            }
        //Exit logic
        } else if(userInput.equalsIgnoreCase("exit")){
            exitGame();
        //Invalid command
        } else {
            System.out.println("That was an invalid command.");
            System.out.println("Input the command - 'commands' to see a list of commands");
        } 

        //Enemy attack logic upon battle advance
        if(advanceBattle && dungeon.getCurrentRoom().isEnemyInRoom() && !dungeon.getCurrentRoom().getEnemy().isDefeated()){
                int enemyDamage = dungeon.getCurrentRoom().getEnemy().getDamage();
                statsController.decreaseHealthButton(1, enemyDamage);
        }      
    }

        //Attack and run logic
    public static void battle(Player player, Dungeon dungeon, String userInput){
        Enemy enemy = dungeon.getCurrentRoom().getEnemy();
        IncreaseEnemyHealthCommand increaseEnemyHealth = new IncreaseEnemyHealthCommand(enemy);
        DecreaseEnemyHealthCommand decreaseEnemyHealth = new DecreaseEnemyHealthCommand(enemy);
        statsController.setCommand(2, increaseEnemyHealth, decreaseEnemyHealth, new NoCommand());

        if(userInput.equalsIgnoreCase("attack") || userInput.equalsIgnoreCase("a")){
            int playerDamage = player.getDamage();
            statsController.decreaseHealthButton(2, playerDamage);
            player.gainXP(enemy.getLastExperience());
        } else if(userInput.equalsIgnoreCase("run") || userInput.equalsIgnoreCase("r")) {
            dungeon.playerRuns();
        }
    }
    
    private static void exitGame(){
        System.out.println("Using your escape rope you immediately leave the dungeon!");
        System.out.println("Sadly you had to leave all of your loot.\n\n");
        notEscaped = false;        
    }
}