package test.grammer.clazz;

public class InheriteMain {

	public static void main(String[] args) {
		new Child().print();
	}
	static class Parent {
		protected int val = 123;
	}

	static class Child extends Parent{
		public void print() {
			System.out.println("val = " + val);
		}
	}
}
