package com.example.demo.DAO;

import com.example.demo.DTO.ItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kwongiho on 2017. 6. 16..
 */
public interface ItemDAO extends JpaRepository<ItemDTO,String> {
    ItemDTO findByUserId(String userId);
}
