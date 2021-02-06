package Behavioural.Command.MacroCommand;

import Behavioural.Command.Command;
import Behavioural.Command.NoCommand;

public class RemoteControlMacro {
    private final MacroCommand[] macroOnCommands;
    private final MacroCommand[] macroOffCommands;
    private MacroCommand undoCommand;
    private final int no;

    public RemoteControlMacro() {
        no = 2;
        macroOnCommands = new MacroCommand[no];
        macroOffCommands = new MacroCommand[no];
        NoCommand noCommand = new NoCommand();
        Command[] onCommands = {noCommand, noCommand, noCommand};
        Command[] offCommands = {noCommand, noCommand, noCommand};
        MacroCommand macroOn = new MacroCommand(onCommands);
        MacroCommand macroOff = new MacroCommand(offCommands);
        for (int i = 0; i < no; ++i) {
            macroOnCommands[i] = macroOn;
            macroOffCommands[i] = macroOff;
        }
    }

    public void setCommand(int slot, MacroCommand onCommand, MacroCommand offCommand) {
        if (slot < no) {
            macroOnCommands[slot] = onCommand;
            macroOffCommands[slot] = offCommand;
        }
    }

    public void onButtonWasPushed(int slot) {
        if (macroOnCommands[slot] != null) {
            macroOnCommands[slot].execute();
            undoCommand = macroOnCommands[slot];
        }
    }

    public void offButtonWasPushed(int slot) {
        if (macroOffCommands[slot] != null) {
            macroOffCommands[slot].execute();
            undoCommand = macroOffCommands[slot];
        }
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }
}
