package Behavioural.Command.Simple;

import Behavioural.Command.Simple.Commands.Command;

public abstract class Invoker {
    protected Command command;

    public void setCommand(Command c) {
        command = c;
    }

    public abstract void run();
}
