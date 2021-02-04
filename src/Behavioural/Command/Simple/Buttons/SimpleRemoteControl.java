package Behavioural.Command.Simple.Buttons;

import Behavioural.Command.Simple.Invoker;

public class SimpleRemoteControl extends Invoker {
    public SimpleRemoteControl() {
        //
    }

    public void run() {
        command.execute();
    }
}
