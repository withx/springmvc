package com.withx.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result {
    private String code;
    private Object data;

    private String msg;

    public Result(String code, Object data) {
        this.data = data;
        this.code = code;
    }

    public Result(String code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
