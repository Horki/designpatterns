package Behavioural.Observer.ImplementsJava;

import Behavioural.Observer.Interfaces.Display;

import java.util.Observable;
import java.util.Observer;

public class Forecast implements Observer, Display {
    private float currentPressure;
    private float lastPressure;


    public Forecast(Observable o) {
        o.addObserver(this);
        currentPressure = 29.9f;
    }

    @Override
    public void display() {
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same.");
        } else {
            System.out.println("Watch out for cooler, rainy weather.");
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData w = (WeatherData) o;
            lastPressure = currentPressure;
            currentPressure = w.getPressure();
            display();
        }
    }
}

