package Creational.Singleton.Threads;

public class ChocolateBoilerDoubleSafe {
    private volatile static ChocolateBoilerDoubleSafe uniqueInstance;
    private boolean empty;
    private boolean boiled;

    private ChocolateBoilerDoubleSafe() {
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

    public static ChocolateBoilerDoubleSafe getInstance() {
        if (uniqueInstance == null) {
            synchronized (ChocolateBoilerSafe.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new ChocolateBoilerDoubleSafe();
                }
            }
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
