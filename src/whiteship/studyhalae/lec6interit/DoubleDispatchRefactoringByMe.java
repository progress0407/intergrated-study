package whiteship.studyhalae.lec6interit;

public class DoubleDispatchRefactoringByMe {

	public static void main(String[] args) {
		new Twitter().ponstOn(new Text());
		new Twitter().ponstOn(new Pictrure());
		new Facebook().ponstOn(new Text());
		new Facebook().ponstOn(new Pictrure());
	}

	interface Sns {
		void ponstOn(Post post);
	}

	interface Post {
		void doPost();
	}

	static class Text implements Post {
		@Override
		public void doPost() {
			System.out.println("Text 저장");
		}
	}

	static class Pictrure implements Post {
		@Override
		public void doPost() {
			System.out.println("Pictrure 저장");
		}
	}

	static class Twitter implements Sns {
		@Override
		public void ponstOn(Post post) {
			System.out.print("Twitter 에서 ");
			post.doPost();
		}
	}

	static class Facebook implements Sns {
		@Override
		public void ponstOn(Post post) {
			System.out.print("Facebook 에서 ");
			post.doPost();
		}
	}
}
