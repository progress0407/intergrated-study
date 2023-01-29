package basic.abstractt;

import java.util.Collection;
import java.util.HashSet;

public class MySet<E> extends HashSet<E> {

    private int addCount = 0;

    public MySet() {
    }

    public MySet(int initialCapacity, float loadFactor, int addCount) {
        super(initialCapacity, loadFactor);
        this.addCount = addCount;
    }

    @Override
    public boolean addAll(Collection c) {
        addCount += c.size();
        return super.addAll(c);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    public int getAddCount() {
        return addCount;
    }
}
