package Structural.Facade;

public class DvdPlayer {
    private String description;
    private Amplifier amplifier;

    public DvdPlayer(String d, Amplifier a) {
        description = d;
        amplifier = a;
    }

    public void on() {
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }

    public void eject() {
        System.out.println(description + " eject");
    }

    public void play() {
        System.out.println(description + " playing");
    }

    public void play(String movie) {
        System.out.printf("%s playing %s\n", description, movie);
    }

    public void stop() {
        System.out.println(description + " stopped");
    }

    public void pause() {
        System.out.println(description + " paused");
    }

    public String toString() {
        return description;
    }
}
