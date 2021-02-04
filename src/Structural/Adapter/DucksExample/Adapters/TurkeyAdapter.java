package Structural.Adapter.DucksExample.Adapters;

import Structural.Adapter.DucksExample.Interfaces.Duck;
import Structural.Adapter.DucksExample.Interfaces.Turkey;

public class TurkeyAdapter implements Duck {
    private Turkey turkey;

    public TurkeyAdapter(Turkey t) {
        turkey = t;
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; ++i) {
            turkey.fly();
        }
    }

    @Override
    public void quack() {
        turkey.gobble();
    }
}
