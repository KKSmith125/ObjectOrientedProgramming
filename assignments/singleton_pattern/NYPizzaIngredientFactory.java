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
        logger.log("INFO", "The dough is being created!");
        sauce = ingredientFactory.createSauce();
        logger.log("INFO", "The pizza is getting spread!");
        cheese = ingredientFactory.createCheese();
        toppings.add(ingredientFactory.createParmesan());
    }
}