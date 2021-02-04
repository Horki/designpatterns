package Behavioural.TemplateMethod;

public class Tea extends CaffeineBeverage {
    public Tea() {
        description = "tea";
    }

    @Override
    protected void brew() {
        System.out.println("Stepping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding Lemon");
    }
}
