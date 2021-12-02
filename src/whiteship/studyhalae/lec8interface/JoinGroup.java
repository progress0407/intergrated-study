package whiteship.studyhalae.lec8interface;

public interface JoinGroup {
	default void preJoin() {
		System.out.println("그룹에 가입 전");
	}

	default void afterJoin() {
		System.out.println("그룹에 가입 후");
	}
}
