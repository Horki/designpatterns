package Creational.Singleton;

public class SingletonMain {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getSingleton();
        Singleton s2 = Singleton.getSingleton();
        Singleton s3 = Singleton.getSingleton();
        System.out.printf("%d, %d, %d\n", s1.getData(), s2.getData(), s3.getData());
    }
}
