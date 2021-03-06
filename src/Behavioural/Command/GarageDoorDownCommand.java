package Behavioural.Command;

public class GarageDoorDownCommand implements Command {
    private final GarageDoor garageDoor;

    public GarageDoorDownCommand(GarageDoor g) {
        garageDoor = g;
    }

    @Override
    public void execute() {
        garageDoor.down();
    }

    @Override
    public void undo() {
        garageDoor.up();
    }
}
