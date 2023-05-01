package spring.noticeboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import spring.noticeboard.domain.User;
import spring.noticeboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/add")
    public String add() {
        return "user/add";
    }

    @RequestMapping("/add-save")
    public String addSave(
            @RequestParam(value = "email") String email
            , @RequestParam(value = "password") String password
            , @RequestParam(value = "name") String name) {
//            , @RequestParam(value = "grade") int grade) {

        // User user = User.build(email, password, name, grade);
        User user = User.build(email, password, name);
        userService.add(user);

        return "user/add-save";
    }

    @GetMapping("/mypage")
    public String myPage() {
        return "user/mypage";
    }

//    @RequestMapping("login")
//    public String login() {
//        return "user/login";
//    }
}

