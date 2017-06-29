package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by kwongiho on 2017. 6. 29..
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterUserNullError implements ErrorCustom,ErrorDescription{
    private String resultCode;
    private String errorCode;
    private String errorDescription;

}
