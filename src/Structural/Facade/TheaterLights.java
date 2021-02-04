package Structural.Facade;

public class TheaterLights {
    private String description;
    private int level;

    public TheaterLights(String d) {
        description = d;
        level = 0;
    }

    public void on() {
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }

    public void dim(int l) {
        level = l % 100;
        System.out.println(description + " dimming to " + level + "%");
    }

    public int getLevel() {
        return level;
    }

    public String toString() {
        return description + " " + level + "%";
    }
}
