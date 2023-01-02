package jpa.app.shop.validator;

import java.util.List;
import jpa.app.shop.domain.Member;
import jpa.app.shop.exception.MemberDuplicateException;
import jpa.app.shop.repository.MemberRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberValidator {

	private static final String MEMBER_DUPLICATE_EX_MSG = "";
	private final MemberRepository memberRepository;

	public void validateDuplicateMember(Member member) {
		List<Member> findMember = memberRepository.findByName(member.getName());
		if (!findMember.isEmpty()) {
			throw new MemberDuplicateException(MEMBER_DUPLICATE_EX_MSG);
		}
	}
}
