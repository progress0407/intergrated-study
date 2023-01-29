package test.grammer.thread;

public class ThreadTestMain {
	public static void main(String[] args) {
		// test1(); // state 조사
		test2();
	}

	private static void test2() {
		try {
			SleepThread sleep1 = new SleepThread(1000);
			SleepThread sleep2 = new SleepThread(1000);

			ThreadGroup group = new ThreadGroup("group1");
			Thread th1 = new Thread(group, sleep1);
			Thread th2 = new Thread(group, sleep2);

			th1.start();
			th2.start();

			Thread.sleep(1000);

			System.out.println("group.getName() = " + group.getName());
			int activeCount = group.activeCount();
			System.out.println("activeCount = " + activeCount);
			group.list();

			Thread[] tempThreadList = new Thread[activeCount];
			int result = group.enumerate(tempThreadList);
			System.out.println("Enumerate result = " + result);
			for (Thread thread : tempThreadList) {
				System.out.println("thread = " + thread);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static class SleepThread extends Thread {
		private long sleepTime;

		public SleepThread(long sleepTime) {
			this.sleepTime = sleepTime;
		}

		@Override
		public void run() {
			try {
				System.out.println("Sleeping " + getName());
				Thread.sleep(sleepTime);
				System.out.println("Stopping " + getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void test1() {
		Object monitor = new Object();
		StateThread th = new StateThread(monitor);
		StateThread th2 = new StateThread(monitor);

		System.out.println("th.getState() = " + th.getState()); // new

		th.start();
		th2.start();

		System.out.println("th.getState() = " + th.getState()); // rn

		sleep(1000);
		System.out.println("th.getState() = " + th.getState()); // wa

		synchronized (monitor) {
			// monitor.notify();
			// monitor.notify();
			monitor.notifyAll();
		}

		sleep(1000);
		System.out.println("th.getState() = " + th.getState()); // ti-wa

		try {
			th.join();
			System.out.println("th.getState() = " + th.getState()); // ter
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("th2.getState() = " + th2.getState());
	}

	private static void sleep(int millis)  {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
