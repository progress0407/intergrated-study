package designpattern.state;

public class HanbitStateMain {

	private static class Light {
		private static final boolean ON = true;
		private static final boolean OFF = false;
		private static boolean currentState;

		public Light() {
			currentState = false;
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
				System.out.println("이미 On 되어있는 상태입니다");
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
