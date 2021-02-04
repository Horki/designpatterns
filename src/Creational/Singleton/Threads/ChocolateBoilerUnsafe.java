package Creational.Singleton.Threads;

public class ChocolateBoilerUnsafe {
    private static ChocolateBoilerUnsafe uniqueInstance;
    private boolean empty;
    private boolean boiled;

    private ChocolateBoilerUnsafe() {
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

    public static ChocolateBoilerUnsafe getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ChocolateBoilerUnsafe();
        }
        return uniqueInstance;
    }


    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
