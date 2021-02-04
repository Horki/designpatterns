package Structural.Composite;

import java.util.Iterator;

public class Waitress {
    private final MenuComponent menus;

    public Waitress(MenuComponent m) {
        menus = m;
    }

    public void printMenu() {
        menus.print();
    }

    public void printVegetarianMenu() {
        Iterator<MenuComponent> iter = menus.createIterator();
        System.out.println("\nVEGETARIAN MENU\n----");
        while (iter.hasNext()) {
            MenuComponent menuComponent = iter.next();
            try {
                if (menuComponent.isVegetarian()) {
                    menuComponent.print();
                }
            } catch (UnsupportedOperationException ignored) {
                // Ignore
            }
        }
    }
}
