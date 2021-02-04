package Behavioural.Iterator;

public class Waitress {
    private final AggregateMenu pancakeHouseMenu;
    private final AggregateMenu dinerMenu;
    private final AggregateMenu cafeMenu;

    public Waitress(AggregateMenu p, AggregateMenu d, AggregateMenu c) {
        pancakeHouseMenu = p;
        dinerMenu = d;
        cafeMenu = c;
    }

    public void printMenu() {
        IteratorPattern pancakeIterator = pancakeHouseMenu.createIterator();
        IteratorPattern dinerIterator = dinerMenu.createIterator();
        IteratorPattern cafeIterator = cafeMenu.createIterator();
        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(pancakeIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerIterator);
        System.out.println("\nDINNER");
        printMenu(cafeIterator);
    }


    private void printMenu(IteratorPattern iter) {
        while (iter.hasNext()) {
            MenuItem item = iter.next();
            System.out.print(item.getName() + ", ");
            System.out.print(item.getPrice() + " -- ");
            System.out.println(item.getDescription());
        }
    }
}
