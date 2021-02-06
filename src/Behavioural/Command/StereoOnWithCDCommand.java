package Behavioural.Command;

public class StereoOnWithCDCommand implements Command {
    private final Stereo stereo;

    public StereoOnWithCDCommand(Stereo s) {
        stereo = s;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(9);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
