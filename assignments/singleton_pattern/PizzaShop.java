package assignments.singleton_pattern;

import labs.abstract_factory.Pizza;

public abstract class PizzaShop {
    public final Pizza orderPizza(String type) {
        SingletonLogger logger = SingletonLogger.getInstance();
        Pizza pizza = createPizza(type);

        if (pizza != null) {
            pizza.prepare();
            logger.log("INFO", "The pizza is being prepared!");
            pizza.bake();
            logger.log("WARN", "The oven is heating up a few degrees too high!");
            logger.log("CRITICAL", "The pizza is burning!");
            pizza.cut();
            logger.log("WARN", "The cut is not centered!");
            pizza.box();
            logger.log("WARN", "Even though the pizza exists, make sure it's being made correctly!");
        }

        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}