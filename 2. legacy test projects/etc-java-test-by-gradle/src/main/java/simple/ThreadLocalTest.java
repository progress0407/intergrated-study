package simple;

import lombok.Builder;
import lombok.Data;
import org.junit.jupiter.api.Test;

public class ThreadLocalTest {

    @Test
    void test() {
        Member member = Member.builder().id(1L).name("user A").build();
        ThreadLocal<Member> memberThreadLocal = new ThreadLocal<>();
        memberThreadLocal.set(member);
        Member findMember = memberThreadLocal.get();
        System.out.println("findMember = " + findMember);
        memberThreadLocal.remove();
        Member findMember2 = memberThreadLocal.get();
        System.out.println("findMember2 = " + findMember2);
    }

    @Builder
    @Data
    private static class Member {
        private Long id;
        private String name;
    }
}
