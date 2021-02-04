package Creational.AbstractFactory.Factory.Concrete;

import Creational.AbstractFactory.Factory.Abstract.PizzaIngredientFactory;
import Creational.AbstractFactory.Factory.Abstract.PizzaStore;
import Creational.AbstractFactory.Product.Abstract.Pizza;
import Creational.AbstractFactory.Product.Concrete.CheesePizza;
import Creational.AbstractFactory.Product.Concrete.ClamPizza;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();
        if (type.equalsIgnoreCase("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Chicago Style Cheese Pizza");
        } else if (type.equalsIgnoreCase("clam")) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("Chicago Style Clam Pizza");
        }
        return pizza;
    }
}
