package spring.noticeboard.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.noticeboard.domain.User;
import spring.noticeboard.entity.BoardEntity;
import spring.noticeboard.service.CommentService;

@Controller
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/post/{no}")
    public String createComment(@PathVariable("no") Long boardNo,
                                @RequestParam("writer") String writer,
                                @RequestParam("content") String content) {
        commentService.createComment(boardNo, writer, content);
        return "redirect:/post/" + boardNo;
    }

    @DeleteMapping("/post/{no}/{commentId}")
    public String deleteComment(@PathVariable("no") Long boardNo, @PathVariable("commentId") Long commentId) {
        commentService.deleteComment(commentId);
        return "redirect:/post/" + boardNo;
    }
}
