package designpattern.singletone;

public class SingletonMain {
	public static void main(String[] args) {
		Printer printer = Printer.getInstance();
		printer.print();

		Printer printer2 = Printer.getInstance();
		printer2.print();
	}
}
