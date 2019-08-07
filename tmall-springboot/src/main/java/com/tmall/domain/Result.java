package com.tmall.domain;

import java.io.Serializable;

/**
 * @program: tmall-springboot
 * @description: Result
 * @author: wenlongzhou
 * @create: 2019-08-07 11:10
 **/

public class Result implements Serializable {

    private boolean success;
    private String message;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}