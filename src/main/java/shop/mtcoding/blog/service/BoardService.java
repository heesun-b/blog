package shop.mtcoding.blog.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blog.dto.board.BoardRequestDto.BoardSaveRequestDto;

@Service
public class BoardService {

    @Transactional
    public int write(BoardSaveRequestDto boardSaveRequestDto) {

        return 1;
    }
}
