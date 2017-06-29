package com.example.demo.response;

/**
 * Created by kwongiho on 2017. 6. 26..
 */
public interface ErrorCustom extends ResponseStatus{
    String getResultCode();
    String getErrorCode();
}
