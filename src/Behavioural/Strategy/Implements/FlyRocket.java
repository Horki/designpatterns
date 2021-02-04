package Behavioural.Strategy.Implements;

import Behavioural.Strategy.Interface.FlyBehaviour;

public class FlyRocket implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("Fly with rocket");
    }
}
