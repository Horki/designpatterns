package Structural.Composite;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator<MenuComponent> {
    private final Stack<Iterator<MenuComponent>> stack;

    public CompositeIterator(Iterator<MenuComponent> iterator) {
        stack = new Stack<>();
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        }
        Iterator<MenuComponent> iter = stack.peek();
        if (!iter.hasNext()) {
            stack.pop();
            return hasNext();
        }
        return true;
    }

    @Override
    public MenuComponent next() {
        if (hasNext()) {
            Iterator<MenuComponent> iter = stack.peek();
            MenuComponent component = iter.next();
            if (component instanceof MenuComposite) {
                stack.push(component.createIterator());
            }
            return component;
        }
        return null;
    }
}
