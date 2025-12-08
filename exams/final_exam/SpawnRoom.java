package exams.final_exam;

import java.util.ArrayList;
import java.util.List;

public class SpawnRoom extends AbstractDungeonRoom {
    //Creates room
    public SpawnRoom(int floorLevel, int roomX, int roomY, int dungeonSize){
        super(floorLevel, roomX, roomY, dungeonSize);
        setChancesBasedOnFloorLevel();
        populateRoom();
    }

    @Override
    //Sets room populace and item based on spawn chance
    public void populateRoom() {
        itemInRoom = false;
        roomItem = "";
        discoverRoom();
    }

    @Override
    //Adds room item based on random chance and rarity
    public void setRoomItem() {
        int randomNumber = random.nextInt(100);
        itemInRoom = true;
        if(randomNumber < 20) {
            roomItem = "bag of gold";
        } else if(randomNumber < 45) {
            roomItem = "health potion";
        } else if(randomNumber < 65) {
            roomItem = "short sword";
        } else if(randomNumber < 75) {
            roomItem = "ax";
        } else if(randomNumber < 85) {
            roomItem = "long sword";
        } else if(randomNumber < 90) {
            roomItem = "greatsword";
        } else {
            roomItem = "armor part";
        }
    }

    @Override
    public String getRoomType() {
        return "player";
    }

    @Override
    //Sets the room icon for the map
    public String getRoomIcon() {
        String  roomIcon = "?";
        if(roomDiscovered){
            if(roomEnemy != null && !roomEnemy.isDefeated()){
                roomIcon = "m";
             } else if(itemInRoom){
                roomIcon = "i";
            } else {
                roomIcon = " ";
            }
        }

        return roomIcon;
    }

    @Override
    public boolean getCanUseKey() {
        return false;
    }

    @Override
    //Describes the room
    public String toString(){
        StringBuffer roomInfo = new StringBuffer();

        //Shows the ways that the player can move from here
        List<String> directionList = new ArrayList<>();
        if(roomY != 0){
            directionList.add("north");
        }
        if(roomY != dungeonSize - 1){
            directionList.add("south");
        }
        if(roomX != dungeonSize - 1){
            directionList.add("east");
        }
        if(roomX != 0){
            directionList.add("west");
        }

        roomInfo.append("\nYou are on floor number ");
        roomInfo.append(floorLevel);
        roomInfo.append("\n");

        roomInfo.append("The room you are in has doors to the ");
        for(int i = 0; i < directionList.size(); ++i){
            roomInfo.append(directionList.get(i));
            if((directionList.size() > 2) && (i < directionList.size() - 1)){
                roomInfo.append(", ");
            } else if(i == directionList.size() - 1) {
                roomInfo.append(".");
            } else {
                roomInfo.append(" ");
            }

            if(i == directionList.size() - 2){
                roomInfo.append("and ");
            }
        }
        
        //Shows what items and enemies are in the room
        roomInfo.append("\n\n");
        if(roomEnemy != null){
            roomInfo.append(roomEnemy);
        } else {
            roomInfo.append("There are no enemies in this room.\n");
        }

        if(!roomItem.equals("")){
            roomInfo.append("    ** On the ground you see a(n) ");
            roomInfo.append(roomItem);
            roomInfo.append(". **\n");
        } else {
            roomInfo.append("There are no items in this room.\n");
        }
        
        return roomInfo.toString();
    }
}