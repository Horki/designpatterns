package Behavioural.Command.Simple.Commands;

import Behavioural.Command.Simple.Buttons.GarageDoor;

public class GarageDoorCommand implements Command {
    private final GarageDoor garageDoor;

    public GarageDoorCommand(GarageDoor g) {
        garageDoor = g;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }
}
