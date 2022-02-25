package basic.simple.immutable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Getter;

class Names {

	private final List<Name> names;

	public Names(List<Name> names) {
		this.names = new ArrayList<>(names);
	}

	public List<Name> getNames() {
		return new ArrayList<>(names);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Names names1 = (Names)o;
		return Objects.equals(names, names1.names);
	}

	@Override
	public int hashCode() {
		return Objects.hash(names);
	}

	@Override
	public String toString() {
		return "Names{" +
			"names=" + names +
			'}';
	}
}
