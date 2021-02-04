package Creational.FactoryMethod.Product;

public class ChicagoStylePizza extends Pizza {
    public ChicagoStylePizza() {
        name = "Chicago Style Pizza";
        dough = "Regular Dough";
        sauce = "Regular Sauce";
        toppings.add("Shredded Regular Sauce");
    }
}
