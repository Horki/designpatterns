package Behavioural.TemplateMethod;

import java.util.Arrays;

class Duck implements Comparable {
    private String name;
    private int weight;

    public Duck(String n, int i) {
        name = n;
        weight = i;
    }

    public String toString() {
        return name + ", weights: " + weight;
    }

    public int compareTo(Object o) {
        Duck d = (Duck) o;
        if (weight < d.weight) {
            return -1;
        } else if (weight == d.weight) {
            return 0;
        } else {
            return 1;
        }
    }
}

public class DuckSortMain {
    private static void display(Duck[] ducks) {
        for (Duck duck : ducks) {
            System.out.println(duck.toString());
        }
    }

    public static void main(String[] args) {
        Duck[] ducks = {
                new Duck("Daffy", 8),
                new Duck("Dewey", 2),
                new Duck("Howard", 7),
                new Duck("Louie", 2),
                new Duck("Donald", 10),
                new Duck("Huey", 2),
        };
        System.out.println("Before sorting:");
        display(ducks);
        System.out.println("---------------");
        Arrays.sort(ducks);
        System.out.println("After sorting:");
        display(ducks);
    }
}
