package Behavioural.Command;

public class Invoker {
    private Command command;

    public Invoker(Command c) {
        command = c;
    }

    public void execute() {
        command.execute();
    }
}
