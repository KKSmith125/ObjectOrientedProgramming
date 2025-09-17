package assignments.strategy_pattern;

public class Egg extends Food {
    @Override
    public void gatherIngredients() {
        super.gatherIngredients();
        System.out.println("Get 2 eggs.");
        System.out.println("Get 1 tablespoon of butter.");
        System.out.println("Get salt.");
        System.out.println("Get pepper.");
    }

    @Override
    public void prepareFood() {
        super.prepareFood();
        System.out.println("Crack the eggs into a bowl.");
        System.out.println("Wisk the eggs.");
        System.out.println("Melt butter in pan on medium heat.");
        System.out.println("When the butter is melted and hot, pour in eggs.");
        System.out.println("Fold eggs as they cook.");
        System.out.println("When eggs are cooked through turn off stove.");
        System.out.println("Add salt and pepper to taste.");
    }
}
