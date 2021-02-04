package Behavioural.Observer.Interfaces;

public interface Subject {
    void registerObserver(CustomObserver o);

    void removeObserver(CustomObserver o);

    void notifyObservers();
}
