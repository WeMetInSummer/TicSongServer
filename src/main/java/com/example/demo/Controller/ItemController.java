package com.example.demo.Controller;

import com.example.demo.Service.ItemService;
import com.example.demo.request.ItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by kwongiho on 2017. 6. 29..
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemServiceImpl;



    @PutMapping("/update")
    public void updateItem(@RequestBody ItemRequest itemRequest) {
        // if android

        switch(itemRequest.getService()) {
            case "android" :


        }
        if(itemRequest.getItem5Cnt() < 0 ) {

        }
    }

    @RequestMapping(value="/item.do",method = RequestMethod.POST)
    public String item(HttpServletRequest request, HttpServletResponse response , @Valid @RequestBody ItemRequest itemRequest) throws Exception{
        switch ( itemRequest.getService() ) {
            case "update":
                break;
            case "get" :
                break;
        }
        return null;
    }
}
