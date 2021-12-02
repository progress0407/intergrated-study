package whiteship.studyhalae.lec8interface;

public class JoinImpl implements JoinGroup, JoinMember {
	@Override
	public void preJoin() {
		JoinGroup.super.preJoin();
		JoinMember.super.preJoin();
	}

	@Override
	public void afterJoin() {
		JoinGroup.super.afterJoin();
		JoinMember.super.afterJoin();
	}
}
