package assignments.singleton_pattern;

public class CheesePizza extends Pizza {
    SingletonLogger logger = SingletonLogger.getInstance();
    PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        toppings.add(ingredientFactory.createParmesan());
        logger.log("INFO", "The pizza is being prepared!");
    }
}