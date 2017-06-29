package com.example.demo.Controller;

import com.example.demo.DAO.UserDAO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Service.UserService;
import com.example.demo.error.DeleteUserError;
import com.example.demo.error.DeleteUserNullError;
import com.example.demo.error.DeleteUserSuccess;
import com.example.demo.error.ResponseStatus;
import com.example.demo.request.DeleteUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kwongiho on 2017. 6. 26..
 */
@RestController
public class UserController {

    @Autowired
    UserService userServiceImpl;

    /**
     * receive delete request.
     * @param request
     * @param response
     * @param deleteUser
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/user.do",method= RequestMethod.POST)
    public String delete(HttpServletRequest request , HttpServletResponse response , @RequestBody DeleteUser deleteUser) throws Exception {


        String userId = deleteUser.getUserId();
        String service = deleteUser.getService();

        System.out.println("User Service : " + service + " / " + userId);
        switch (service) {
            case "delete":
                return jsonOut(userId, userServiceImpl.deleteByUserId(userId));
        }
        return null;
    }
    @RequestMapping(value="/register.do",method=RequestMethod.POST)
    public String register(HttpServletRequest request,HttpServletResponse response,@RequestBody UserDTO userDTO) throws Exception{
        UserDTO registerPerson = userServiceImpl.register(userDTO);
        return new ObjectMapper().writeValueAsString(registerPerson).toString();
    }

    /**
     * used of delete.
     * @param userId
     * @param result
     * @return
     * @throws JsonProcessingException
     */
    private String jsonOut(String userId, int result)  throws JsonProcessingException{

        ObjectMapper scoreJson = new ObjectMapper();
        ResponseStatus responseStatus = null;

        try {
            if (result == 1)
                responseStatus = new DeleteUserSuccess("1", System.currentTimeMillis() );
            else
                responseStatus = new DeleteUserError("-1", "","" );

        } catch (NullPointerException npe) {
            npe.printStackTrace();
            responseStatus = new DeleteUserNullError("-1","","");

        } finally {

            return scoreJson.writeValueAsString(responseStatus);
        }

    }
}
