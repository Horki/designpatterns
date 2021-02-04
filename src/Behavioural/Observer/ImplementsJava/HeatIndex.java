package Behavioural.Observer.ImplementsJava;

import Behavioural.Observer.Interfaces.Display;

import java.util.Observable;
import java.util.Observer;

public class HeatIndex implements Observer, Display {
    private float headIndex;

    public HeatIndex(Observable o) {
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData w = (WeatherData) o;
            headIndex = computeHeatIndex(w.getTemperature(), w.getHumidity());
            display();
        }
    }

    public void display() {
        System.out.println("Heat index is " + headIndex);
    }

    private static float computeHeatIndex(float t, float rh) {
        return ((16.923f + (0.185212f * t) + (5.37941f * rh) - (0.100254f * t * rh) +
                (0.00941695f * (t * t)) + (0.00728898f * (rh * rh)) +
                (0.000345372f * (t * t * rh)) - (0.000814971f * (t * rh * rh)) +
                (0.0000102102f * (t * t * rh * rh)) - (0.000038646f * (t * t * t)) + (0.0000291583f *
                (rh * rh * rh)) + (0.00000142721f * (t * t * t * rh)) +
                (0.000000197483f * (t * rh * rh * rh)) - (0.0000000218429f * (t * t * t * rh * rh)) +
                0.000000000843296f * (t * t * rh * rh * rh)) -
                (0.0000000000481975f * (t * t * t * rh * rh * rh)));
    }
}
