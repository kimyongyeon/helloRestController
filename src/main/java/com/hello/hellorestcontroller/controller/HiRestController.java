package com.hello.hellorestcontroller.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller
@RestController
@RequestMapping("api/")
public class HiRestController {

//    @RequestMapping(method = RequestMethod.GET)
//    @RequestMapping(method = RequestMethod.POST)
//    @RequestMapping(method = RequestMethod.PUT)

    @GetMapping("array")
    public String getArray(String list) {
        return list;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class MemberDTO {
        List list;
    }

    @PostMapping("postArray")
    public String getPostArray(@RequestBody MemberDTO memberDTO) {
        return memberDTO.list.toString();
    }

    @GetMapping("{path1}")
    public String getRestHi(@PathVariable String path1) {

        if (1 == 1) {
            int avg = Integer.parseInt(path1) / 0;
        }

        // if -> interface + class + abstract
        if ("list".equals(path1)) {
            // service.list
        } else if ("write".equals(path1)) {
            // service.write
        }
        return path1;
    }
//    @GetMapping("write")
//    public String getRestWrite() {
//        return "write";
//    }
//    @GetMapping("update")
//    public String estupdate() {
//        return "update";
//    }

//    @PostMapping("/restHi")
//    public Member postRestHi(@RequestBody Member member) {
//        return member;
//    }
//    @GetMapping("/restHi")
//    public Member restHi(Member member) {
//        return member;
//    }
}
