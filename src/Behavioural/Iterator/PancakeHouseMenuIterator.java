package Behavioural.Iterator;

import java.util.List;

public class PancakeHouseMenuIterator implements IteratorPattern {
    private int position;
    private final List<MenuItem> items;

    public PancakeHouseMenuIterator(List<MenuItem> l) {
        position = 0;
        items = l;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public MenuItem next() {
        return items.get(position++);
    }

    @Override
    public void remove() {
        //
    }
}
