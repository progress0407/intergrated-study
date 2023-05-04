package designpattern.builder;

import java.util.UUID;

import lombok.ToString;

public class MemberBuilderMain {

	public static void main(String[] args) {

		Member member = Member.builder().name("sw cho").build();

		System.out.println(member);
	}

	public static class Member {

		private String id;
		private String name;

		private Member() {
		}

		private Member(String name) {
			this.id = UUID.randomUUID().toString();
			this.name = name;
		}

		public static MemberBuilder builder() {
			return new MemberBuilder();
		}

		@Override
		public String toString() {
			return "Member {" +
				"id = '" + id + '\'' +
				", name = '" + name + '\'' +
				" }";
		}

		public static class MemberBuilder {

			private String name;

			public MemberBuilder name(String name) {
				this.name = name;
				return this;
			}

			public Member build() {
				return new Member(name);
			}
		}
	}

}
