package Creational.AbstractFactory.Product.Abstract;

import Creational.AbstractFactory.Factory.Abstract.Ingredients.*;

import java.util.Arrays;

public abstract class Pizza {
    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Veggies veggies[];
    protected Cheese cheese;
    protected Pepperoni pepperoni;
    protected Clams clams;

    public abstract void prepare();

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "" + name + " [dough] = " + dough + ", [sauce] = " + sauce
                + ", [veggies] = " + Arrays.toString(veggies)
                + ", [cheese] = " + cheese
                + ", [pepperoni] = " + pepperoni
                + ", [clams] = " + clams;
    }
}
