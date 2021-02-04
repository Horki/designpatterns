package Behavioural.Strategy;

import Behavioural.Strategy.Abstract.Duck;
import Behavioural.Strategy.Ducks.MallardDuck;
import Behavioural.Strategy.Ducks.RedHeadDuck;
import Behavioural.Strategy.Implements.FlyRocket;
import Behavioural.Strategy.Implements.QuackLoud;

public class Main {
    private static void run(Duck d) {
        System.out.println("=================");
        d.display();
        d.performFly();
        d.performQuack();
        d.swim();
        System.out.println("=================");
    }

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        Duck redhead = new RedHeadDuck();
        run(mallard);
        run(redhead);
        mallard.setFly(new FlyRocket());
        mallard.setQuack(new QuackLoud());
        run(mallard);
    }
}
