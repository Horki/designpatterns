package Creational.AbstractFactory.Product.Concrete;

import Creational.AbstractFactory.Factory.Abstract.PizzaIngredientFactory;
import Creational.AbstractFactory.Product.Abstract.Pizza;

public class CheesePizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        ingredientFactory = pizzaIngredientFactory;
    }

    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
