package Behavioural.Iterator;

public class DinerMenuIterator implements IteratorPattern {
    private final MenuItem[] items;
    private int position;

    public DinerMenuIterator(MenuItem[] i) {
        items = i;
        position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    @Override
    public MenuItem next() {
        return items[position++];
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("You can't remove an item until you've done next()");
        }
        if (items[position - 1] != null) {
            for (int i = position - 1; i < (items.length - 1); ++i) {
                items[i] = items[i + 1];
            }
            items[items.length - 1] = null;
        }
    }
}
