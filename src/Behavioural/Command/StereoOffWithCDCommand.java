package Behavioural.Command;

public class StereoOffWithCDCommand implements Command {
    private final Stereo stereo;

    public StereoOffWithCDCommand(Stereo s) {
        stereo = s;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(9);
    }
}
