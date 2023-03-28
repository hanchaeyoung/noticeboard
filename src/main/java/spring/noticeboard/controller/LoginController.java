package spring.noticeboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.noticeboard.entity.MemberEntity;
import spring.noticeboard.login.MemberService;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/login")
    public String processLoginRequest(@RequestParam String username,
                                      @RequestParam String password,
                                      HttpSession session) {
        MemberEntity memberEntity = memberService.authenticateUser(username, password);
        if (memberEntity != null) {
            session.setAttribute("memberEntity", memberEntity);
            return "redirect:/home";
        } else {
            return "redirect:/login?error=invalidCredentials";
        }
    }
}
