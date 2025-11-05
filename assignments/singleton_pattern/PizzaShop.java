package assignments.singleton_pattern;

import labs.abstract_factory.Pizza;

public abstract class PizzaShop {
    public final Pizza orderPizza(String type) {
        SingletonLogger logger = SingletonLogger.getInstance();
        Pizza pizza = createPizza(type);

        if (pizza != null) {
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
            logger.log("WARN", "Even though the pizza exists, make sure it's being made correctly!");
        }

        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}