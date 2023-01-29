package basic.reflection;

import basic.reflection.utils.RecursiveInput;

public class SampleInput {

    @RecursiveInput
    public void inputSomethingWithAno() {
        String inputText = "abcx";
        System.out.println(inputText);
        if (inputText.contains("x")) {
            throw new IllegalArgumentException("예외 발생");
        }
    }

    public void inputSomethingWithOutAno() {
        String inputText = "abcx";
        if (inputText.contains("x")) {
            throw new IllegalArgumentException("예외 발생");
        }
    }
}
