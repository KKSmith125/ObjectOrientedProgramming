package exams.final_exam;

public class IncreasePlayerHealthCommand implements Command {
    Player player;

    public IncreasePlayerHealthCommand(Player player) {
        this.player = player;
    }
    
    @Override
    public void execute(int health) {
        player.gainHealth(health);
    }
}
