package Behavioural.Strategy.Implements;

import Behavioural.Strategy.Interface.FlyBehaviour;

public class FlyLow implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("Flying Low");
    }
}
