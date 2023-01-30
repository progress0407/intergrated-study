package test.grammer.thread;

public class ThreadWhiteMain {
	public static void main(String[] args) {
		test();
		test2();
	}

	private static void test2() {
		MyThread th = new MyThread();
		th.setPriority(Thread.MAX_PRIORITY);
		Object monitor = new Object();
		th.setMonitor(monitor);

		th.start();
		sleep(100);
		System.out.println("after 0.1sec = " + th.getState());
		th.interrupt();

		join(th, 1000);
		notify(monitor);
	}

	private static void notify(Object monitor) {
		synchronized (monitor) {
			monitor.notify();
		}
	}

	private static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void join(MyThread th, int millis) {
		try {
			th.join(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void test() {
		// MyRunnableImpl runnable = new MyRunnableImpl();
		// Thread th = new Thread(runnable);
		// th.start();

		MyThread[] myThread = new MyThread[10];
		/*for (int i = 0; i <10; i++) {
			myThread[i] = new MyThread();
			myThread[i].run();
		}*/
	}

	static private class MyThread extends Thread {

		private Object monitor;

		public void setMonitor(Object monitor) {
			this.monitor = monitor;
		}

		@Override
		public void run() {
			System.out.println("Priority: " + getPriority());
			System.out.println("in th, before sleep - " + getState());
			// sleep(500);
			// System.out.println(getName() + " hello my thread");
			if (monitor != null) {
				synchronized (monitor) {
					try {
						monitor.wait(500);
						System.out.println("after wait " + getState());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

		static private class MyRunnableImpl implements Runnable {
			@Override
			public void run() {
				System.out.println("hello runnable");
			}
		}

		private void sleep(int millis) {
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
