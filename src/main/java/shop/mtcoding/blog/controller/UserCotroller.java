package shop.mtcoding.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blog.dto.user.UserRequest.JoinRequestDto;
import shop.mtcoding.blog.dto.user.UserRequest.LoginRequestDto;
import shop.mtcoding.blog.handler.ex.CustomException;
import shop.mtcoding.blog.model.BoardRepository;
import shop.mtcoding.blog.model.User;
import shop.mtcoding.blog.model.UserRepository;
import shop.mtcoding.blog.service.UserService;

@Controller
public class UserCotroller {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/user/{id}/updateForm")
    public String userUpdateForm(@PathVariable int id) {
        return "user/updateForm";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/join")
    public String join(JoinRequestDto joinRequestDto) {
        // int result2 = userRepository.insert(joinRequestDto);
        if (joinRequestDto.getUsername() == null || joinRequestDto.getUsername().isEmpty()) {
            throw new CustomException("username을 입력해주세요");
        }
        if (joinRequestDto.getPassword() == null || joinRequestDto.getPassword().isEmpty()) {
            throw new CustomException("password를 입력해주세요");
        }
        if (joinRequestDto.getEmail() == null || joinRequestDto.getEmail().isEmpty()) {
            throw new CustomException("email을 입력해주세요");
        }
        userService.join(joinRequestDto);

        return "redirect:/loginForm";
    }

    @PostMapping("/login")
    public String login(LoginRequestDto loginRequestDto) {
        if (loginRequestDto.getUsername() == null || loginRequestDto.getUsername().isEmpty()) {
            throw new CustomException("username을 입력해주세요");
        }
        if (loginRequestDto.getPassword() == null || loginRequestDto.getPassword().isEmpty()) {
            throw new CustomException("password를 입력해주세요");
        }

        User principal = userService.login(loginRequestDto);

        session.setAttribute("principal", principal);
        return "redirect:/";
    }

}
