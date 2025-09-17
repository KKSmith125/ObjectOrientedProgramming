package assignments.strategy_pattern;

public abstract class Drink {
    public final void order(String addition) {
        boilWater();
        createDrink();
        serveDrink();
    }

    public final void boilWater() {
        System.out.println("Boil Water.");
    }

    public abstract void createDrink();

    public abstract void addMore();

    public final void serveDrink() {
        System.out.println("Pour into cup.");
    }
}
