package Structural.Facade;

public class Amplifier {
    private String description;
    private int volume;

    public Amplifier(String d) {
        description = d;
        volume = 0;
    }

    public void on() {
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }

    public void setStereoSound() {
        System.out.println(description + " stereo mode on");
    }

    public void setSurroundSound() {
        System.out.println(description + " surround sound on (5 speakers, 1 subwoofer)");
    }

    public void setVolume(int level) {
        volume = level % 10;
        System.out.println(description + " setting volume to " + volume);
    }

    public void setTuner(Tuner tuner) {
        System.out.println(description + " setting tuner to " + tuner);
    }

    public void setDvd(DvdPlayer player) {
        System.out.println(description + " setting Streaming player to " + player);
    }

    public String toString() {
        return description;
    }
}
