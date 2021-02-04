package Structural.Facade;

public class PopcornPopper {
    private String description;

    public PopcornPopper(String d) {
        description = d;
    }

    public void on() {
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }

    public void pop() {
        System.out.println(description + " popping popcorn!");
    }


    public String toString() {
        return description;
    }
}
