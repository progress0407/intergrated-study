package designpattern.singletone;

public class SingletonMain {

	static class User extends Thread {

		public User(String name) {
			super(name);
		}

		@Override
		public void run() {
			print();
		}

		private void print() {
			Printer printer = Printer.getInstance();
			printer.print();
		}
	}

	static class Printer {
		private static Printer printer;

		public synchronized static Printer getInstance() {
			if (printer == null) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				printer = new Printer();
			}

			return printer;
		}

		public void print() {
			System.out.println("print it ! by " + printer);
		}
	}

	public static void main(String[] args) {
		User[] users = new User[10];
		for (int i = 0; i < users.length; i++) {
			users[i] = new User("user-thread" + i);
			users[i].start();
		}
	}
}