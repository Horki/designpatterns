package Behavioural.TemplateMethod;

public class TemplateMethodMain {
    private static void run(CaffeineBeverage t) {
        t.prepare();
    }

    public static void main(String[] args) {
        CaffeineBeverage tea = new Tea();
        CaffeineBeverage coffee = new CoffeeWithHook();
        run(tea);
        System.out.println("=================");
        run(coffee);
    }
}
