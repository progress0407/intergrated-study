package codingtest.nadongbin.bdfs;

import java.util.Stack;

import static java.lang.System.out;

public class C01_스택 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.pop();
        stack.pop();

        stack.push(9);

        for (Integer s : stack) {
            out.println("s = " + s);
        }

        while (!stack.isEmpty()) {
            out.println("stack.peek() = " + stack.peek());
            stack.pop();
        }
    }
}
