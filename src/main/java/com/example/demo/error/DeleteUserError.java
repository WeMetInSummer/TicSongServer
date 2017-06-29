package com.example.demo.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by kwongiho on 2017. 6. 26..
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DeleteUserError implements ErrorCustom{
    private String resultCode;
    private String errorCode;
    private String errorDescription;
}
