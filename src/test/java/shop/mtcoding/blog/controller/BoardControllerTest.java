package shop.mtcoding.blog.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import shop.mtcoding.blog.dto.board.BoardResponse;
import shop.mtcoding.blog.dto.board.BoardResponse.BoardDetailResponseDto;
import shop.mtcoding.blog.model.User;

/*
 * SpringBootTest는 통합테스트 = 실제 환경과 동일하게 Bean이 생성됨
 * Mock는 가짜 환경에 Bean을 생성하는 것
 * 
 * AutoConfigureMockMvc는 Mock 환경의 ioc 컨테이너에 MockMvc Bean이 생성됨
 */

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class BoardControllerTest {

    @Autowired
    private ObjectMapper om;

    @Autowired
    private MockMvc mvc;

    private MockHttpSession mockSession;

    @BeforeEach // test 메서드 실행 직전마다 호출됨
    public void setUp() {
        User user = new User();
        user.setId(1);
        user.setUsername("ssar");
        user.setPassword("1234");
        user.setEmail("ssar@nate.com");
        user.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

        mockSession = new MockHttpSession();
        mockSession.setAttribute("principal", user);
    }

    @Test
    public void save_test() throws Exception {

        String title = "";
        for (int i = 0; i < 200; i++) {
            title += "가";
        }

        String requestBody = "title=" + title + "&content=내용1";
        // given

        // when
        ResultActions resultActions = mvc.perform(post("/board").content(requestBody)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE).session(mockSession));

        // then
        resultActions.andExpect(status().is3xxRedirection());
    }

    @Test
    public void main_test() throws Exception {
        // given
        // when
        ResultActions resultActions = mvc.perform(get("/"));
        Map<String, Object> map = resultActions.andReturn().getModelAndView().getModel();
        List<BoardResponse.BoardMainResponseDto> dtos = (List<BoardResponse.BoardMainResponseDto>) map.get("dtos");
        String model = om.writeValueAsString(dtos);
        System.out.print("테스트 : " + model);
        // then
        resultActions.andExpect(status().isOk());

        assertThat(dtos.size()).isEqualTo(6);
        assertThat(dtos.get(0).getTitle()).isEqualTo("제목1");
    }

    @Test
    public void detail_test() throws Exception {

        // given
        int id = 1;
        // when
        ResultActions resultActions = mvc.perform(get("/board/" + id));
        Map<String, Object> map = resultActions.andReturn().getModelAndView().getModel();
        BoardDetailResponseDto dto = (BoardDetailResponseDto) map.get("dto");
        String model = om.writeValueAsString(dto);
        System.out.print("테스트 : " + model);
        // then
        resultActions.andExpect(status().isOk());
        assertThat(dto.getUserId()).isEqualTo(1);
    }
}