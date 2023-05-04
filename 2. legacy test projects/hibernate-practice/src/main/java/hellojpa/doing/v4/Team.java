package hellojpa.doing.v4;

import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "team_id")
    private Long id;

    private String teamName;

    @BatchSize(size = 100)
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
//    @JoinColumn(name = "team_id")
//    @Column
    private List<User> users = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }
}
