package study.querydsl.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.querydsl.dto.MemberSearchCondition;
import study.querydsl.dto.MemberTeamDto;
import study.querydsl.repository.MemberJpaRepository;
import study.querydsl.repository.MemberRepository;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberJpaRepository memberJpaRepository;
    private final MemberRepository memberRepository;

    /**
     * 신기하게 스프링이 내부에 값을 다 받아준다!!
     */
    @GetMapping("/v1/members")
    public List<MemberTeamDto> searchMemberV1(MemberSearchCondition condition) {
        return memberJpaRepository.search(condition);
    }

    @GetMapping("/v2/members-page-simple")
    public Page<MemberTeamDto> searchPageSimple(MemberSearchCondition condition, Pageable pageable) {

        return memberRepository.searchPageSimple(condition, pageable);
    }

    @GetMapping("/v2/members-page-complex")
    public Page<MemberTeamDto> searchPageComplex(MemberSearchCondition condition, Pageable pageable) {

        return memberRepository.searchPageComplex(condition, pageable);
    }

    @GetMapping("/v3/members-page-complex-delegate-utils")
    public Page<MemberTeamDto> searchPageComplexByDelegateUtils(MemberSearchCondition condition, Pageable pageable) {

        return memberRepository.searchPageComplexByDelegateUtils(condition, pageable);
    }
}
