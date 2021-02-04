package Behavioural.Strategy.Implements;

import Behavioural.Strategy.Interface.FlyBehaviour;

public class FlyHigh implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("Fly High");
    }
}
