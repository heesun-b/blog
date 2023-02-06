package shop.mtcoding.blog.dto.board;

import lombok.Getter;
import lombok.Setter;

public class BoardRequest {

    @Getter
    @Setter
    public static class BoardSaveRequestDto {

        private String title;
        private String content;
    }
}
