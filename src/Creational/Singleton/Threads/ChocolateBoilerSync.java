package Creational.Singleton.Threads;

public class ChocolateBoilerSync {
    private static ChocolateBoilerSync uniqueInstance;
    private boolean empty;
    private boolean boiled;

    private ChocolateBoilerSync() {
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

    public synchronized static ChocolateBoilerSync getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ChocolateBoilerSync();
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
