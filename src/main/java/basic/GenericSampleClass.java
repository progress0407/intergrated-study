package basic;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

class GenericSampleClass {

	@Getter
	@ToString
	@AllArgsConstructor
	static class Fruit {
		long id;
	}

	interface Eatable {
	}

	@ToString(callSuper = true)
	static class Apple extends Fruit implements Eatable {
		public Apple(long id) {
			super(id);
		}
	}

	static class Banana extends Fruit {
		public Banana(long id) {
			super(id);
		}
	}

	static class FruitBox <T extends Fruit & Eatable> {
		private List<T> fruits = new ArrayList<>();

		public long add(T fruit) {
			fruits.add(fruit);
			return fruit.getId();
		}

		public Fruit findOne(long id) {
			return fruits.stream()
				.filter(fruit -> fruit.getId() == id)
				.findAny()
				.get();
		}
	}

}
