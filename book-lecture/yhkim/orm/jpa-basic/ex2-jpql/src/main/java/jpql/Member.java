package jpql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.GenericGenerator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

	@Id
	@GeneratedValue(generator = "member_uuid_gen")
	@GenericGenerator(name = "member_uuid_gen", strategy = "uuid")
	private String id;

	private String name;

	@Setter
	private int age;

	@Enumerated(EnumType.STRING)
	private MemberType type;

	@JoinColumn(name = "TEAM_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	@Setter
	@ToString.Exclude
	private Team team;

	@OneToMany(mappedBy = "member")
	@Builder.Default
	@ToString.Exclude
	private List<Order> orders = new ArrayList<>();

	public void addOrders(Order... orders) {
		this.orders.addAll(Arrays.asList(orders));
		for (Order order : orders) {
			order.setMember(this);
		}
	}

	public void changeTeam(Team team) {
		this.team = team;
		team.getMembers().add(this);
	}

}
