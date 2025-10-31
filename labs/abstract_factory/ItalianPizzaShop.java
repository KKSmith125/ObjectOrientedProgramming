package labs.abstract_factory;

public class ItalianPizzaShop extends PizzaShop {
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        final PizzaIngredientFactory ingredientFactory = new ItalianPizzaIngredientFactory();

        if (type.equalsIgnoreCase("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Italian Style Cheese Pizza");
        } else if (type.equalsIgnoreCase("pepperoni")) {
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("Italian Style Pepperoni Pizza");
        } else if (type.equalsIgnoreCase("sausage")) {
            pizza = new SausagePizza(ingredientFactory);
            pizza.setName("Italian Style Sausage Pizza");
        } else if (type.equalsIgnoreCase("veggie")) {
            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("Italian Style Veggie Pizza");
        }

        return pizza;
    }
}