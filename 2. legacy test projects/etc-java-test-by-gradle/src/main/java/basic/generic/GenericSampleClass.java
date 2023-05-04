package basic.generic;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
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

		private static final int DEAFULT_CAPACITY = 100;

		@Getter
		private List<T> fruits = new ArrayList<>();

		// T[] arr = new T[DEAFULT_CAPACITY];
		// private T[] arr = (T[]) new Object[DEAFULT_CAPACITY];

		public long add(T fruit) {
			fruits.add(fruit);
			return fruit.getId();
		}

		public void addAll(List<T> fruits) {
			this.fruits.addAll(fruits);
		}

		public void printFruits(List<? extends Fruit> fruits) {
			for (Fruit fruit : fruits) {
				System.out.println("fruit = " + fruit);
			}
		}

		public <T> void printSomething(T something) {
			System.out.println("something class name = " + something.getClass().getSimpleName());
		}

		public Fruit findOne(long id) {
			return fruits.stream()
				.filter(fruit -> fruit.getId() == id)
				.findAny()
				.get();
		}
	}

}
