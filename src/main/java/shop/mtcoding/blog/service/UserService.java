package shop.mtcoding.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blog.dto.user.UserRequestDto.JoinRequestDto;
import shop.mtcoding.blog.dto.user.UserRequestDto.LoginRequestDto;
import shop.mtcoding.blog.handler.ex.CustomException;
import shop.mtcoding.blog.model.User;
import shop.mtcoding.blog.model.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public int join(JoinRequestDto joinRequestDto) {
        User sameUser = userRepository.findByUsername(joinRequestDto.getUsername());
        if (sameUser != null) {
            throw new CustomException("동일한 username이 존재합니다.");
        }

        int result = userRepository.insert(joinRequestDto.getUsername(), joinRequestDto.getPassword(),
                joinRequestDto.getEmail());
        // username 중복체크
        return result;
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
