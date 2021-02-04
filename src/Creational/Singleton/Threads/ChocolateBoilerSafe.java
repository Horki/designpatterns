package Creational.Singleton.Threads;

public class ChocolateBoilerSafe {
    private static ChocolateBoilerSafe uniqueInstance = new ChocolateBoilerSafe();
    private boolean empty;
    private boolean boiled;

    private ChocolateBoilerSafe() {
        empty = true;
        boiled = false;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
        }
    }

    public static ChocolateBoilerSafe getInstance() {
        return uniqueInstance;
    }


    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
