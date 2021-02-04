package Behavioural.Command;

public class RemoteControl {
    private final Command[] onCommands;
    private final Command[] offCommands;
    private Command undoCommand;
    private final int no;

    public RemoteControl() {
        no = 7;
        onCommands = new Command[no];
        offCommands = new Command[no];
        Command noCommand = new NoCommand();
        for (int i = 0; i < no; ++i) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        if (slot < no) {
            onCommands[slot] = onCommand;
            offCommands[slot] = offCommand;
        }
    }

    public void onButtonWasPushed(int slot) {
        if (onCommands[slot] != null) {
            onCommands[slot].execute();
            undoCommand = onCommands[slot];
        }
    }

    public void offButtonWasPushed(int slot) {
        if (offCommands[slot] != null) {
            offCommands[slot].execute();
            undoCommand = offCommands[slot];
        }
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    public String toString() {
        StringBuilder buff = new StringBuilder();
        buff.append("\n------ Remote Control ------\n");
        for (int i = 0; i < no; ++i) {
            buff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                    + "  " + offCommands[i].getClass().getName() + "\n");
        }
        return buff.toString();
    }
}
