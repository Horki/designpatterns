package Structural.Decorator.Decorators;

import Structural.Decorator.Abstract.Beverage;
import Structural.Decorator.Abstract.CondimentDecorator;

public class SoyCondiment extends CondimentDecorator {
    Beverage beverage;

    public SoyCondiment(Beverage b) {
        beverage = b;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    public double cost() {
        return beverage.cost() + 0.15;
    }
}
