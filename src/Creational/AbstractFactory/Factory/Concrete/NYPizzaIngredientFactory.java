package Creational.AbstractFactory.Factory.Concrete;

import Creational.AbstractFactory.Factory.Abstract.Ingredients.*;
import Creational.AbstractFactory.Factory.Abstract.PizzaIngredientFactory;
import Creational.AbstractFactory.Factory.Concrete.Ingredients.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        System.out.println("!!!!");
        Veggies veggies[] = {new GarlicVeggie(), new OnionVeggie(), new MushroomVeggie()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }
}
