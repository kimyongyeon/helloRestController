package com.hello.hellorestcontroller.mapper;

import com.hello.hellorestcontroller.model.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {
    List<BoardDTO> findAll();

    // c, u, d 과제...
}
