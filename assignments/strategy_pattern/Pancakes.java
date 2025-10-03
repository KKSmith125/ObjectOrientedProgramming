package assignments.strategy_pattern;

public class Pancakes extends Food {
    @Override
    public void gatherIngredients() {
        super.gatherIngredients();
        System.out.println("Get 1 and 1/2 cups flour.");
        System.out.println("Get 3 and 1/2 teaspoons baking powder.");
        System.out.println("Get 2 tablespoon sugar.");
        System.out.println("Get 1 1/4 cups milk.");
        System.out.println("Get 3 tablespoons of melted butter.");
        System.out.println("Get 1 egg.");
    }

    @Override
    public void prepareFood() {
        super.prepareFood();
        System.out.println("Sift flour, baking powder, sugar, and salt together in a large bowl.");
        System.out.println("Make a well in the center and add milk, melted butter, and egg.");
        System.out.println("Mix until smooth.");
        System.out.println("Heat a lightly oiled griddle or pan over medium-high heat.");
        System.out.println("Pour or scoop the batter onto the griddle, using approximately 1/4 cup for each pancake.");
        System.out.println("Cook until bubbles form and the edges are dry, about 2 to 3 minutes.");
        System.out.println("Flip and cook until browned on the other side.");
        System.out.println("Repeat with remaining batter.");
    }
}
