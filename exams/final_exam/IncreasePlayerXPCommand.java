package exams.final_exam;

public class IncreasePlayerXPCommand implements Command {
    Player player;

    public IncreasePlayerXPCommand(Player player) {
        this.player = player;
    }
    
    @Override
    public void execute(int xp) {
        player.gainXP(xp);
    }
}
