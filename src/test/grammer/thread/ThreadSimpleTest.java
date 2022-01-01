package test.grammer.thread;

public class ThreadSimpleTest extends Thread {

	public static final int SLEEP_TIME = 2000;
	public Object lock;

	public static void main(String[] args) {

		ThreadSimpleTest th = new ThreadSimpleTest();
		th.start();

		System.out.println(Thread.currentThread());
	}

	@Override
	public void run() {
		try {
			for (int loop = 0; loop < 1000; loop++) {
				String a = "a";
			}
			synchronized (lock) {
				lock.wait();
			}
			System.out.println(getName() + " is notified");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sleep();
	}

	private void sleep() {
		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
