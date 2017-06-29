package com.example.demo.Service;

import com.example.demo.DTO.UserDTO;

/**
 * Created by kwongiho on 2017. 6. 16..
 */
public interface UserService {
    UserDTO login(String userId);
    UserDTO login(String userId, String name);
    UserDTO login(String userId, String name, int platform);

    int deleteByUserId(String userId);

    UserDTO register(String userId,String name,int platform);
    UserDTO register(UserDTO userDTO);

}
