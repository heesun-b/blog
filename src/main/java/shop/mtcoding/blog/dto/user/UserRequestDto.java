package shop.mtcoding.blog.dto.user;

import lombok.Getter;
import lombok.Setter;

public class UserRequestDto {

    @Getter
    @Setter
    public static class JoinRequestDto {
        private String username;
        private String password;
        private String email;
    }
}
