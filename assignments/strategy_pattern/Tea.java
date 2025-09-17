package assignments.strategy_pattern;

public class Tea extends Drink {
    @Override
    public void createDrink() {
        System.out.println("Steep the tea.");
    }
}
