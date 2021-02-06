package Behavioural.Command;

public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light l) {
        light = l;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}
