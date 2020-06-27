package com.hello.hellorestcontroller.controller;

import com.hello.hellorestcontroller.common.ApiResponse;
import com.hello.hellorestcontroller.service.BoardService;
import com.hello.hellorestcontroller.model.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardRestController {

    @Autowired
    BoardService service;

    @GetMapping("/list")
    public ResponseEntity<ApiResponse> list() {
        return new ResponseEntity<>(ApiResponse.builder()
                .code(200)
                .msg("success")
                .body(service.findAll())
                .build(), HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<ApiResponse> list(@PathVariable Long id) {
        return new ResponseEntity<>(ApiResponse.builder()
                .code(200)
                .msg("success")
                .body(service.findById(BoardDTO.builder().id(id).build()))
                .build(), HttpStatus.OK);
    }

    @PostMapping("/list")
    public ResponseEntity<?> save(@RequestBody BoardDTO boardDTO) {

        service.save(boardDTO);

        return new ResponseEntity<>(ApiResponse.builder()
                .code(200)
                .msg("success")
                .body("save ok")
                .build(), HttpStatus.OK);
    }

    @PutMapping("/list")
    public ResponseEntity<?> update(@RequestBody BoardDTO boardDTO) {

        service.update(boardDTO);

        return new ResponseEntity<>(ApiResponse.builder()
                .code(200)
                .msg("success")
                .body("update ok")
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/list")
    public ResponseEntity<?> delete(@RequestBody BoardDTO boardDTO) {

        service.delete(boardDTO);

        return new ResponseEntity<>(ApiResponse.builder()
                .code(200)
                .msg("success")
                .body("delete ok")
                .build(), HttpStatus.OK);
    }
}
