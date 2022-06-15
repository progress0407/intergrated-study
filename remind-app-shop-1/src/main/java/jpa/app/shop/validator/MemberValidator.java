package jpa.app.shop.validator;

import jpa.app.shop.repository.MemberRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberValidator {

	public static final String MEMBER_DUPLICATE_EX_MSG = "[ERROR] 중복된 회원이 존재합니다";
	private final MemberRepository memberRepository;

/*	public void validateDuplicateMember(Member member) {
		List<Member> findMember = memberRepository.findByName(member.getName());
		if (!findMember.isEmpty()) {
			throw new MemberDuplicateException(MEMBER_DUPLICATE_EX_MSG);
		}
	}*/
}
