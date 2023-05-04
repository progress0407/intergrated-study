package simple.generic;

import java.util.Objects;

class B {

    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        B b = (B) o;
        return Objects.equals(id, b.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
