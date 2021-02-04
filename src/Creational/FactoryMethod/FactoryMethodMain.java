package Creational.FactoryMethod;

import Creational.FactoryMethod.Creator.ChicagoStylePizzaStore;
import Creational.FactoryMethod.Creator.NYStylePizzaStore;
import Creational.FactoryMethod.Creator.PizzaStore;
import Creational.FactoryMethod.Product.Pizza;

public class FactoryMethodMain {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYStylePizzaStore();
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();
        Pizza cheese = nyStore.orderPizza("Cheese");
        System.out.println("Ethan ordered a " + cheese.getName());
        Pizza cheeseChicago = chicagoStore.orderPizza("nope");
        System.out.println("Joel ordered a " + cheeseChicago.getName());
    }
}
