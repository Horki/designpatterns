package Behavioural.Iterator;

public class MenuItem {
    private String name;
    private String description;
    private boolean vegetarian;
    private double price;

    public MenuItem(String n, String d, boolean v, double p) {
        name = n;
        description = d;
        vegetarian = v;
        price = p;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public double getPrice() {
        return price;
    }
}
