package Structural.Adapter.DucksExample;

import Structural.Adapter.DucksExample.Adapters.DuckAdapter;
import Structural.Adapter.DucksExample.Adapters.TurkeyAdapter;
import Structural.Adapter.DucksExample.Ducks.MallardDuck;
import Structural.Adapter.DucksExample.Interfaces.Duck;
import Structural.Adapter.DucksExample.Interfaces.Turkey;
import Structural.Adapter.DucksExample.Turkies.WildTurkey;

public class AdapterMain {
    private static void runDuck(Duck d) {
        d.quack();
        d.fly();
    }

    private static void runTurkey(Turkey t) {
        t.gobble();
        t.fly();
    }


    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        Turkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        System.out.println("\tThe Turkey says:");
        turkey.gobble();
        turkey.fly();
        System.out.println("\n\tThe Duck says:");
        runDuck(mallardDuck);
        System.out.println("\n\tThe Turkey Adapter says:");
        runDuck(turkeyAdapter);

        System.out.println("\n\tMallard Duck as Turkey");
        Turkey duckTurkey = new DuckAdapter(mallardDuck);
        runTurkey(duckTurkey);
    }
}
