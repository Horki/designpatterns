package Behavioural.Command;

public class CeilingFanOffCommand implements Command {
    private CeilingFan ceilingFan;

    public CeilingFanOffCommand(CeilingFan c) {
        ceilingFan = c;
    }

    @Override
    public void execute() {
        ceilingFan.off();
    }

    @Override
    public void undo() {
        ceilingFan.high();
    }
}
