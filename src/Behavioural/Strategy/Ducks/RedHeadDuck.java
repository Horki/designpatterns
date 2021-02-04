package Behavioural.Strategy.Ducks;

import Behavioural.Strategy.Abstract.Duck;
import Behavioural.Strategy.Implements.FlyLow;
import Behavioural.Strategy.Implements.QuackLoud;

public class RedHeadDuck extends Duck {
    public RedHeadDuck() {
        flyBehaviour = new FlyLow();
        quackBehaviour = new QuackLoud();
    }

    @Override
    public void display() {
        System.out.println("redhead duck");
    }
}