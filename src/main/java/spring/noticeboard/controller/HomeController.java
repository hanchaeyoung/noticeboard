package spring.noticeboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.noticeboard.entity.NoticeBoardEntity;
import spring.noticeboard.entity.MemberEntity;
import spring.noticeboard.repository.MemberRepository;
import spring.noticeboard.service.NoticeBoardService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private NoticeBoardService noticeBoardService;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    public void setNoticeBoardService(NoticeBoardService noticeBoardService) { this.noticeBoardService = noticeBoardService; }

    // Get : 어떠한 정보를 가져와서 조회하기 위해 사용되는 방식
    // Post : 데이터를 서버로 제출하여 추가 또는 수정하기 위해서 데이터를 전송하는 방식
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/members")
    public String listMembers(Model model) {
        List<MemberEntity> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
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
