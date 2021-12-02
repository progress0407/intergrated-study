package test.grammer.clazz;

public class ExtendsTestMain {
	public static void main(String[] args) {
		// stack();
		stackByDelegation();
	}

	private static void stackByDelegation() {
		MyStackByDelegation<String> stack = new MyStackByDelegation<>();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		System.out.println("stack.pop() = " + stack.pop());
		System.out.println("stack.pop() = " + stack.pop());
		System.out.println("stack.pop() = " + stack.pop());
	}

	private static void stack() {
		MyStack<String> stack = new MyStack<>();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		System.out.println("stack.pop() = " + stack.pop());
		System.out.println("stack.pop() = " + stack.pop());
		System.out.println("stack.pop() = " + stack.pop());
		System.out.println("stack.pop() = " + stack.pop());
	}
}
