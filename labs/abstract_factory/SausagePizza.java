package labs.abstract_factory;

public class SausagePizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public SausagePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        sausage = ingredientFactory.createSausage();
        toppings.add(ingredientFactory.createParmesan());
        toppings.add(ingredientFactory.createSausage());

    }
}