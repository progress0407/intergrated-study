package designpattern.state;

public class HanbitStateMainWithSleepingRefac {

	private enum StateType {

		ON(On.getInstance()),
		OFF(Off.getInstance()),
		SLEEPING(Sleeping.getInstance());

		private final State state;

		public State getState() {
			return state;
		}

		StateType(State state) {
			this.state = state;
		}
	}

	private interface State {
		State changeState(State fromState, StateType toStateType);
	}

	private static class On implements State {

		protected static State state= new On();

		public static State getInstance() {
			return state;
		}

		public State changeState(State fromState, StateType toStateType) {
			String toStatusName = toStateType.name();
			// On -> On
			if (fromState.equals(toStateType.getState())) {
				System.out.println("Already " + toStatusName);
				return On.getInstance();
			} else { // Sleeping -> On
				System.out.println("Light " + toStatusName);
				return Sleeping.getInstance();
			}
		}
	}

	private static class Off implements State {

		protected static State state = new Off();

		public static State getInstance() {
			return state;
		}

		public State changeState(State fromState, StateType toStateType) {

			String toStatusName = toStateType.name();
			// Off -> Off
			if (fromState.equals(toStateType.getState())) {
				System.out.println("Already " + toStatusName);
			} else {
				System.out.println("Light " + toStatusName);
			}
			return Off.getInstance();
		}
	}

	private static class Sleeping implements State {

		protected static State state = new Sleeping();

		public static State getInstance() {
			return state;
		}

		@Override
		public State changeState(State fromState, StateType toStateType) {
			// Sleeping -> Sleeping
			if (fromState.equals(toStateType.getState())) {
				System.out.println("Light is now On");
				return Sleeping.getInstance();
			} else { // Sleeping -> On
				System.out.println("Light On");
				return On.getInstance();
			}
		}
	}

	private static class Light {

		private State currentState;

		public Light() {
			currentState = Off.getInstance();
		}

		public void off() {
			currentState = currentState.changeState(currentState, StateType.OFF);
		}

		public void on() {
			currentState = currentState.changeState(currentState, StateType.ON);
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
