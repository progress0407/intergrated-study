package whiteship.studyhalae.clazz;

public class LocalClassMain {
	public static void main(String[] args) {
		class LocalClass {
			private String name;

			public LocalClass(String name) {
				this.name = name;
			}

			public String getName() {
				return name;
			}
		}

		LocalClass localClass = new LocalClass("foo");
		System.out.println("localClass.getName() = " + localClass.getName());
	}
}
