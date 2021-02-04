package Behavioural.Command.MacroCommand;

import Behavioural.Command.*;

public class MacroCommandMain {
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        GarageDoor garageDoor = new GarageDoor("");
        Stereo stereo = new Stereo("Living Room");

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        CeilingFanOnCommand ceilingFanOnCommand = new CeilingFanOnCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

        GarageDoorUpCommand garageDoorUpCommand = new GarageDoorUpCommand(garageDoor);
        GarageDoorDownCommand garageDoorDownCommand = new GarageDoorDownCommand(garageDoor);

        StereoOnWithCDCommand stereoOnWithCDCommand = new StereoOnWithCDCommand(stereo);
        StereoOffWithCDCommand stereoOffWithCDCommand = new StereoOffWithCDCommand(stereo);

        Command[] partyOn = {livingRoomLightOn, kitchenLightOn, ceilingFanOnCommand, garageDoorUpCommand, stereoOnWithCDCommand};
        Command[] partyOff = {livingRoomLightOff, kitchenLightOff, ceilingFanOffCommand, garageDoorDownCommand, stereoOffWithCDCommand};
        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);
        RemoteControlMacro control = new RemoteControlMacro();
        control.setCommand(0, partyOnMacro, partyOffMacro);

        control.onButtonWasPushed(0);
        System.out.println("=======================");
        control.undoButtonWasPushed();
        System.out.println("=======================");
        control.offButtonWasPushed(0);
        System.out.println("=======================");
    }
}
