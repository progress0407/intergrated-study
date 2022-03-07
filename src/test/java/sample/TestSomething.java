package sample;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestSomething {

    private final List<Member> members;

    public TestSomething() {
        System.out.println("TestSomething Created !");
        Member memberA = new Member(1L, "a");

        Member memberB = new Member(2L, "b");

        this.members = new ArrayList<>();
        members.add(memberA);
        members.add(memberB);
    }

    @CsvSource(value = {"a : true", "b : true", "c : false"}, delimiterString = " : ")
    @ParameterizedTest
    void test2(String target, boolean expected) {
        boolean result = List.of("a", "b").contains(target);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void test7() {
        String a = new String("123");
        String b = new String("123");

        boolean result = a.equals(b);

        System.out.println("result = " + result);
    }

    @Test
    void test6() {
        Member findMembers = members.stream()
                .filter(member -> member.getId().equals(2L))
                .findAny()
                .orElseGet(() -> new Member("empty"));

        System.out.println("findMembers = " + findMembers);
    }

    @Test
    void test5() {
        Member findMembers = members.stream()
                .filter(member -> member.getId().equals(2L))
                .findAny()
                .orElse(new Member("empty"));

        System.out.println("findMembers = " + findMembers);
    }

    private static final class Member {
        private Long id;
        private String name;

        public Member() {
            System.out.println("Member Created !");
        }

        public Member(String name) {
            System.out.println("Member Created ! :name");
            this.id = 0L;
            this.name = name;
        }

        public Member(Long id, String name) {
            System.out.println("Member Created ! :id :name");
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Member member = (Member) o;
            return Objects.equals(id, member.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return "Member{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Test
    void test4() {
        // elementData = Arrays.copyOf(elementData, size, Object[].class);
        int[] ints = {1, 2, 3};
        ints[0] = 100;
        int[] copyInts = Arrays.copyOf(ints, 3);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
        System.out.println("Arrays.toString(copyInts) = " + Arrays.toString(copyInts));
    }

    @Test
    void test3() {
        if (false) {
            throw new AssertionError(1_222);
        }
    }

    @Test
    void test2() {
        Objects.requireNonNull("aa", "nono");
    }

    @Test
    void test1() {
        Date start = new Date(1000);
        Date end = new Date(2000);
        Period period = new Period(start, end);
//        Period period = new Period(end, start);
        System.out.println("period = " + period);
        end.setTime(3000);
        System.out.println("period = " + period);
        LocalDateTime now = LocalDateTime.now();
    }

    private static final class Period {

        private final Date start;
        private final Date end;

        public Period(Date start, Date end) {
            if (start.compareTo(end) > 0) {
                throw new IllegalArgumentException("start가 end보다 늦으면 안돼");
            }
            this.start = new Date(start.getTime());
            this.end = new Date(end.getTime());
        }

        @Override
        public String toString() {
            return "Period{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

}
