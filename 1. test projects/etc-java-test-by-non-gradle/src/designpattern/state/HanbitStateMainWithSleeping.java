package designpattern.state;

public class HanbitStateMainWithSleeping {

	private static class Light {
		private static final int OFF = 1;
		private static final int ON = 2;
		private static final int SLEEPING = 3;
		private static int currentState;

		public Light() {
			currentState = OFF;
		}

		public void off() {
			if (currentState == OFF) {
				System.out.println("이미 Off 되어있는 상태입니다");
				return;
			}
			System.out.println("Light Off ! ");
			currentState = OFF;
		}

		public void on() {
			if (currentState == ON) {
				System.out.println("Light Sleep ! ");
				currentState = SLEEPING;
				return;
			}
			System.out.println("Light On ! ");
			currentState = ON;
		}
	}

	private static class Client {
		public static void main(String[] args) {
			Light light = new Light();
			light.off(); // 그대로임
			light.on();
			light.on();
			light.off();
		}
	}
}
