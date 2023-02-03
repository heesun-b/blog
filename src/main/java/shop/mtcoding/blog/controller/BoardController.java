package shop.mtcoding.blog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blog.model.Board;
import shop.mtcoding.blog.model.BoardRepository;
import shop.mtcoding.blog.model.User;
import shop.mtcoding.blog.model.UserRepository;

@Controller
public class BoardController {

    @Autowired
    private HttpSession session;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<Board> boardList = boardRepository.findAll();
        model.addAttribute("boardList", boardList);
        return "board/home";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable int id, Model model) {
        Board board = boardRepository.findById(id);
        model.addAttribute("board", board);
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

    @PostMapping("/board")
    public String write(String title, String content) {
        User user = (User) session.getAttribute("principal");

        if (user == null) {
            return "redirect:/";
        }

        int result = boardRepository.insert(user.getId(), user.getUsername(), title, content);
        if (result != 1) {
            return "redirect:board/saveForm";
        }
        return "redirect:/";
    }

}
