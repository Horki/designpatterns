package Structural.Facade;

public class FacadeMain {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier("Amplifier");
        Tuner tuner = new Tuner("AM/FM Tuner");
        DvdPlayer player = new DvdPlayer("Streaming Player");
        CdPlayer cd = new CdPlayer("CD Player");
        Projector projector = new Projector("Projector");
        TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
        Screen screen = new Screen("Theater Screen");
        PopcornPopper popper = new PopcornPopper("Popcorn Popper");

        HomeTheaterFacade homeTheater =
                new HomeTheaterFacade(amp, tuner, player, cd, projector, lights, screen, popper);

        homeTheater.watchMovie("Raiders of the Lost Ark");
        homeTheater.endMovie();
    }
}
