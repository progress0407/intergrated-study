package basic;

import static basic.GenericSampleClass.*;

public class GenericMain {
	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
		Apple apple = new Apple(1L);
		FruitBox<Apple> fruitBox = new FruitBox<>();

		long addedAppleId = fruitBox.add(apple);
		Fruit findApple = fruitBox.findOne(addedAppleId);

		System.out.println("findApple = " + findApple);
	}
}
