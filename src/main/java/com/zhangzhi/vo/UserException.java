package com.zhangzhi.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserException{

    public  static  final UserException SUCCESS=success();

    public  static UserException success(){
        return  new UserException(false,null,null);
    }


    public static UserException success(Object data) {
        return new UserException(false, null, data);
    }

    public  static UserException errer(String message){
        return  new UserException(true,message,null);
    }

    private  boolean error;
    private  String message;
    private  Object data;

}
