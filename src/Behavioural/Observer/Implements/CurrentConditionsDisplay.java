package Behavioural.Observer.Implements;

import Behavioural.Observer.Interfaces.Display;
import Behavioural.Observer.Interfaces.CustomObserver;
import Behavioural.Observer.Interfaces.Subject;

public class CurrentConditionsDisplay implements CustomObserver, Display {
    private Subject subject;
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditionsDisplay(Subject s) {
        subject = s;
        subject.registerObserver(this);
        temperature = 0f;
        humidity = 0f;
    }

    @Override
    public void display() {
        System.out.printf("Current conditions: %.3f F degrees and %.2f humidity\n", temperature, humidity);
    }

    @Override
    public void update(float t, float h, float p) {
        temperature = t;
        humidity = h;
        display();
    }
}
