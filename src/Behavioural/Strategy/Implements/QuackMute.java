package Behavioural.Strategy.Implements;

import Behavioural.Strategy.Interface.QuackBehaviour;

public class QuackMute implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Quack Mute");
    }
}
