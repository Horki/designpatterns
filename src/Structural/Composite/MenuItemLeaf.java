package Structural.Composite;

import java.util.Iterator;

public class MenuItemLeaf extends MenuComponent {
    private final String name;
    private final String description;
    private final boolean vegetarian;
    private final double price;

    public MenuItemLeaf(String n, String d, boolean v, double p) {
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

    public void print() {
        System.out.print(" " + getName());
        if (isVegetarian()) {
            System.out.print("(v)");
        }
        System.out.println(", " + getPrice());
        System.out.println("   --" + getDescription());
    }

    public Iterator createIterator() {
        return new NullIterator();
    }
}
