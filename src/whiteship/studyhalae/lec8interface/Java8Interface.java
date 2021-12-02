package whiteship.studyhalae.lec8interface;

public interface Java8Interface {
	void method();

	default void defaultMethod() {
		System.out.println("this is default method");
	}

	static void staticMethod() {
		System.out.println("this is static method");
	}
}
