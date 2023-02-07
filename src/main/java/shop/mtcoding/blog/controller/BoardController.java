package shop.mtcoding.blog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.blog.dto.ResponseDto;
import shop.mtcoding.blog.dto.board.BoardRequest.BoardSaveRequestDto;
import shop.mtcoding.blog.dto.board.BoardResponse.BoardDetailResponseDto;
import shop.mtcoding.blog.dto.board.BoardResponse.BoardMainResponseDto;
import shop.mtcoding.blog.handler.ex.CustomApiException;
import shop.mtcoding.blog.handler.ex.CustomException;
import shop.mtcoding.blog.model.Board;
import shop.mtcoding.blog.model.BoardRepository;
import shop.mtcoding.blog.model.User;
import shop.mtcoding.blog.model.UserRepository;
import shop.mtcoding.blog.service.BoardService;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private HttpSession session;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    @DeleteMapping("/board/{id}")
    public @ResponseBody ResponseEntity<?> delete(@PathVariable int id) {
        // 인증
        User principal = (User) session.getAttribute("principal");

        if (principal == null) {
            throw new CustomApiException("인증이 되지 않았습니다.", HttpStatus.UNAUTHORIZED);
        }

        boardService.boardDelete(id, principal.getId());
        return new ResponseEntity<>(new ResponseDto<>(1, "삭제 완료", null), HttpStatus.OK);
    }

    @GetMapping({ "/", "/board" })
    public String main(Model model) {
        List<BoardMainResponseDto> dtos = boardRepository.findAllWithUser();
        model.addAttribute("dtos", dtos);
        return "board/home";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable int id, Model model) {
        model.addAttribute("dto", boardRepository.findByIdWithUser(id));
        return "board/detail";
    }

    @GetMapping("/board/{id}/updateForm")
    public String boardupdateForm(@PathVariable int id) {
        return "board/updateForm";
    }

    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }

    @PostMapping("/board")
    public String save(BoardSaveRequestDto boardSaveRequestDto) {

        User principal = (User) session.getAttribute("principal");

        if (principal == null) {
            throw new CustomException("인증이 되지 않았습니다.", HttpStatus.UNAUTHORIZED);
        }

        if (boardSaveRequestDto.getTitle() == null || boardSaveRequestDto.getTitle().isEmpty()) {
            throw new CustomException("title을 입력해주세요");
        }

        if (boardSaveRequestDto.getContent() == null || boardSaveRequestDto.getContent().isEmpty()) {
            throw new CustomException("Content를 입력해주세요");
        }

        if (boardSaveRequestDto.getTitle().length() > 100) {
            throw new CustomException("title의 길이가 100자 이하여야 합니다");
        }
        boardService.save(boardSaveRequestDto, principal.getId());

        return "redirect:/";
    }

}
