package hellojpa.doing.v2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
class User {

	@Id
	@Column(name = "user_id", nullable = false)
	private String id;

	private String userName;

	@JoinColumn(name = "team_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Team team;

	public User(String id, String userName) {
		this.id = id;
		this.userName = userName;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}
