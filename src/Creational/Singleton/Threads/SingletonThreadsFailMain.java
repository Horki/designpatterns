package Creational.Singleton.Threads;

class Thread1 extends Thread {
    public void run() {
        ChocolateBoilerUnsafe c = ChocolateBoilerUnsafe.getInstance();
        c.fill();
        c.boil();
//        c.drain();
        System.out.println("[T1] Is Boiled: " + c.isBoiled() + ", is empty: " + c.isEmpty());
    }
}

class Thread2 extends Thread {
    public void run() {
        ChocolateBoilerUnsafe c = ChocolateBoilerUnsafe.getInstance();
        System.out.println("[T2] Is Boiled: " + c.isBoiled() + ", is empty: " + c.isEmpty());
    }
}

class ExpensiveSync1 extends Thread {
    public void run() {
        ChocolateBoilerSync c = ChocolateBoilerSync.getInstance();
        c.fill();
        c.boil();
//        c.drain();
        System.out.println("[Sync1] Is Boiled: " + c.isBoiled() + ", is empty: " + c.isEmpty());
    }
}

class ExpensiveSync2 extends Thread {
    public void run() {
        ChocolateBoilerSync c = ChocolateBoilerSync.getInstance();
        System.out.println("[Sync2] Is Boiled: " + c.isBoiled() + ", is empty: " + c.isEmpty());
    }
}

class SafeThread1 extends Thread {
    public void run() {
        ChocolateBoilerSafe c = ChocolateBoilerSafe.getInstance();
        c.fill();
        c.boil();
//        c.drain();
        System.out.println("[Safe1] Is Boiled: " + c.isBoiled() + ", is empty: " + c.isEmpty());
    }
}

class SafeThread2 extends Thread {
    public void run() {
        ChocolateBoilerSafe c = ChocolateBoilerSafe.getInstance();
        System.out.println("[Safe2] Is Boiled: " + c.isBoiled() + ", is empty: " + c.isEmpty());
    }
}


class DoubleSafeThread1 extends Thread {
    public void run() {
        ChocolateBoilerDoubleSafe c = ChocolateBoilerDoubleSafe.getInstance();
        c.fill();
        c.boil();
//        c.drain();
        System.out.println("[Double 'Safe'1] Is Boiled: " + c.isBoiled() + ", is empty: " + c.isEmpty());
    }
}

class DoubleSafeThread2 extends Thread {
    public void run() {
        ChocolateBoilerDoubleSafe c = ChocolateBoilerDoubleSafe.getInstance();
        System.out.println("[Double 'Safe'2] Is Boiled: " + c.isBoiled() + ", is empty: " + c.isEmpty());
    }
}


public class SingletonThreadsFailMain {
    public static void main(String[] args) {
        {
            Thread t1 = new Thread1();
            Thread t2 = new Thread2();
            t1.start();
            t2.start();
            System.out.println("Done Threads");
        }
        {
            Thread sync1 = new ExpensiveSync1();
            Thread sync2 = new ExpensiveSync2();
            sync1.start();
            sync2.start();
            System.out.println("Done Sync");
        }
        {
            Thread safe1 = new SafeThread1();
            Thread safe2 = new SafeThread2();
            safe1.start();
            safe2.start();
            System.out.println("'Safe' sync");
        }
        {
            Thread doubleSafe1 = new DoubleSafeThread1();
            Thread doubleSafe2 = new DoubleSafeThread2();
            doubleSafe1.start();
            doubleSafe2.start();
            System.out.println("Double 'Safe' sync");
        }
    }
}
