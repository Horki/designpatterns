package Behavioural.Observer.Implements;

import Behavioural.Observer.Interfaces.CustomObserver;
import Behavioural.Observer.Interfaces.Display;
import Behavioural.Observer.Interfaces.Subject;

public class HeatIndexDisplay implements CustomObserver, Display {
    private Subject subject;
    private float headIndex;

    public HeatIndexDisplay(Subject s) {
        subject = s;
        subject.registerObserver(this);
        headIndex = 0f;
    }

    @Override
    public void update(float t, float h, float p) {
        headIndex = computeHeatIndex(t, h);
        display();
    }

    @Override
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
