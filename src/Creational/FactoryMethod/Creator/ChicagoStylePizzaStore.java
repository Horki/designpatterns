package Creational.FactoryMethod.Creator;

import Creational.FactoryMethod.Product.ChicagoStyleCheesePizza;
import Creational.FactoryMethod.Product.ChicagoStylePizza;
import Creational.FactoryMethod.Product.Pizza;

public class ChicagoStylePizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        if (type.equalsIgnoreCase("cheese")) {
            return new ChicagoStyleCheesePizza();
        }
        return new ChicagoStylePizza();
    }
}