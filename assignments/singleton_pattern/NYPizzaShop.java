package assignments.singleton_pattern;

public class NYPizzaShop extends PizzaShop {
    @Override
    protected Pizza createPizza(String type) {
        SingletonLogger logger = SingletonLogger.getInstance();
        Pizza pizza = null;
        final PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if (type.equalsIgnoreCase("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if (type.equalsIgnoreCase("pepperoni")) {
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");
        } else {
            logger.log("CRITICAL", "That isn't a choice!");
        }

        return pizza;
    }
}