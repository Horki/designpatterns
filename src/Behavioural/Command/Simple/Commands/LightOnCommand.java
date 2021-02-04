package Behavioural.Command.Simple.Commands;

import Behavioural.Command.Simple.Buttons.Light;

public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light l) {
        light = l;
    }

    public void execute() {
        light.on();
    }
}
