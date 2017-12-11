package com.example.demo.Service;

import com.example.demo.DTO.ItemDTO;
import com.example.demo.request.Item;

/**
 * Created by kwongiho on 2017. 6. 16..
 */
public interface ItemService {
    ItemDTO getItem(String userId);

    int updateItem(Item item);


}
