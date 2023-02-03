package shop.mtcoding.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {

    @GetMapping("/")
    public String home() {
        return "board/home";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable int id) {
        return "board/detail";
    }

    @GetMapping("/board/{id}/updateForm")
    public String boardupdateForm(@PathVariable int id) {
        return "board/updateForm";
    }

    @GetMapping("/board/saveForm")
    public String writeForm() {
        return "board/saveForm";
    }
}
