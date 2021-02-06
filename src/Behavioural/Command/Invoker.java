package Behavioural.Command;

public class Invoker {
    private final Command command;

    public Invoker(Command c) {
        command = c;
    }

    public void execute() {
        command.execute();
    }
}
