package com.example.demo.mapper;

import com.example.demo.DTO.UserDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

/**
 * Created by kwongiho on 2017. 6. 16..
 */
@Mapper
@Service
public interface UserDAO {

    UserDTO findByUserId(String userId);
    UserDTO findByUserIdAndNameAndPlatform(String userId,String name,int plaform);
    UserDTO findByUserIdAndName(String userId,String name);

    int deleteByUserId(String userId);
}
