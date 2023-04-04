package spring.noticeboard.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.noticeboard.dto.MemberDto;
import spring.noticeboard.service.MemberService;

@Controller
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("user", new MemberDto());

        return "user/signup";
    }

    @PostMapping("/signup")
    public String signup(MemberDto memberDto) {
        memberService.signup(memberDto);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }
}
