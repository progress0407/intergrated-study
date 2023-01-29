package simple.generic;

import java.util.Objects;

class Id <T> {

    private T obj;

    public boolean isSameId(Id<T> other) {
        return Objects.equals(this.obj, other.obj);
    }
}
