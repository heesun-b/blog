package shop.mtcoding.blog.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {
    private int id;
    private int userId;
    private int boardId;
    private Timestamp createdAt;
}
