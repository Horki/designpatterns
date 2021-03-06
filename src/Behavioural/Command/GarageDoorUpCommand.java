package Behavioural.Command;

public class GarageDoorUpCommand implements Command {
    private final GarageDoor garageDoor;

    public GarageDoorUpCommand(GarageDoor g) {
        garageDoor = g;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }

    @Override
    public void undo() {
        garageDoor.down();
    }
}
