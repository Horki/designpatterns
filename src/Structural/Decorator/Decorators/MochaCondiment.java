package Structural.Decorator.Decorators;

import Structural.Decorator.Abstract.Beverage;
import Structural.Decorator.Abstract.CondimentDecorator;

public class MochaCondiment extends CondimentDecorator {
    Beverage beverage;

    public MochaCondiment(Beverage b) {
        beverage = b;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    public double cost() {
        return beverage.cost() + 0.2;
    }
}
