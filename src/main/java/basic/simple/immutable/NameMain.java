package basic.simple.immutable;

import java.util.ArrayList;
import java.util.List;

public class NameMain {
	public static void main(final String... args) {
		List<Name> originalNames = new ArrayList<>();
		originalNames.add(new Name("slow"));
		originalNames.add(new Name("pobi"));

		Names names = new Names(originalNames);

		System.out.println(names);

		names.getNames().add(new Name("hanul"));

		System.out.println(names.getNames());
	}
}
