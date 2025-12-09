package exams.final_exam;

public class IncreaseEnemyHealthCommand implements Command {
    Enemy enemy;

    public IncreaseEnemyHealthCommand(Enemy enemy) {
        this.enemy = enemy;
    }
    
    @Override
    public void execute(int health) {
        enemy.gainHealth(health);
    }
}
