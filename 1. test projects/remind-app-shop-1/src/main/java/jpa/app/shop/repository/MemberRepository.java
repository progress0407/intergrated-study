package jpa.app.shop.repository;

import java.util.List;
import jpa.app.shop.domain.Member;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository extends BasicCrudRepository<Member, Long> {

	public List<Member> findByName(String name) {
		return em.createQuery("select m from Member m where m.name = :name", Member.class)
				.setParameter("name", name)
				.getResultList();
	}

	public long memberExistCount(String name) {
		return em.createQuery("select count(m.name) from Member m where m.name = :name", Long.class)
				.setParameter("name", name)
				.getSingleResult();
	}
}
