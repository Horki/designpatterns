package Behavioural.Strategy.Implements;

import Behavioural.Strategy.Interface.QuackBehaviour;

public class QuackLoud implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Quack Loud");
    }
}
