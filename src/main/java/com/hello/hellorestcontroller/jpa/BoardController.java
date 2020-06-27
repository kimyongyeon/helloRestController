package com.hello.hellorestcontroller.jpa;

import com.hello.hellorestcontroller.model.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Profile("jpa")
@RestController
public class BoardController {
    @Autowired
    BoardRepository boardRepository;

    @GetMapping(value = "/boardList")
    public List boardList() {
        return boardRepository.findAll();
    }

    class BoardReqDTO {
        String title;
        String content;
    }

    @DeleteMapping("/board")
    public void boardDelete(BoardDTO boardDTO) {
        // 모든 파라미터 값을 다 서버에 남겨서 해킹을 예방입니다.
        // history table boardDTO insert
        // board delete
        // 복구 history => board
        // 삭제: 논리적삭제, 물리적삭제
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(boardDTO.getId());
        boardEntity.setUseYn(false);
        boardRepository.save(boardEntity); // 논리적 삭제
        boardRepository.delete(boardDTO.getId()); // 물리적 삭제
    }

    @PostMapping("/board")
    public void boardSave(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(boardDTO.getId());
        boardRepository.save(boardEntity);
    }
}
