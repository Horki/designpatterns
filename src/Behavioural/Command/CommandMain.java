package Behavioural.Command;


public class CommandMain {
    public static void main(String[] args) {
        RemoteControl control = new RemoteControl();

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

        control.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        control.setCommand(1, kitchenLightOn, kitchenLightOff);
        control.setCommand(2, ceilingFanOnCommand, ceilingFanOffCommand);
        control.setCommand(3, garageDoorUpCommand, garageDoorDownCommand);
        control.setCommand(4, stereoOnWithCDCommand, stereoOffWithCDCommand);

        System.out.println(control);
        for (int i = 0; i < 7; ++i) {
            System.out.println("========================");
            control.onButtonWasPushed(i);
            control.undoButtonWasPushed();
            control.offButtonWasPushed(i);
            control.undoButtonWasPushed();
        }
    }
}
