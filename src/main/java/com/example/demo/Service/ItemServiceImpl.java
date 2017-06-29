package com.example.demo.Service;

import com.example.demo.DAO.ItemDAO;
import com.example.demo.DTO.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kwongiho on 2017. 6. 16..
 */
public class ItemServiceImpl implements ItemService{
    @Autowired
    ItemDAO itemDAO;
    @Override
    public ItemDTO getItem(String userId) {
        return itemDAO.findByUserId(userId);
    }
}
