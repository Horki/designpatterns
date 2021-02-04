package Creational.AbstractFactory.Factory.Concrete;

import Creational.AbstractFactory.Factory.Abstract.PizzaIngredientFactory;
import Creational.AbstractFactory.Factory.Abstract.PizzaStore;
import Creational.AbstractFactory.Product.Abstract.Pizza;
import Creational.AbstractFactory.Product.Concrete.CheesePizza;
import Creational.AbstractFactory.Product.Concrete.ClamPizza;

public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if (type.equalsIgnoreCase("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("NY Cheese Pizza");
        } else if (type.equalsIgnoreCase("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("NY Clam Pizza");
        }
        return pizza;
    }
}
