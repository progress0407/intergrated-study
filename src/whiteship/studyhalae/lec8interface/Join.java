package whiteship.studyhalae.lec8interface;

public interface Join {
	default void preJoin() {
		System.out.println("Join 클래스의 preJoin");
	}
}
