package shop.mtcoding.blog.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import shop.mtcoding.blog.dto.board.BoardResponse.BoardMainResponseDto;

@MybatisTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void findAllWithUser_test() throws Exception {

        ObjectMapper om = new ObjectMapper();

        List<BoardMainResponseDto> boardMainResponseDto = boardRepository.findAllWithUser();
        String responseBody = om.writeValueAsString(boardMainResponseDto);
        System.out.print("테스트 : " + responseBody);

        // System.out.println(boardMainResponseDto);
        assertThat(boardMainResponseDto.get(5).getUsername()).isEqualTo("love");
    }

}
