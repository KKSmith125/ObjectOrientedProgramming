package labs.abstract_factory;

public class PizzaTest {
    public static void main(String[] args) {
        // NY & Cheese Pizza Test
        PizzaShop shop = new NYPizzaShop();

        Pizza pizza = shop.orderPizza("cheese");

        System.out.println(pizza);

        // Chicago & Sausage Pizza Test
        PizzaShop shop1 = new ChicagoPizzaShop();

        Pizza pizza1 = shop1.orderPizza("sausage");

        System.out.println(pizza1);

        // Italian & Veggie/Pepperoni Pizza Test
        PizzaShop shop2 = new ItalianPizzaShop();

        Pizza pizza2 = shop2.orderPizza("veggie");
        Pizza pizza3 = shop2.orderPizza("pepperoni");

        System.out.println(pizza2);
        System.out.println(pizza3);
    }
}