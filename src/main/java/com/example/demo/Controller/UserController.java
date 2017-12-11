package com.example.demo.Controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Service.UserService;
import com.example.demo.response.*;
import com.example.demo.request.DeleteUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
    public String delete(HttpServletRequest request , HttpServletResponse response , @Valid @RequestBody DeleteUser deleteUser) throws Exception {


        String userId = deleteUser.getUserId();
        String service = deleteUser.getService();

        System.out.println("User Service : " + service + " / " + userId);

        // this code deleted on june 29 and apply @Valid annotation.
        /*if(service == null || userId == null)
            return makeJson(
                    new RegisterUserNullError("-1","","userId or service is null")
            );

        */
        switch (service) {
            case "delete":
                return jsonOut( userServiceImpl.deleteByUserId(userId));
        }
        return null;
    }


    /**
     * receive register request.
     * @param request
     * @param response
     * @param userDTO
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/register.do",method=RequestMethod.POST)
    public String register(HttpServletRequest request,HttpServletResponse response,@Valid @RequestBody UserDTO userDTO) throws Exception{
        UserDTO registerPerson = userServiceImpl.register(userDTO);

        return jsonOutFromRegister(registerPerson);
    }


    /**
     * should be make after complete item class and method.
     * @param request
     * @param response
     * @param userDTO
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/login.do", method=RequestMethod.POST)
    public String login(HttpServletRequest request,HttpServletResponse response , @Valid @RequestBody UserDTO userDTO) throws Exception {
        // presentation code for visualization
        String userId = userDTO.getUserId(),
                name = userDTO.getName();
        int platform = userDTO.getPlatform();

        return null;
        //return makeJson(userServiceImpl.login(userId,name,platform));

    }



     /**
     * used from register method.
     * @param registerPerson
     * @return
     * @throws JsonProcessingException
     */
    private String jsonOutFromRegister(UserDTO registerPerson) throws JsonProcessingException {
        ResponseStatus responseStatus = null;

        try {
            if (registerPerson != null)
                responseStatus = new RegisterUserSuccess ("1",
                                System.currentTimeMillis(),
                                registerPerson.getUserId(),
                                registerPerson.getName(),
                                registerPerson.getPlatform());
            else
                responseStatus = new RegisterUserError("-1", "","already register user" );

        } catch (NullPointerException npe) {
            npe.printStackTrace();
            responseStatus = new RegisterUserNullError("-1","","");

        } finally {

            return makeJson(responseStatus);
        }
    }
    /**
     * used of delete.
     * @param result
     * @return
     * @throws JsonProcessingException
     */
    private String jsonOut( int result)  throws JsonProcessingException{

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

            return makeJson(responseStatus);
        }

    }


    /**
     * make json what implements ResponseStatus interface.
     * @param responseStatus
     * @return
     * @throws JsonProcessingException
     */
    public String makeJson(ResponseStatus responseStatus) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(responseStatus);
    }
}
