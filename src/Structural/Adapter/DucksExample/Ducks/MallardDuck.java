package Structural.Adapter.DucksExample.Ducks;

import Structural.Adapter.DucksExample.Interfaces.Duck;

public class MallardDuck implements Duck {
    @Override
    public void fly() {
        System.out.println("I'm flying");
    }

    @Override
    public void quack() {
        System.out.println("Quack");
    }
}