package Structural.Adapter.IteratorExample;

import java.util.*;

public class AdapterMain {
    private static void runEnum() {
        Vector<String> vec = new Vector<>();
        vec.add("one");
        vec.add("two");
        vec.add("three");
        Iterator iter = new EnumerationIterator(vec.elements());
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    private static void runIter() {
        ArrayList<String> array = new ArrayList<>();
        array.add("one");
        array.add("two");
        array.add("three");
        Enumeration enumeration = new IteratorEnumeration(array.iterator());
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }

    public static void main(String[] args) {
        runEnum();
        runIter();
    }
}
