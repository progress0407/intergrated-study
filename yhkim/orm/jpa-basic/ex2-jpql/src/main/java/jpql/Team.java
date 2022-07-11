package jpql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.GenericGenerator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder @Getter  @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {

	@Id
	@GeneratedValue(generator = "team_gen_id")
	@GenericGenerator(name = "team_gen_id", strategy = "uuid")
	private String id;

	private String name;

	// @BatchSize(size = 10)
	@Builder.Default
	@OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@ToString.Exclude
	private List<Member> members = new ArrayList<>();

	public void addMembers(Member... members) {
		this.members.addAll(Arrays.asList(members));
		Arrays.stream(members).forEach(member -> member.setTeam(this));
	}
}
