package Structural.Composite;

import java.util.ArrayList;
import java.util.Iterator;

public class MenuComposite extends MenuComponent {
    private final ArrayList<MenuComponent> menuComponents;
    private final String name;
    private final String description;

    public MenuComposite(String n, String d) {
        menuComponents = new ArrayList<>();
        name = n;
        description = d;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("---------------------");
        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.print();
        }
    }

    public Iterator<MenuComponent> createIterator() {
        return new CompositeIterator(menuComponents.iterator());
    }
}
