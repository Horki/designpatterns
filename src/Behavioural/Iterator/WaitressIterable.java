package Behavioural.Iterator;

import java.util.ArrayList;

public class WaitressIterable {
    private final ArrayList<AggregateMenu> array;

    public WaitressIterable(ArrayList<AggregateMenu> i) {
        array = i;
    }

    public void printMenu() {
        for (AggregateMenu item : array) {
            System.out.println("\n ITEM:");
            printMenu(item.createIterator());
        }
    }

    private void printMenu(IteratorPattern i) {
        while (i.hasNext()) {
            MenuItem item = i.next();
            System.out.print(item.getName() + ", ");
            System.out.print(item.getPrice() + " -- ");
            System.out.println(item.getDescription());
        }
    }

}
