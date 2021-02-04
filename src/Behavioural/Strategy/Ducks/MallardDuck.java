package Behavioural.Strategy.Ducks;

import Behavioural.Strategy.Abstract.Duck;
import Behavioural.Strategy.Implements.FlyHigh;
import Behavioural.Strategy.Implements.QuackMute;

public class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehaviour = new FlyHigh();
        quackBehaviour = new QuackMute();
    }

    @Override
    public void display() {
        System.out.println("mallarad duck");
    }
}