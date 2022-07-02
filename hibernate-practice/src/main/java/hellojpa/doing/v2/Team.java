package hellojpa.doing.v2;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Team {

    @Id
    @Column(name = "team_id")
    private String id;

    private String teamName;

    @OneToMany(mappedBy = "team", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<User> users = new ArrayList<>();

    public Team(String id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }
}
