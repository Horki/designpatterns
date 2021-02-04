package Structural.Facade;

public class Screen {
    private String description;

    public Screen(String d) {
        description = d;
    }

    public void up() {
        System.out.println(description + " going up");
    }

    public void down() {
        System.out.println(description + " going down");
    }

    public String toString() {
        return description;
    }
}
