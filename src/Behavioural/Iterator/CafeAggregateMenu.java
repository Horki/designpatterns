package Behavioural.Iterator;

import java.util.Hashtable;

public class CafeAggregateMenu implements AggregateMenu {
    private final Hashtable<String, MenuItem> menuItems;

    public CafeAggregateMenu() {
        menuItems = new Hashtable<>();
        addItem("Veggie Burger and Air Fries", "Veggie burger on a whole wheat bun, lettuce, tomato, and fries", true, 3.99);
        addItem("Soup of the day", "A cup of the soup of the day, with a side salad", false, 3.69);
        addItem("Burrito", "A large burrito, with whole pinto beans, salsa, guacamole", true, 4.29);
    }

    public void addItem(String n, String d, boolean v, double p) {
        MenuItem item = new MenuItem(n, d, v, p);
        menuItems.put(item.getName(), item);
    }

    @Override
    public IteratorPattern createIterator() {
        return new CafeMenuIterator(menuItems);
    }
}
