package Behavioural.TemplateMethod;

public abstract class CaffeineBeverage {
    protected String description;

    public final void prepare() {
        boilWater();
        brew();
        pour();
        if (costumerWantsCondiments()) {
            addCondiments();
        }
    }

    protected final void boilWater() {
        System.out.println("Boil some Water");
    }

    protected abstract void brew();

    protected final void pour() {
        System.out.printf("Pour %s in boiling water\n", description);
    }

    protected abstract void addCondiments();

    // Hook Method!!!
    protected boolean costumerWantsCondiments() {
        return true;
    }
}
