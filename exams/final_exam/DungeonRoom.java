package exams.final_exam;

public interface DungeonRoom {
    //Will be different for each room type
    void populateRoom();
    void setRoomItem();
    String getRoomType();
    int getRoomNumber();
    String getRoomIcon();

    //Only used in boss rooms
    boolean getCanUseKey();

    //Universal Methods
    void setChancesBasedOnFloorLevel();
    void spawnNewEnemy();
    boolean itemInRoom();
    String takeRoomItem();
    Enemy getEnemy();
    boolean isEnemyInRoom();
    void discoverRoom();
    String toString();
}