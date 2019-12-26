package com.zhangzhi.vo;

public class MyException extends RuntimeException {
    /**
     *
     */
    //创建一个自己的异常类
    private static final long serialVersionUID = 1L;

    public MyException() {

    }
    public MyException(String message) {
        super(message);
    }
}
