package exams.final_exam;

import java.util.Random;

public class Dungeon {
    private int floor;
    private int size;
    private OldDungeonRoom[][] rooms;
    private int playerX = 0;
    private int playerY = 0;
    private OldDungeonRoom bossRoom;
    private Random random;

    public Dungeon(){
        floor = 1;
        size = 5;
        random = new Random();
        rooms =  new OldDungeonRoom[size][size];
        createRooms();
    }

    private void createRooms(){
        createBossAndKeyRooms();
        createPlayerSpawnRoom();
        //Fills in the rooms array with geeral size 5 (preset) rooms on the current floor (preset but can be changed).
        for(int y = 0; y < rooms.length; ++y){
            for (int x = 0; x < rooms[y].length; x++) {
                if(rooms[y][x] == null){
                    rooms[y][x] = new OldDungeonRoom(floor, x, y, size);
                }
            }
        }
    }

    public void newFloor(){
        ++floor;
        System.out.println("\nYou descend down, deeper into the dungeon!");
        rooms =  new OldDungeonRoom[size][size];
        createRooms();
    }

    //Creates Boss and Key Rooms in a random location in the rooms array
    private void createBossAndKeyRooms(){
        Random random = new Random();
        int x = random.nextInt(size);
        int y = random.nextInt(size);
        rooms[y][x] = new OldDungeonRoom(floor, x, y, size, "key");
        boolean bossRoomEmpty = true;
        while(bossRoomEmpty){
            x = random.nextInt(size);
            y = random.nextInt(size);
            if(rooms[y][x] == null){
                rooms[y][x] = new OldDungeonRoom(floor, x, y, size, "boss");
                bossRoomEmpty = false;
                bossRoom = rooms[y][x];
            } 
        }
    }

    //A win happens when you make it to floor 5 and beat the boss
    public boolean beaten(){
        return ((floor >= 5) && bossRoom.getEnemy().isDefeated());
    }

    //Creates a spawn room at a random spot in the rooms array and puts the player's location in that room
    private void createPlayerSpawnRoom(){
        Random random = new Random();
        int x;
        int y;
        boolean playerRoomEmpty = true;
        while(playerRoomEmpty){
            x = random.nextInt(size);
            y = random.nextInt(size);
            if(rooms[y][x] == null){
                rooms[y][x] = new OldDungeonRoom(floor, x, y, size, "player");
                playerRoomEmpty = false;
                playerX = x;
                playerY = y;
            } 
        }
    }

    //Get which room the player is in
    public OldDungeonRoom getCurrentRoom(){
        return rooms[playerY][playerX];
    }

    //Decides whether the player can move into the next room in a certain direction
    public void movePlayer(String direction){
        switch (direction.toLowerCase()) {
            case "north":
            case "n":
                if(playerY <= 0){
                    System.out.println("There is no door to the " + direction.toLowerCase() + ", you cannot go that way.\n");
                } else {
                    System.out.println("You move " + direction.toLowerCase() + " into the next room.");
                    --playerY;
                }
                break;
            case "south":
            case "s":
                if(playerY >= (size - 1)){
                    System.out.println("There is no door to the " + direction.toLowerCase() + ", you cannot go that way.\n");
                } else {
                    System.out.println("You move " + direction.toLowerCase() + " into the next room.");
                    ++playerY;
                }
                break;
            case "east":
            case "e":
                if(playerX >= (size - 1)){
                    System.out.println("There is no door to the " + direction.toLowerCase() + ", you cannot go that way.\n");
                } else {
                    System.out.println("You move " + direction.toLowerCase() + " into the next room.");
                    ++playerX;
                }
                break;
            case "west":
            case "w":
                if(playerX <= 0){
                    System.out.println("There is no door to the " + direction.toLowerCase() + ", you cannot go that way.\n");
                } else {
                    System.out.println("You move " + direction.toLowerCase() + " into the next room.");
                    --playerX;
                }
                break;
            default:
                break;
        }

        //Marks the entered room as discovered
        getCurrentRoom().discoverRoom();
    }

    //Has player move in a random location and calls the above method to enter a new room
    public void playerRuns(){
        int randomDirection = random.nextInt(4);
        String direction = "";
        switch (randomDirection) {
            case 0:
                direction = "north";
                break;
            case 1:
                direction = "south";
                break;
            case 2:
                direction = "east";
                break;
            case 3:
                direction = "west";
                break;
            
            default:
                break;
        }
        System.out.println("You try and run " + direction + "!");
        movePlayer(direction);
    }

    //Returns what room the player is in
    public void look(){
        System.out.println(getCurrentRoom());
    }

    //Return the String describing the layout of the overall Dungeon
    public String toString(){
        StringBuffer dungeonInfo = new StringBuffer();
        dungeonInfo.append("\n");
        dungeonInfo.append("Dungeon size: ");
        dungeonInfo.append(size);
        dungeonInfo.append("\n");
        dungeonInfo.append("Player X/Y: ");
        dungeonInfo.append(playerX);
        dungeonInfo.append(", ");
        dungeonInfo.append(playerY);
        dungeonInfo.append("\n");
        for (OldDungeonRoom[] dungeonRooms : rooms) {
            for (OldDungeonRoom dungeonRoom : dungeonRooms) {
                dungeonInfo.append(dungeonRoom);
                dungeonInfo.append("\n");
            }
        }
        
        return dungeonInfo.toString();
    }

    //Prints where the player is in relation to the overrall map of the Dungeon
    public void map(){
        System.out.printf("Player Coordinates: X: %d, Y: %d \n", playerX, playerY);
        for(int y = 0; y < rooms.length; ++y){
            for (int x = 0; x < rooms[y].length; x++) {
                if (y == playerY && x == playerX) {
                    System.out.print("|X");
                } else {
                    System.out.print("|" +  rooms[y][x].getRoomIcon());
                }
                if(x == (rooms[y].length - 1)){
                        System.out.println("|");
                }
            }
        }
    }
}