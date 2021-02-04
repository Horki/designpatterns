package Behavioural.Observer.Implements;

import Behavioural.Observer.Interfaces.CustomObserver;
import Behavioural.Observer.Interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataSubject implements Subject {
    private List<CustomObserver> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherDataSubject() {
        observers = new ArrayList<>();
        temperature = 0f;
        humidity = 0f;
        pressure = 0f;
    }

    @Override
    public void registerObserver(CustomObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(CustomObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (CustomObserver o : observers) {
            o.update(temperature, humidity, pressure);
        }
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}