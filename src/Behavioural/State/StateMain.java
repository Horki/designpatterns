package Behavioural.State;

public class StateMain {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);

        System.out.println(gumballMachine);

        gumballMachine.insert();
        gumballMachine.turnCrank();
        gumballMachine.insert();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insert();
        gumballMachine.turnCrank();
        gumballMachine.insert();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insert();
        gumballMachine.turnCrank();
        gumballMachine.insert();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insert();
        gumballMachine.turnCrank();
        gumballMachine.insert();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insert();
        gumballMachine.turnCrank();
        gumballMachine.insert();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);
    }
}
