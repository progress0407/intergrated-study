package basic.generic;

import static basic.generic.GenericSampleClass.*;

import java.util.ArrayList;
import java.util.List;

public class GenericMain {
	public static void main(String[] args) {
		// test1();
		// test2();
		test3();
	}

	private static void test3() {
		FruitBox<Apple> fruitBox = new FruitBox<>();
		Apple apple = new Apple(1L);
		fruitBox.add(apple);

		fruitBox.printSomething(new Banana(101L));
	}

	private static void test2() {
		FruitBox<Apple> fruitBox = new FruitBox<>();

		List<Apple> apples = new ArrayList<>();
		apples.add(new Apple(1L));
		apples.add(new Apple(2L));

		// fruitBox.addAll(apples);
		fruitBox.printFruits(apples);
	}

	private static void test1() {
		FruitBox<Apple> fruitBox = new FruitBox<>();
		Apple apple = new Apple(1L);

		long addedAppleId = fruitBox.add(apple);
		Fruit findApple = fruitBox.findOne(addedAppleId);

		System.out.println("findApple = " + findApple);
	}
}
