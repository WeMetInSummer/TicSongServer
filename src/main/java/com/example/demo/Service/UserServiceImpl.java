package com.example.demo.Service;

import com.example.demo.DAO.UserDAO;
import com.example.demo.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kwongiho on 2017. 6. 16..
 */
@Service(value="UserService")
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    @Override
    public UserDTO login(String userId) {
        return userDAO.findByUserId(userId);
    }

    @Override
    public UserDTO login(String userId, String name) {
        return userDAO.findByUserIdAndName(userId,name);
    }

    @Override
    public UserDTO login(String userId, String name, int platform) {
        return userDAO.findByUserIdAndNameAndPlatform(userId,name,platform);
    }

    @Override
    public int deleteByUserId(String userId) {
        return userDAO.deleteByUserId(userId);
    }

    @Override
    public UserDTO register(String userId, String name, int platform) {
        return register(new UserDTO(userId,name,platform));
    }

    @Override
    public UserDTO register(UserDTO userDTO) {
        return userDAO.save(userDTO);
    }
}