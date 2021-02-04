package Structural.Facade;

interface Facade {
    void watchMovie(String movie);

    void endMovie();

    void listenToRadio(double frequency);

    void endRadio();
}

public class HomeTheaterFacade implements Facade {
    private Amplifier amp;
    private Tuner tuner;
    private DvdPlayer dvd;
    private CdPlayer cdplayer;
    private Projector projector;
    private TheaterLights lights;
    private Screen screen;
    private PopcornPopper popper;

    public HomeTheaterFacade(Amplifier a,
                             Tuner t,
                             DvdPlayer d,
                             CdPlayer cd,
                             Projector p,
                             TheaterLights l,
                             Screen s,
                             PopcornPopper pp) {
        amp = a;
        tuner = t;
        dvd = d;
        cdplayer = cd;
        projector = p;
        lights = l;
        screen = s;
        popper = pp;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        popper.on();
        popper.pop();
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setDvd(dvd);
        amp.setSurroundSound();
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);
    }


    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        popper.off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        dvd.stop();
        dvd.eject();
        dvd.off();
    }

    public void listenToRadio(double frequency) {
        System.out.println("Tuning in the airwaves...");
        tuner.on();
        tuner.setFrequency(frequency);
        amp.on();
        amp.setVolume(5);
        amp.setTuner(tuner);
    }

    public void endRadio() {
        System.out.println("Shutting down the tuner...");
        tuner.off();
        amp.off();
    }
}
