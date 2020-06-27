package com.hello.hellorestcontroller.jpa;

import org.springframework.context.annotation.Profile;

import javax.persistence.Column;
import java.util.Date;
@Profile("jpa")
public class BaseEntity {
    @Column
    private Date regDate; // 등록일 => 추적
    @Column
    private String regWriter; // 등록자
    @Column
    private Date upDate; // 수정일 => amdin, suzi, chulgu => 정상적인 html,jsp 케이스 X => postman,curl
    // userAgent//
    @Column
    private String upWriter; // 수정자
}
