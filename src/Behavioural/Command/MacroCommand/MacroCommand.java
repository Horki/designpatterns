package Behavioural.Command.MacroCommand;

import Behavioural.Command.Command;

public class MacroCommand implements Command {
    private Command[] commands;

    public MacroCommand(Command[] c) {
        commands = c;
    }

    @Override
    public void execute() {
        for (int i = 0; i < commands.length; ++i) {
            commands[i].execute();
        }
    }

    @Override
    public void undo() {
        for (int i = 0; i < commands.length; ++i) {
            commands[i].undo();
        }
    }
}
