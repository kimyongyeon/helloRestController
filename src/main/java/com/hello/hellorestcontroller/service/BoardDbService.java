package com.hello.hellorestcontroller.service;

import com.hello.hellorestcontroller.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardDbService {

    @Autowired
    BoardMapper boardMapper;

    public List findAll() {
        return boardMapper.findAll();
    }

}
