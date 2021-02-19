package Structural.Facade;

public class CdPlayer {
    private String description;
    private int currentTrack;
    private String title;

    public CdPlayer(String d) {
        description = d;
        currentTrack = 1;
    }

    public void on() {
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }

    public void eject() {
        title = null;
        System.out.println(description + " eject");
    }

    public void play(String t) {
        title = t;
        currentTrack = 1;
        System.out.println(description + " playing '" + title + "'");
        System.out.printf("%s playing %3d:'%s'\n", description, title);
    }

    public void play(int track) {
        currentTrack = track;
        if (title == null) {
            System.out.printf("%s can't play track %03d, no cd inserted\n", description, currentTrack);
        } else {
            System.out.printf("%s playing track: %03d\n", description, currentTrack);
        }
    }

    public void stop() {
        currentTrack = 0;
        System.out.println(description + " stopped");
    }

    public void pause() {
        System.out.println(description + " paused '" + title + "'");
    }

    public String toString() {
        return description;
    }
}
