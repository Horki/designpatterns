package Behavioural.Iterator;

import java.util.Hashtable;
import java.util.Iterator;

public class CafeMenuIterator implements IteratorPattern {
    private final Iterator<MenuItem> iter;

    public CafeMenuIterator(Hashtable<String, MenuItem> i) {
        iter = i.values().iterator();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public MenuItem next() {
        return iter.next();
    }

    @Override
    public void remove() {
        //
    }
}
