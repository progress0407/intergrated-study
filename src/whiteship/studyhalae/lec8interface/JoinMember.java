package whiteship.studyhalae.lec8interface;

public interface JoinMember extends Join {
	default void preJoin() {
		System.out.println("회원 가입 전");
	}

	default void afterJoin() {
		System.out.println("회원 가입 후");
	}
}
