package Creational.AbstractFactory.Product.Concrete;

import Creational.AbstractFactory.Factory.Abstract.PizzaIngredientFactory;
import Creational.AbstractFactory.Product.Abstract.Pizza;

public class ClamPizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory i) {
        ingredientFactory = i;
    }

    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clams = ingredientFactory.createClam();
    }
}
