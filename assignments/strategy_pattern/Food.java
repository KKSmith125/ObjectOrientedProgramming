package assignments.strategy_pattern;

public abstract class Food {
    public final void order() {
        gatherIngredients();
        prepareFood();
        serveFood();
    }

    public void gatherIngredients() {
        System.out.println("Gather your ingredients.");
    }

    public void prepareFood() {
        System.out.println("Prepare your food.");
    }

    public final void serveFood() {
        System.out.println("Serve the food.");
        System.out.println("Serve on plate with any condiments you want.");
        System.out.println("Enjoy!");
    }
}
