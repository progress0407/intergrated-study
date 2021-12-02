package designpattern.singletone;

public class Printer {

	private static Printer printer;

	private Printer() {
		System.out.println("new printer ! ");
	}

	public static Printer getInstance() {
		if (printer == null) {
			printer = new Printer();
		}
		return printer;
	}

	public void print() {
		System.out.println("print it ! by " + printer.toString());
	}
}
