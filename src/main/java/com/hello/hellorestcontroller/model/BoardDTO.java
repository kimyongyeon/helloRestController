package com.hello.hellorestcontroller.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDTO {
    private Long id;
    @NotNull
    private String title; // 제목
    @NotNull
    private String contents; // 내용
    private String writer; // 글쓴이
    private int viewCount; // 조회수
    private String[] reply; // 댓글 리스트
}
