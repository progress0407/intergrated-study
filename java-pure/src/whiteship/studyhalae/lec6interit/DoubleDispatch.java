package whiteship.studyhalae.lec6interit;

public class DoubleDispatch {

	public static void main(String[] args) {
		new Text().postOn(new Instagram());
		new Text().postOn(new Twitter());
		new Picture().postOn(new Instagram());
		new Picture().postOn(new Twitter());
	}

	interface Post {
		void postOn(SNS sns);
	}

	static class Text implements Post {
		@Override
		public void postOn(SNS sns) {
			if (sns instanceof Instagram) {
				System.out.println("Instagram 에서 Text 업로드");
			} else if (sns instanceof Twitter) {
				System.out.println("Twitter 에서 Text 업로드");
			}
		}
	}

	static class Picture implements Post {
		@Override
		public void postOn(SNS sns) {
			if (sns instanceof Instagram) {
				System.out.println("Instagram 에서 Picture 업로드");
			} else if (sns instanceof Twitter) {
				System.out.println("Twitter 에서 Picture 업로드");
			}
		}
	}

	interface SNS {
	}

	static class Instagram implements SNS {
	}

	static class Twitter implements SNS {
	}
}