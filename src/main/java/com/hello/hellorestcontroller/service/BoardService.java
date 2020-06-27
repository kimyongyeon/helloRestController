package com.hello.hellorestcontroller.service;

import com.hello.hellorestcontroller.model.BoardDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// OXM
// ORM

@Slf4j
@Service
public class BoardService {

    List<BoardDTO> list = new ArrayList<>();

    @PostConstruct
    public void init() {
        for(long i=0; i<10; i++) {
            list.add(BoardDTO.builder().id(i).title("테스트타이틀:" +i)
                    .contents("콘텐츠:"+i)
                    .writer("글쓴이:" + i)
                    .build()
            );
        }
    }

    public List findAll() {
        return list;
    }

    public List findById(BoardDTO boardDTO) {
        return list.stream()
                .filter(b -> b.getId() == boardDTO.getId())
                .collect(Collectors.toList());
    }

    public void save(BoardDTO boardDTO) {
        list.add(boardDTO);
    }

    public void update(BoardDTO boardDTO) {
        list.stream()
                .map(b -> {
                    if (b.getId() == boardDTO.getId()) {
                        b.setTitle(boardDTO.getTitle());
                        b.setContents(boardDTO.getContents());
                        b.setWriter(boardDTO.getWriter());
                    }
                    return b;
                }).collect(Collectors.toList());
        // list == 10, edit boar == 1
//        List newList = new ArrayList();
//        for (BoardDTO boardDTO1: list) {
//            if (boardDTO1.getId() == boardDTO.getId()) {
//                boardDTO1.setId(boardDTO.getId());
//                boardDTO1.setTitle(boardDTO.getTitle());
//                boardDTO1.setContents(boardDTO.getContents());
//                boardDTO1.setWriter(boardDTO.getWriter());
//            }
//            newList.add(boardDTO1);
//        }
//
//        log.debug("updatelist: " + newList);
    }

    public void delete(BoardDTO boardDTO) {
        List deleteList = list.stream().filter(b -> b.getId() != boardDTO.getId())
            .collect(Collectors.toList());
        list = deleteList;
//        log.debug(list.toString(), deleteList.toString());


    }

}
