package Behavioural.Observer.ImplementsJava;

import Behavioural.Observer.Interfaces.Display;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditions implements Observer, Display {
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditions(Observable o) {
        o.addObserver(this);
        temperature = 0f;
        humidity = 0f;
        pressure = 0f;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData w = (WeatherData) o;
            temperature = w.getTemperature();
            humidity = w.getHumidity();
            pressure = w.getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.printf("Current conditions: %.3f F degrees and %.2f humidity, and pressure %.3f\n",
                temperature, humidity, pressure);
    }
}
