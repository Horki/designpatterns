package Structural.Adapter.IteratorExample;

import java.util.Enumeration;
import java.util.Iterator;

public class IteratorEnumeration implements Enumeration {
    private Iterator iterator;

    public IteratorEnumeration(Iterator i) {
        iterator = i;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public Object nextElement() {
        return iterator.next();
    }
}
