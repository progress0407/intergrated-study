package test.grammer.clazz;

import java.util.ArrayList;

public class MyStack<String> extends ArrayList<String> {
	public void push(String element) {
		add(element);
	}

	public String pop() {
		return remove(size() - 1);
	}
}
