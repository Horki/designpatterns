package Creational.Singleton;

public class Singleton {
    private static Singleton uniqueInstance;
    private int data;

    private Singleton(int d) {
        System.out.println("Init Singleton");
        data = d;
    }

    public static Singleton getSingleton() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton(42);
        }
        return uniqueInstance;
    }

    public int getData() {
        return data;
    }
}
