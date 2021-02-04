package Creational.AbstractFactory;


import Creational.AbstractFactory.Factory.Abstract.PizzaStore;
import Creational.AbstractFactory.Factory.Concrete.ChicagoPizzaStore;
import Creational.AbstractFactory.Factory.Concrete.NYPizzaStore;
import Creational.AbstractFactory.Product.Abstract.Pizza;

public class FactoryMethodMain {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();
        Pizza nyPizza = nyStore.orderPizza("cheese");
        Pizza chicagoPizza = chicagoStore.orderPizza("clam");
        System.out.println(nyPizza.getName());
        System.out.println(chicagoPizza.getName());
        System.out.println(nyPizza.toString());
        System.out.println(chicagoPizza.toString());
    }
}
