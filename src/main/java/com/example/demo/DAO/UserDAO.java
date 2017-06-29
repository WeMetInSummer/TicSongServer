package com.example.demo.DAO;

import com.example.demo.DTO.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kwongiho on 2017. 6. 16..
 */
public interface UserDAO extends JpaRepository<UserDTO,String>{
    UserDTO findByUserId(String userId);
    UserDTO findByUserIdAndNameAndPlatform(String userId,String name,int plaform);
    UserDTO findByUserIdAndName(String userId,String name);

    int deleteByUserId(String userId);
}
