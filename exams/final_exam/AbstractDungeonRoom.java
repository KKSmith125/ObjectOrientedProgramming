package exams.final_exam;

import java.util.Random;

public abstract class AbstractDungeonRoom implements DungeonRoom {
    protected static int nextRoomNumber = 1;

    protected int roomNumber;
    protected int floorLevel;
    protected int roomX;
    protected int roomY;
    protected int dungeonSize;
    protected Enemy roomEnemy;
    protected boolean itemInRoom;
    protected String roomItem;
    protected boolean roomDiscovered;
    protected Random random;
    protected int enemyChance;
    protected int itemChance;

    //Creates rooms and increments the nextRoomNumber to point to the next room and randomly populates the room
    public AbstractDungeonRoom(int floorLevel, int roomX, int roomY, int dungeonSize) {
        this.roomNumber = nextRoomNumber++;
        this.floorLevel = floorLevel;
        this.roomX = roomX;
        this.roomY = roomY;
        this.dungeonSize = dungeonSize;
        
        roomDiscovered = false;
        roomItem = "";
        itemInRoom = false;
        random = new Random();
    }

    @Override
    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    //Returns whether the room contains an item
    public boolean itemInRoom() {
        return itemInRoom;
    }

    @Override
    //Returns what item the player takes from the room
    public String takeRoomItem(){
        String itemTaken = roomItem;
        roomItem = "";
        itemInRoom = false;
        return itemTaken;
    }

    @Override
    public Enemy getEnemy(){
        return roomEnemy;
    }

    @Override
    public boolean isEnemyInRoom(){
        return (roomEnemy != null) && (!roomEnemy.isDefeated());
    }

    @Override
    //Sets the room as discovered
    public void discoverRoom(){
        roomDiscovered = true;
    }

    @Override
    //Spawns a new enemy if a lower chance is hit than original enemy spawn chance
    public void spawnNewEnemy(){
        int randomNumber = random.nextInt(100);

        if(randomNumber < (enemyChance - 15)){
            System.out.println("An enemy attacks you while you rest!");
            roomEnemy = new Enemy(floorLevel);
        }
    }

    @Override
    public void setChancesBasedOnFloorLevel() {
        switch (floorLevel) {
            case 1:
                enemyChance = 30;
                itemChance = 40;
                break;
            case 2:
                enemyChance = 45;
                itemChance = 50;
                break;
            case 3:
                enemyChance = 50;
                itemChance = 65;
                break;
            case 4:
                enemyChance = 60;
                itemChance = 75;
                break;
            case 5:
                enemyChance = 85;
                itemChance = 85;
                break;
            default:
                break;
        }
    }
}
