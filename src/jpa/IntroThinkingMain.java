package jpa;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IntroThinkingMain {

	private static List<Member> members = new ArrayList<>();

	static {
		members.add(new Member(1L, "memberA"));
		members.add(new Member(2L, "memberB"));
	}

	public static void main(String[] args) {
		case1();
		// case2();
	}

	private static void case2() {
		System.out.println("======== 자바 컬렉션 조회 ========");
		Member member1 = members.get(0);
		Member member2 = members.get(0);

		System.out.println("(member1 == member2) = " + (member1 == member2));
	}

	private static void case1() {
		Member member1 = getMember(1L);
		Member member2 = getMember(1L);
		System.out.println("(member1 == member2) = " + (member1 == member2));
		System.out.println("member1.hashCode() = " + member1.hashCode());
		System.out.println("member2.hashCode() = " + member2.hashCode());
		System.out.println("member1 = " + member1);
		System.out.println("member2 = " + member2);
		System.out.println("member1.equals(member2) = " + member1.equals(member2));
		System.out.println("(member1.hashCode() == member2.hashCode()) = " + (member1.hashCode() == member2.hashCode()));
	}

	public static Member getMember(Long memberId) {
		Member findMember = members.stream()
			.filter(member -> member.getId().equals(memberId))
			.findAny()
			.get();
		return new Member(findMember.getId(), findMember.getName());
	}

	static class Member {
		Long id;
		String name;

		public Member(Long id, String name) {
			this.id = id;
			this.name = name;
		}

		public Long getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (!(o instanceof Member))
				return false;
			Member member = (Member)o;
			return Objects.equals(getId(), member.getId()) && Objects.equals(getName(), member.getName());
		}

		@Override
		public int hashCode() {
			return Objects.hash(getId(), getName());
		}

	}
}
