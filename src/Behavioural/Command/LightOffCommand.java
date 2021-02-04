package Behavioural.Command;

public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light l) {
        light = l;
    }

    public void execute() {
        light.off();
    }

    public void undo() {
        light.on();
    }
}
