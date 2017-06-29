package com.example.demo.response;

import com.example.demo.DTO.User;
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
public class RegisterUserSuccess implements ResponseTimestamp , User{
    private String resultCode;
    private Long timestamp;
    private String userId;
    private String name;
    private int platform;

}
