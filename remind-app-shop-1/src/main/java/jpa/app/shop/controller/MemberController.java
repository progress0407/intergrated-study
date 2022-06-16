package jpa.app.shop.controller;

import java.util.List;
import javax.validation.Valid;
import jpa.app.shop.controller.form.MemberForm;
import jpa.app.shop.domain.Address;
import jpa.app.shop.domain.Member;
import jpa.app.shop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

	private final MemberService memberService;
    private final ModelMapper mapper;

	@GetMapping("/new")
	public String createForm(Model model) {
        model.addAttribute("form", new MemberForm());
        return "members/createMemberForm";
	}

	@PostMapping("/new")
	public String create(@Valid MemberForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "members/createMemberForm";
        }

        Address address = mapper.map(form, Address.class);

        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(address);

        memberService.join(member);

        return "redirect:/";
    }

	@GetMapping
	public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
	}
}
