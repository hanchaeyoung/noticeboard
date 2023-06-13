package spring.noticeboard.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.noticeboard.dto.BoardDto;
import spring.noticeboard.dto.CommentDto;
import spring.noticeboard.service.BoardService;
import spring.noticeboard.service.CommentService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {

    @Autowired
    private HttpSession httpSession;

    private BoardService boardService;
    private CommentService commentService;

    /* 게시글 목록 */
    @GetMapping("/")
    public String list(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
        List<BoardDto> boardList = boardService.getBoardlist(pageNum);
        Integer[] pageList = boardService.getPageList(pageNum);

        model.addAttribute("boardList", boardList);
        model.addAttribute("pageList", pageList);

        return "board/list.html";
    }

    /* 게시글 상세 */
    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);

        /* 댓글 데이터 가져오기 */
        List<CommentDto> comments = commentService.getCommentsByBoardId(no);
        boardDTO.setComments(comments);

        model.addAttribute("boardDto", boardDTO);
        return "board/detail.html";
    }


    /* 게시글 쓰기 */
    @GetMapping("/post")
    public String write() {
        return "board/write.html";
    }

//    @GetMapping("/post")
//    public String write(Model model) {
//        User user = (User) httpSession.getAttribute("user");
//        model.addAttribute("name", user.getName());
//        return "board/write.html";
//    }

//    @PostMapping("/post")
//    public String write(@AuthenticationPrincipal User user, BoardDto boardDto) {
//        boardDto.setWriter(user.getName());
//        boardService.savePost(boardDto);
//
//        return "redirect:/";
//    }

    @PostMapping("/post")
    public String write(BoardDto boardDto, Authentication authentication) {
        String writer = authentication.getName(); // 현재 인증된 사용자의 이름을 가져옴
        boardDto.setWriter(writer); // 작성자를 자동으로 입력함
        boardService.savePost(boardDto); // 게시글을 저장함
        return "redirect:/";
    }


    /* 게시글 수정 */
    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto", boardDTO);
        return "board/update.html";
    }

    @PutMapping("/post/edit/{no}")
    public String update(BoardDto boardDTO) {
        boardService.savePost(boardDTO);

        return "redirect:/";
    }

    /* 게시글 삭제 */
    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no") Long no) {
        boardService.deletePost(no);

        return "redirect:/";
    }



    @GetMapping("/board/search")
    public String search(@RequestParam(value="keyword") String keyword, Model model) {
        List<BoardDto> boardDtoList = boardService.searchPosts(keyword);

        model.addAttribute("boardList", boardDtoList);

        return "board/list.html";
    }
    @GetMapping("/login")
    public String login(){
        return "account/login";
    }
}
