package shop.mtcoding.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/board/detail")
    public String detail() {
        return "board/detail";
    }

    @GetMapping("/board/updateForm")
    public String boardupdateForm() {
        return "board/updateForm";
    }

    @GetMapping("/board/writeForm")
    public String writeForm() {
        return "board/writeForm";
    }
}
