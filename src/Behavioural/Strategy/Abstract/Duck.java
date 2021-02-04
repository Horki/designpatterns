package Behavioural.Strategy.Abstract;

import Behavioural.Strategy.Interface.FlyBehaviour;
import Behavioural.Strategy.Interface.QuackBehaviour;

public abstract class Duck {
    protected FlyBehaviour flyBehaviour;
    protected QuackBehaviour quackBehaviour;

    public abstract void display();

    public void performFly() {
        flyBehaviour.fly();
    }

    public void performQuack() {
        quackBehaviour.quack();
    }

    public void swim() {
        System.out.println("all ducks swim");
    }

    public void setFly(FlyBehaviour fly) {
        flyBehaviour = fly;
    }

    public void setQuack(QuackBehaviour quack) {
        quackBehaviour = quack;
    }
}
