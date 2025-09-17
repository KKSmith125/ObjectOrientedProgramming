package assignments.strategy_pattern;

public class Coffee extends Drink {
    @Override
    public void createDrink() {
        System.out.println("Drip hot water through filter and ground coffee.");
    }

    public void addMore() {
        System.out.println("Add milk and sugar.");
    }
}
