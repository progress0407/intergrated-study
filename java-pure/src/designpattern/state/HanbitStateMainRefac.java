package designpattern.state;

public class HanbitStateMainRefac {

	private enum StateType {

		ON(On.getInstance()),
		OFF(Off.getInstance());

		private final State state;

		public State getState() {
			return state;
		}

		StateType(State state) {
			this.state = state;
		}
	}

	private static abstract class State {



		protected void changeState(State fromState, StateType toStateType) {
			String toStatusName = toStateType.name();

			if (fromState.equals(toStateType.getState())) {
				System.out.println("Already " + toStatusName);
				return;
			}
			System.out.println("Light " + toStatusName);
		}



	}

	private static class On extends State {

		protected static State state= new On();

		public static State getInstance() {
			return state;
		}
	}

	private static class Off extends State {

		protected static State state = new Off();

		public static State getInstance() {
			return state;
		}
	}

	private static class Light {

		private State currentState;

		public Light() {
			currentState = Off.getInstance();
		}

		public void off() {
			currentState.changeState(currentState, StateType.OFF);
			currentState = Off.getInstance();
		}

		public void on() {
			currentState.changeState(currentState, StateType.ON);
			currentState = On.getInstance();
		}
	}

	private static class Client {
		public static void main(String[] args) {
			Light light = new Light();
			light.off();
			light.on();
			light.on();
			light.off();
		}
	}
}
