package Behavioural.Iterator;

public class DinerAggregateMenu implements AggregateMenu {
    private static final int MAX_ITEMS = 6;
    private int numberOfItems;
    private final MenuItem[] menuItems;

    public DinerAggregateMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        numberOfItems = 0;
        addItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of the day", "Soup of the day, with a side of potato salad", true, 3.29);
        addItem("Hot dog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.05);
    }

    public void addItem(String n, String d, boolean v, double p) {
        MenuItem menuItem = new MenuItem(n, d, v, p);
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full! Can't add item to menu");
        } else {
            menuItems[numberOfItems++] = menuItem;
        }
    }

    public IteratorPattern createIterator() {
        return new DinerMenuIterator(menuItems);
    }
}
