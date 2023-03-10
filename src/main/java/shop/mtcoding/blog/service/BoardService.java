package shop.mtcoding.blog.service;

import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blog.dto.board.BoardRequest.BoardSaveRequestDto;
import shop.mtcoding.blog.dto.board.BoardRequest.BoardUpdateRequestDto;
import shop.mtcoding.blog.handler.ex.CustomApiException;
import shop.mtcoding.blog.handler.ex.CustomException;
import shop.mtcoding.blog.model.Board;
import shop.mtcoding.blog.model.BoardRepository;
import shop.mtcoding.blog.model.User;
import shop.mtcoding.blog.util.Thumbnail;

@Transactional(readOnly = true)
@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private HttpSession session;

    @Transactional
    public void save(BoardSaveRequestDto boardSaveRequestDto, int userId) {

        System.out.println(boardSaveRequestDto.getContent());
        System.out.println(boardSaveRequestDto.getTitle());
        // content 내용을 document로 전환
        String img = Thumbnail.thumbnailParse(boardSaveRequestDto.getContent());

        int result = boardRepository.insert(userId, boardSaveRequestDto.getTitle(), boardSaveRequestDto.getContent(),
                img);
        if (result != 1) {
            throw new CustomException("글쓰기 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public void boardDelete(int id, int userId) {

        Board boardPS = boardRepository.findById(id);

        if (boardPS == null) {
            throw new CustomApiException("게시물이 존재하지 않습니다.");
        }

        if (boardPS.getUserId() != userId) {
            throw new CustomApiException("게시물 삭제 권한이 없습니다.", HttpStatus.FORBIDDEN);
        }

        try {
            boardRepository.deleteById(id);
        } catch (Exception e) {
            throw new CustomApiException("서버에 일시적인 문제가 생겼습니다.", HttpStatus.INTERNAL_SERVER_ERROR);

            // 로그를 남겨야 함 (DB 혹은 File)

        }
    }

    @Transactional
    public void boardUpdate(int id, int principalId, BoardUpdateRequestDto boardUpdateRequestDto) {
        Board boardPS = boardRepository.findById(id);

        String img = Thumbnail.thumbnailParse(boardUpdateRequestDto.getContent());

        int result = boardRepository.updateById(id, boardUpdateRequestDto.getTitle(),
                boardUpdateRequestDto.getContent(), img);
        // img src 찾기 , size 0 = 디폴트 이미지, size 1 이상 = 0번째 인덱스 삽입

        if (result != 1) {
            throw new CustomApiException("서버에 일시적인 문제가 생겼습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}