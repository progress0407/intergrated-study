package simple.generic;

import java.util.Objects;

class A {

    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return id == a.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
