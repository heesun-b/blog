package shop.mtcoding.blog.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import shop.mtcoding.blog.dto.board.BoardRequest.BoardUpdateRequestDto;
import shop.mtcoding.blog.dto.board.BoardResponse.BoardDetailResponseDto;
import shop.mtcoding.blog.dto.board.BoardResponse.BoardMainResponseDto;

@Mapper
public interface BoardRepository {

        public List<BoardMainResponseDto> findAllWithUser();

        public List<Board> findAll();

        public BoardDetailResponseDto findByIdWithUser(int id);

        public Board findById(int id);

        public int insert(@Param("userId") int userId, @Param("title") String title,
                        @Param("content") String content, @Param("thumbnail") String thumbnail);

        public int updateById(@Param("id") int id, @Param("title") String title,
                        @Param("content") String content, @Param("thumbnail") String thumbnail);

        public int deleteById(int id);

}
