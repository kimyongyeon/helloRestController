package com.hello.hellorestcontroller.controller;

import com.hello.hellorestcontroller.model.Member;
import com.hello.hellorestcontroller.model.ResponseAPI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloRestAPI {
    @GetMapping("/hellomira")
    public ResponseEntity<ResponseAPI> getMember() {
        ResponseAPI responseAPI = new ResponseAPI();
        responseAPI.setCode("200");
        responseAPI.setMsg("success");
        Member member = new Member();
        member.setName("화요일");
        member.setAddr("서울시");
        member.setPhone("010-1234-1234");
        responseAPI.setBody(member);
        return new ResponseEntity<>(responseAPI, HttpStatus.OK);
    }

    @PostMapping("/helloPost")
    public String getMembers(@RequestBody Member member) {
        return member.toString();
    }
}
