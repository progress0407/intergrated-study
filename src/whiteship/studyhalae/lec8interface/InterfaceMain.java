package whiteship.studyhalae.lec8interface;

public class InterfaceMain {
	public static void main(String[] args) {
		// test1();
		test2();
	}

	private static void test2() {
		JoinImpl join = new JoinImpl();
		join.preJoin();
		join.afterJoin();
	}

	private static void test1() {
		// new Java8Impl().method();
		// new Java8Impl().defaultMethod();
		// Java8Interface.staticMethod();
		new Java9Impl().defaultMethod();
	}
}
