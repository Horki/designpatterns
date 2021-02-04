package Behavioural.Command;

public class CeilingFan {
    private String location;
    private int speed;
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    public CeilingFan(String l) {
        location = l;
    }

    public void high() {
        speed = HIGH;
        System.out.println(location + " ceiling fan is high");
    }

    public void medium() {
        speed = MEDIUM;
        System.out.println(location + " ceiling fan is medium");
    }

    public void low() {
        speed = LOW;
        System.out.println(location + " ceiling fan is low");
    }

    public void off() {
        speed = OFF;
        System.out.println(location + " ceiling fan is off");
    }

    public int getSpeed() {
        return speed;
    }
}
