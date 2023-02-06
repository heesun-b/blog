package shop.mtcoding.blog.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blog.dto.board.BoardRequest.BoardSaveRequestDto;
import shop.mtcoding.blog.handler.ex.CustomException;
import shop.mtcoding.blog.model.BoardRepository;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private HttpSession session;

    @Transactional
    public void save(BoardSaveRequestDto boardSaveRequestDto, int userId) {
        int result = boardRepository.insert(userId, boardSaveRequestDto.getTitle(), boardSaveRequestDto.getContent());
        if (result != 1) {
            throw new CustomException("글쓰기 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
