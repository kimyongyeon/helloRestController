package com.hello.hellorestcontroller.model;

import lombok.Data;

@Data
public class Member {
    String name;
    String phone;
    String addr;
    String[] friends;
}