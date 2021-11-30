package whiteship.studyhalae.clazz;

public class ClassQuiz {
	int x;
	int y;
	int z;

	{
		System.out.println("static block");
		if (x > 1) {
			y = 3;
		}
	}

	public ClassQuiz(int x) {
		System.out.println("constructor");
		this.x = x;
	}

	public static void main(String[] args) {
		ClassQuiz classQuiz = new ClassQuiz(3);
		System.out.println("classQuiz.y = " + classQuiz.y);
	}
}
