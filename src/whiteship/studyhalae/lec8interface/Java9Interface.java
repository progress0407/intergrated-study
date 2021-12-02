package whiteship.studyhalae.lec8interface;

public interface Java9Interface {
	default void defaultMethod() {
		privateMethod();
		privateStaticMethod();
	}

	private void privateMethod() {
		System.out.println("this is private method");
	}

	private static void privateStaticMethod() {
		System.out.println("this is private static method");
	}
}
