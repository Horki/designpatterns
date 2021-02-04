package Structural.Decorator.Decorators;

import Structural.Decorator.Abstract.Beverage;
import Structural.Decorator.Abstract.CondimentDecorator;

public class WhipCondiment extends CondimentDecorator {
    Beverage beverage;

    public WhipCondiment(Beverage b) {
        beverage = b;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    public double cost() {
        return beverage.cost() + 0.1;
    }
}
