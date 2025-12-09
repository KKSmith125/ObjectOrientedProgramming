package exams.final_exam;

public class DecreasePlayerHealthCommand implements Command {
    Player player;

    public DecreasePlayerHealthCommand(Player player) {
        this.player = player;
    }
    
    @Override
    public void execute(int health) {
        player.reduceHealth(health);
    }
}
