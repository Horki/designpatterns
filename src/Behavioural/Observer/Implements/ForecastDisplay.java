package Behavioural.Observer.Implements;

import Behavioural.Observer.Interfaces.Display;
import Behavioural.Observer.Interfaces.CustomObserver;
import Behavioural.Observer.Interfaces.Subject;

public class ForecastDisplay implements CustomObserver, Display {
    private Subject subject;
    private float currentPressure;
    private float lastPressure;


    public ForecastDisplay(Subject s) {
        subject = s;
        subject.registerObserver(this);
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
    public void update(float t, float h, float p) {
        lastPressure = currentPressure;
        currentPressure = p;
        display();
    }
}
