package Behavioural.Command.Simple;

import Behavioural.Command.Simple.Buttons.GarageDoor;
import Behavioural.Command.Simple.Buttons.Light;
import Behavioural.Command.Simple.Buttons.SimpleRemoteControl;
import Behavioural.Command.Simple.Commands.GarageDoorCommand;
import Behavioural.Command.Simple.Commands.LightOnCommand;

public class CommandSimpleMain {
    public static void main(String[] args) {
        Invoker remote = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);

        GarageDoor garageDoor = new GarageDoor();
        GarageDoorCommand garageDoorCommand = new GarageDoorCommand(garageDoor);

        remote.setCommand(lightOnCommand);
        remote.run();

        remote.setCommand(garageDoorCommand);
        remote.run();
    }
}
