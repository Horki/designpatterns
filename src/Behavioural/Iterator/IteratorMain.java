package Behavioural.Iterator;

import java.util.ArrayList;

public class IteratorMain {
    public static void main(String[] args) {
        PancakeHouseAggregateMenu pancakeHouseMenu = new PancakeHouseAggregateMenu();
        DinerAggregateMenu dinerMenu = new DinerAggregateMenu();
        CafeAggregateMenu cafeMenu = new CafeAggregateMenu();
        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu, cafeMenu);
        waitress.printMenu();
        // -----
        System.out.println("Iterable!");
        ArrayList<AggregateMenu> arrayList = new ArrayList<>();
        arrayList.add(pancakeHouseMenu);
        arrayList.add(dinerMenu);
        arrayList.add(cafeMenu);
        WaitressIterable waitressIterable = new WaitressIterable(arrayList);
        waitressIterable.printMenu();
    }
}
