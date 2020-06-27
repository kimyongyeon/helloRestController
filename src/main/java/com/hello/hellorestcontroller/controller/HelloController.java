package com.hello.hellorestcontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    @GetMapping("/helloController") // localhost:8080/helloController => helloController
    @ResponseBody public Map helloController() {
//        {
//            "name": "hello",
//              "phone" : "011-1231-1232",
//              "addr": "서울 특별시 구로"
//        }
        String name = "hello";
        Map resultMap = new HashMap<>();
        resultMap.put("name", name);
        resultMap.put("phone", "011-1231-1232");
        resultMap.put("addr", "서울 특별시 구로");
        return resultMap;
    }
}
