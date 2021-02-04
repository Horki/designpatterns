package Behavioural.Command;

public class Light {
    private final String location;

    public Light(String l) {
        location = l;
    }

    public void on() {
        System.out.println(location + " light is on");
    }

    public void off() {
        System.out.println(location + " light is off");
    }
}
