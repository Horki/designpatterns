package Behavioural.Command;

public class LightCommand implements Command {
    private final Light light;

    public LightCommand(Light l) {
        light = l;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}
