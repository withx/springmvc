package com.withx.advice;

import com.withx.controller.Code;
import com.withx.controller.Result;
import com.withx.exception.BusinessException;
import com.withx.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex){
        return new Result(ex.getCode(),null,"시스템 애러 운영팀에 문의하세요！");
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex){
        return new Result(ex.getCode(),null,ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result doOtherException(Exception ex){

        return new Result(Code.SYSTEM_UNKNOW_ERR,null,"시스템 애러 개발팀에 문의하세요！");
    }
}
