package Structural.Decorator.Decorators;

import Structural.Decorator.Abstract.Beverage;
import Structural.Decorator.Abstract.CondimentDecorator;

public class SteamedMilkCondiment extends CondimentDecorator {
    Beverage beverage;

    public SteamedMilkCondiment(Beverage b) {
        beverage = b;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Steamed milk";
    }

    public double cost() {
        return beverage.cost() + 0.1;
    }
}
