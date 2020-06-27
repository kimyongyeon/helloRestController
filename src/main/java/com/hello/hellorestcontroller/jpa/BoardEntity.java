package com.hello.hellorestcontroller.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Profile("jpa")
//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(catalog = "TB_BOARD_JPA")
public class BoardEntity extends BaseEntity {
    @Id
    @Column
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    private String userAgent; // log file => server 한도하는 용량만큼 저장 => 용량초과 => io Exception
    // server kill => server re start was => kill => live => kill => live
    // user: 500 server bad request => 새벽에 문자가 온다. => 새벽에 깬다 => 전화를 받는다 => 출근한다.
    // 삽질 => error log , code 분석 => 2-3시간 찾는다. => 용량이 부족하다. 왜? => exception 로그파일 커짐
    // 로그파일 지워주면 되겠네 => 로그파일 지운다. => 다시살린다. => 잘된다. => 집에 퇴근한다. => 잘려고한다
    // 씻고 눞는다. => 다시 전화 온다 => 다시 죽는다.

    // server log file => logstash(엘라스틱서치) file collector => cloud upload(엘라스틱서치)
    // => server log file delete => cloud log file => kibana monitoring tool => 분석
    // ELK, EFK

    private boolean useYn; // N: 삭제, Y: 사용
}
