package designpattern.state;

public class YalcoStateMain {
	public static void main(String[] args) {
		final ModeSwitch modeSwitch = new ModeSwitch();
		modeSwitch.onSwitch();
		modeSwitch.onSwitch();
		modeSwitch.onSwitch();
		modeSwitch.onSwitch();
	}

	private static class ModeSwitch {

		private ModeState modeState = new ModeStateLight();

		public void onSwitch() {
			modeState.toggle(this);
		}

		public void setState(ModeState modeState) {
			this.modeState = modeState;
		}
	}

	private static class ModeStateLight implements ModeState {
		@Override
		public void toggle(ModeSwitch modeSwitch) {
			System.out.println("FROM LIGHT TO DARK");
			modeSwitch.setState(new ModeStateDark());
		}

	}

	private static class ModeStateDark implements ModeState {
		@Override
		public void toggle(ModeSwitch modeSwitch) {
			System.out.println("FROM DARK TO LIGHT");
			modeSwitch.setState(new ModeStateLight());
		}
	}

	private interface ModeState {
		void toggle(ModeSwitch modeSwitch);
	}
}
