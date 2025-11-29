package labs.abstract_factory;

import labs.abstract_factory.ingredients.*;

public class ItalianPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThickCrust();
    }

    @Override
    public Sauce createSauce() {
        return new WhiteSauce();
    }

    @Override
    public Cheese createCheese() {
        return new Mozzarella();
    }

    @Override
    public Pepperoni createPepperoni() {
        return new Pepperoni();
    }

    @Override
    public Parmesan createParmesan() {
        return new Parmesan();
    }

    @Override
    public Sausage createSausage() {
        return new Sausage();
    }

    @Override
    public Veggies createVeggies() {
        return new Veggies();
    }
}