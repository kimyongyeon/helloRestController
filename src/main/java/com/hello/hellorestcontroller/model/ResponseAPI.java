package com.hello.hellorestcontroller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseAPI {
    private String code;
    private String msg;
    private Object body;
}
