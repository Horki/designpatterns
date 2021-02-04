package Structural.Adapter.DucksExample.Adapters;

import Structural.Adapter.DucksExample.Interfaces.Duck;
import Structural.Adapter.DucksExample.Interfaces.Turkey;

public class DuckAdapter implements Turkey {
    private Duck duck;

    public DuckAdapter(Duck d) {
        duck = d;
    }

    @Override
    public void gobble() {
        duck.quack();
    }

    @Override
    public void fly() {
        duck.fly();
    }
}
