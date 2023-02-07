package shop.mtcoding.blog.dto.board;

import lombok.Getter;
import lombok.Setter;

public class BoardResponse {

    @Getter
    @Setter
    public static class BoardMainResponseDto {
        private int id;
        private String title;
        private String username;

    }

    @Getter
    @Setter
    public static class BoardDetailResponseDto {
        private int id;
        private int userId;
        private String title;
        private String username;
        private String content;

    }

}
