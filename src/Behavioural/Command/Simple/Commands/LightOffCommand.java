package Behavioural.Command.Simple.Commands;

import Behavioural.Command.Simple.Buttons.Light;

public class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light l) {
        light = l;
    }

    public void execute() {
        light.off();
    }

}
