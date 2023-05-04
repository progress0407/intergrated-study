package test.grammer.reflection;

import static java.lang.System.*;

import java.lang.reflect.Field;

public class ReflectionUser {

	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
		// test1();
		try {
			// test2();
			test3();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void test3() throws ClassNotFoundException {
		// 에러 !!
		Field[] declaredFields = Class.forName("test.grammer.reflection.ReflectionUser.InnerClass").getDeclaredFields();
		// Field[] declaredFields = Class.forName("test.grammer.reflection.RefObject.InnerClass").getDeclaredFields();
		for (Field declaredField : declaredFields) {
			out.println(declaredField);
		}
	}

	private static void test2() throws ClassNotFoundException {
		Field[] declaredFields = Class.forName("test.grammer.reflection.RefObject").getDeclaredFields();
		for (Field declaredField : declaredFields) {
			out.println(declaredField);
		}
	}

	private static void test1() throws NoSuchFieldException, IllegalAccessException {
		Class<?> clazz = RefObject.class;

		out.println("clazz.getCanonicalName() = " + clazz.getCanonicalName());
		out.println("clazz.getDeclaredFields() = " + clazz.getDeclaredFields());

		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			out.println("field.getName() = " + field.getName());
		}

		Field field = clazz.getDeclaredField("numId");

		RefObject refObject = new RefObject();

		field.setAccessible(true);
		int numId = (int)field.get(refObject);
		out.println("numId = " + numId);

		field.set(refObject, 3);
		numId = (int)field.get(refObject);
		out.println("numId = " + numId);
	}

	class InnerClass {
		public void doo() {
		}

		public int doo2() {
			return 1;
		}
	}
}
