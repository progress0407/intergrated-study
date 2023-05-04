package basic.reflection.get_id;

import lombok.Getter;

@Getter
class Member {

    @Id
    private Long id;

    private String name;

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
