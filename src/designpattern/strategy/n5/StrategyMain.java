package designpattern.strategy.n5;

public class StrategyMain {

	abstract static class Robot {

		private String name;
		private AttackStrategy attackStrategy;
		private MovingStrategy movingStrategy;

		public Robot(String name) {
			this.name = name;
		}

		public void attack() {
			String message = attackStrategy.attack();
			System.out.println(name + " " + message);
		}

		public void move() {
			String message = movingStrategy.move();
			System.out.println(name + " " + message);
		}

		public abstract void setAttackStrategy(AttackStrategy attackStrategy);

		public abstract void setMovingStrategy(MovingStrategy movingStrategy);
	}

	interface MovingStrategy {
		String move();
	}

	interface AttackStrategy {
		String attack();
	}

	static class PunchAttackStrategy implements AttackStrategy {

		@Override
		public String attack() {
			return "주먹으로 공격합니다";
		}
	}

	private static class KickAttackStrategy implements AttackStrategy {

		@Override
		public String attack() {
			return "발차기로 공격합니다";
		}
	}

	private static class RunningMovingStrategy implements MovingStrategy {

		@Override
		public String move() {
			return "달려 갑니다";
		}
	}

	private static class FlyingMovingStrategy implements MovingStrategy {

		@Override
		public String move() {
			return "날아 갑니다";
		}
	}

	static class TaekwonV extends Robot {

		public TaekwonV(String name) {
			super(name);
		}

		@Override
		public void setAttackStrategy(AttackStrategy attackStrategy) {
			super.attackStrategy = attackStrategy;
		}

		@Override
		public void setMovingStrategy(MovingStrategy movingStrategy) {
			super.movingStrategy = movingStrategy;
		}
	}

	static class Atom extends Robot {

		public Atom(String name) {
			super(name);
		}

		@Override
		public void setAttackStrategy(AttackStrategy attackStrategy) {
			super.attackStrategy = attackStrategy;
		}

		@Override
		public void setMovingStrategy(MovingStrategy movingStrategy) {
			super.movingStrategy = movingStrategy;
		}
	}

	static class Client {

		public static void main(String[] args) {
			Robot taekwonV = new TaekwonV("TaekwonV");
			Robot atom = new Atom("atom");

			taekwonV.setAttackStrategy(new PunchAttackStrategy());
			atom.setAttackStrategy(new KickAttackStrategy());

			taekwonV.setMovingStrategy(new RunningMovingStrategy());
			atom.setMovingStrategy(new FlyingMovingStrategy());

			taekwonV.attack();
			taekwonV.move();

			atom.attack();
			atom.move();
		}

	}
}
