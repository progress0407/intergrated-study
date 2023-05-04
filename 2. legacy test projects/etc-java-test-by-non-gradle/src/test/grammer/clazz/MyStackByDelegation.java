package test.grammer.clazz;

import java.util.ArrayList;

public class MyStackByDelegation<String> {

	private ArrayList<String> arList = new ArrayList<String>();

	public void push(String element) {
		arList.add(element);
	}

	public String pop() {
		return arList.remove(arList.size() - 1);
	}

	public boolean isEmpty() {
		return arList.isEmpty();
	}

	public int size() {
		return arList.size();
	}
}
