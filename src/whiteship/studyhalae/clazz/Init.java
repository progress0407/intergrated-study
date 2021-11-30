package whiteship.studyhalae.clazz;

public class Init extends ParentInit {
	private int number;

	static { // 스태틱 블럭
		System.out.println("static block");
	}

	{ // 인스턴스 블럭
		System.out.println("instance block");
		this.number = 20;
	}

	public Init() {
		System.out.println("init()");
		this.number = 100;
	}

	public Init(int number) {
		System.out.println("init(int)");
		this.number = number;
	}

	public static void main(String[] args) {
		Init init = new Init(50);
		System.out.println("init.number = " + init.number);

		System.out.println();

		Init init2 = new Init();
		System.out.println("init2.number = " + init2.number);
	}
}
