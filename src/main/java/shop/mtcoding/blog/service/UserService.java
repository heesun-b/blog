package shop.mtcoding.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blog.dto.user.UserRequest.JoinRequestDto;
import shop.mtcoding.blog.dto.user.UserRequest.LoginRequestDto;
import shop.mtcoding.blog.handler.ex.CustomException;
import shop.mtcoding.blog.model.User;
import shop.mtcoding.blog.model.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void join(JoinRequestDto joinRequestDto) {
        User sameUser = userRepository.findByUsername(joinRequestDto.getUsername());
        if (sameUser != null) {
            throw new CustomException("동일한 username이 존재합니다.");
        }

        int result = userRepository.insert(joinRequestDto.getUsername(), joinRequestDto.getPassword(),
                joinRequestDto.getEmail());
        if (result != 1) {
            throw new CustomException("회원가입 실패");
        }
    }

    @Transactional(readOnly = true)
    public User login(LoginRequestDto loginRequestDto) {
        User pincipal = userRepository.findByUsernameAndPassword(loginRequestDto.getUsername(),
                loginRequestDto.getPassword());

        if (pincipal == null) {
            throw new CustomException("username 혹은 password가 잘못 입력되었습니다.");
        }
        return pincipal;
    }
}
