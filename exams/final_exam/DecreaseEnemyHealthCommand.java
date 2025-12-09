package exams.final_exam;

public class DecreaseEnemyHealthCommand implements Command {
    Enemy enemy;

    public DecreaseEnemyHealthCommand(Enemy enemy) {
        this.enemy = enemy;
    }
    
    @Override
    public void execute(int health) {
        enemy.reduceHealth(health);
    }
}
