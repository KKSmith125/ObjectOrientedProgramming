package assignments.singleton_pattern;

import java.security.SignedObject;

public class PizzaTest {
    public static void main(String[] args) {
        SingletonLogger logger = SingletonLogger.getInstance();

        logger.setLevel("INFO");

        PizzaShop shop = new NYPizzaShop();

        Pizza pizza = shop.orderPizza("cheese");

        System.out.println(pizza);
    }
}