package spring.noticeboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.noticeboard.entity.NoticeBoardEntity;
import spring.noticeboard.service.NoticeBoardService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private NoticeBoardService noticeBoardService;

    @Autowired
    public void setNoticeBoardService(NoticeBoardService noticeBoardService) { this.noticeBoardService = noticeBoardService; }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @GetMapping("/write")
    public ModelAndView write() {
        ModelAndView mv = new ModelAndView("write");

        return mv;
    }

    @PostMapping("/list")
    public ModelAndView writeSave(@RequestParam("title") String title, @RequestParam("contents") String contents, @RequestParam("writer") String writer) {
        noticeBoardService.addWrite(title, contents, writer);
        return list();
    }

    @GetMapping("/list")
    public ModelAndView list() {
        List<NoticeBoardEntity> list = noticeBoardService.list();
        List<NoticeBoardEntity> list1 = new ArrayList<>(list.size());

        for (int i = list.size() - 1; i >= 0; i--) {
            list1.add(list.get(i));
        }

        ModelAndView mv = new ModelAndView("list");
        mv.addObject("list", list1);

        return mv;
    }

    @GetMapping("/view/{idx}")
    public ModelAndView view(@PathVariable("idx") Long idx) {
        NoticeBoardEntity noticeBoardEntity = noticeBoardService.readPost(idx);

        ModelAndView mv = new ModelAndView("view");
        mv.addObject("post", noticeBoardEntity);

        return mv;
    }
}
