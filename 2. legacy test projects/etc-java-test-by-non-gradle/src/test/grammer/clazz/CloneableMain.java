package test.grammer.clazz;

public class CloneableMain {

	public static void main(String[] args) {
		Car car1 = new Car("aa");
		System.out.println("car1 = " + car1);

		Car car3 = null;
		try {
			car3 = (Car)car1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		car3.setName("aa3");
		System.out.println("car1 = " + car1);
		System.out.println("car3 = " + car3);
		System.out.println("car1.hashCode() = " + car1.hashCode());
		System.out.println("car3.hashCode() = " + car3.hashCode());
	}

	static class Car implements Cloneable{
		private String name;

		public Car(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}

		@Override
		public String toString() {
			return "Car{" +
				"name='" + name + '\'' +
				'}';
		}
	}
}
