package lec04.goodcase;

import java.util.ArrayList;

class Container {
    private int maxSize;
    private int currentSize;
    private ArrayList<Luggage> luggages;

    public Container(int maxSize) {
        this.maxSize = maxSize;
        this.luggages = new ArrayList<>();
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void put(Luggage luggage) {
        if (!canContain(luggage)) {
            throw new NotEnoughSpaceException("수화물이 최대 용량을 초과합니다");
        }
        luggages.add(luggage);
        currentSize += luggage.getSize();
    }

    public void extract(Luggage luggage) {
        luggages.remove(luggage);
        currentSize -= luggage.getSize();
    }

    public boolean canContain(Luggage luggage) {
        return maxSize >= currentSize + luggage.getSize();
    }

}
