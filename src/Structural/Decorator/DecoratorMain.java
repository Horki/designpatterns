package Structural.Decorator;

import Structural.Decorator.Abstract.Beverage;
import Structural.Decorator.Decorators.MochaCondiment;
import Structural.Decorator.Decorators.SoyCondiment;
import Structural.Decorator.Decorators.SteamedMilkCondiment;
import Structural.Decorator.Decorators.WhipCondiment;

import java.util.ArrayList;
import java.util.List;

class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend";
    }

    @Override
    public double cost() {
        return .89;
    }
}

class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast";
    }

    @Override
    public double cost() {
        return .99;
    }
}

class Decaf extends Beverage {
    public Decaf() {
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}


class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}


public class DecoratorMain {
    private static void name(Beverage b) {
        System.out.printf("%s costs %.02f$\n", b.getDescription(), b.cost());
    }

    public static void main(String[] args) {
        List<Beverage> array = new ArrayList<>();
        array.add(new HouseBlend());
        array.add(new DarkRoast());
        array.add(new Decaf());
        array.add(new Espresso());
        array.add(new MochaCondiment(new Espresso()));
        array.add(new MochaCondiment(new MochaCondiment(new Espresso())));
        array.add(new WhipCondiment(new MochaCondiment(new Espresso())));
        array.add(new SoyCondiment(new SteamedMilkCondiment(new WhipCondiment(new MochaCondiment(new Espresso())))));
        for (Beverage item : array) {
            name(item);
        }
    }
}
