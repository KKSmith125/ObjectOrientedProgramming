package exams.final_exam;

public abstract class PartFactory {
    protected abstract AbstractDungeonRoom createRoom(int floorLevel, int roomX, int roomY, int dungeonSize, String roomType);
}
