package com.hello.hellorestcontroller.controller;

import com.hello.hellorestcontroller.common.ApiResponse;
import com.hello.hellorestcontroller.service.BoardDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db")
public class BoardDbRestController {

    @Autowired
    BoardDbService boardDbService;

    @GetMapping("/list")
    public ResponseEntity<ApiResponse> list() {
        return new ResponseEntity<>(ApiResponse.builder()
                .code(200)
                .msg("success")
                .body(boardDbService.findAll())
                .build(), HttpStatus.OK);
    }
}
