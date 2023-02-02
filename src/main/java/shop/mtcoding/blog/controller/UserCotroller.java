package shop.mtcoding.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserCotroller {

    @GetMapping("/")
    public String home() {
        return "board/home";
    }
}
