package Structural.Adapter.IteratorExample;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIterator implements Iterator {
    private Enumeration enumeration;

    public EnumerationIterator(Enumeration e) {
        enumeration = e;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
