package Structural.Facade;

public class Tuner {
    String description;
    double frequency;

    public Tuner(String d) {
        description = d;
        frequency = 0f;
    }

    public void on() {
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }

    public void setFrequency(double f) {
        frequency = f;
        System.out.println(description + " setting frequency to " + frequency);
    }

    public void setAm() {
        System.out.println(description + " setting AM mode");
    }

    public void setFm() {
        System.out.println(description + " setting FM mode");
    }

    public String toString() {
        return description;
    }
}
