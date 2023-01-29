package basic.reflection.get_id;

public class RepositoryMain {

    public static void main(final String... args) {

        MemberRepository repository = new MemberRepository();
        Member member = new Member(1L, "swcho");
        Long savedId = repository.save(member);
        System.out.println("savedId = " + savedId);
    }
}
