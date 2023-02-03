package shop.mtcoding.blog.service;

import org.springframework.stereotype.Service;

import shop.mtcoding.blog.dto.user.UserRequestDto.JoinRequestDto;

@Service
public class UserService {

    public int join(JoinRequestDto joinRequestDto) {
        // username 중복체크
        return 1;
    }
}
