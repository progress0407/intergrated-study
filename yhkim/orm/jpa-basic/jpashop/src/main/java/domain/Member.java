package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter @Setter @ToString
public class Member implements Serializable {

	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	@Column(length = 30)
	private String name;

	private String city;

	@Column(name = "ZIP_CODE")
	@ToString.Exclude
	private String zipcode;

	@OneToMany(mappedBy = "member")
	@ToString.Exclude
	private List<Order> orders = new ArrayList<>();

	public Member(String name) {
		this.name = name;
	}
}
