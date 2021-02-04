package Creational.FactoryMethod.Product;

public class NYStylePizza extends Pizza {
    public NYStylePizza() {
        name = "NY Style Sauce Pizza";
        dough = "Thin Regular Dough";
        sauce = "Regular Sauce";
        toppings.add("Grated Nothing");
    }
}
