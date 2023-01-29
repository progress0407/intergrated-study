package test.grammer.thread;

public class StateThread extends Thread {

	public static final int SLEEP_TIME = 2000;
	public Object monitor;

	public StateThread(Object monitor) {
		this.monitor = monitor;
	}

	@Override
	public void run() {
		try {
			for (int loop = 0; loop < 1000; loop++) {
				String a = "a";
			}
			synchronized (monitor) {
				monitor.wait();
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
