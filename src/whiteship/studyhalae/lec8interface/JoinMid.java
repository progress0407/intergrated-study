package whiteship.studyhalae.lec8interface;

public class JoinMid implements JoinMember {
	@Override
	public void preJoin() {
		// System.out.println("들어 올떄는 마음대로지만");
	}

	@Override
	public void afterJoin() {
		// System.out.println("나갈때는 .. 무슨 말하려는 지 알지? ㅎ");
	}
}
