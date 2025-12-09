package exams.final_exam;

public class DungeonRoomFactory extends PartFactory {
    @Override
    protected AbstractDungeonRoom createRoom(int floorLevel, int roomX, int roomY, int dungeonSize, String roomType) {
        AbstractDungeonRoom dungeonRoom;

        switch (roomType) {
            case "normal":
                dungeonRoom = new RegularRoom(floorLevel, roomX, roomY, dungeonSize);
                break;
            case "player":
                dungeonRoom = new SpawnRoom(floorLevel, roomX, roomY, dungeonSize);
                break;
            case "key": 
                dungeonRoom = new KeyRoom(floorLevel, roomX, roomY, dungeonSize);
                break;
            case "boss":
                dungeonRoom = new BossRoom(floorLevel, roomX, roomY, dungeonSize);
                break;
            default:
                throw new IllegalArgumentException("Unknown room type: " + roomType);
        }

        return dungeonRoom;
    }
}
