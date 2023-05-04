package whiteship.java8to11.optional;

import whiteship.java8to11.vo.OnlineClass;
import whiteship.java8to11.vo.Progress;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.System.out;

public class OptionalMain {

    public static void main(String[] args) {

//        myEg1();
        eg1();

    }

    private static void eg1() {

        List<OnlineClass> classes = new ArrayList<>();
        classes.add(new OnlineClass(1, "spring boot", true));
        classes.add(new OnlineClass(2, "spring data jpa", true));
        classes.add(new OnlineClass(3, "spring mvc", false));
        classes.add(new OnlineClass(4, "spring core", false));
        classes.add(new OnlineClass(5, "rest api development", false));

        OnlineClass js_es6 = new OnlineClass(6, "js es6", false);
        js_es6.setProgress(new Progress(Duration.ZERO, false));

        out.println("js_es6 = " + js_es6.getProgress());
//        js_es6.getProgress().ifPresent(e->{
//            out.println("e = " + e);
//        });


//        Instant now = Instant.now();
//        Instant plus = now.plus(10, ChronoUnit.SECONDS);
//        Duration between = Duration.between(plus, now);
//        out.println("between = " + between.getSeconds());



    }

    private static void myEg1() {
        List<Member> memberRepo = new ArrayList<>();
        memberRepo.add(new Member("foo", 30));
        memberRepo.add(new Member("bar", 25));

        String findName = "foo";
        Member member = findOrCreate(memberRepo, findName);

        out.println("member = " + member);
    }

    private static Member findOrCreate(List<Member> memberRepo, String findName) {
        return memberRepo.stream()
                .filter(e -> e.getName().equals(findName))
                .findFirst()
//                .orElse(signUp(findName));
                .orElseGet(()-> signUp(findName));
    }

    private static Member signUp(String findName) {
        return new Member(findName, 0);
    }

    static class Member {

        private String name;
        private Integer age;

        public Member(String name, Integer age) {
            this.name = name;
            this.age = age;
            out.println("ID created !  " + this);
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Member)) return false;
            Member member = (Member) o;
            return Objects.equals(getName(), member.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName());
        }

        @Override
        public String toString() {
            return "Member{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}


