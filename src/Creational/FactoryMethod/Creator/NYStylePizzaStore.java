package Creational.FactoryMethod.Creator;

import Creational.FactoryMethod.Product.NYStyleCheesePizza;
import Creational.FactoryMethod.Product.NYStylePizza;
import Creational.FactoryMethod.Product.Pizza;

public class NYStylePizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if (type.equalsIgnoreCase("cheese")) {
            return new NYStyleCheesePizza();
        }
        return new NYStylePizza();
    }
}
