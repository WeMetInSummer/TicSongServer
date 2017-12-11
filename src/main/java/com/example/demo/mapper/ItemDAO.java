package com.example.demo.mapper;

import com.example.demo.DTO.ItemDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kwongiho on 2017. 6. 16..
 */

@Mapper
@Service
public interface ItemDAO {//} extends JpaRepository<ItemDTO,String> {


    @Select("select * from item where userid=#{userId}")
    List<ItemDTO> findByUserId(String userId);

    @Insert("insert into item (userid) values(#{value})")
    int initItem(String value);

    @Insert("insert into item (userid,item1Cnt,item2Cnt,item3Cnt,item4Cnt) values(#{userId},#{item1Cnt},#{item2Cnt},#{item3Cnt},#{item4Cnt})")
    int insertItemByUserId(String userId, int item1Cnt, int item2Cnt, int item3Cnt, int item4Cnt);

    @Update("update item set item1Cnt=#{item1Cnt}, item2Cnt=#{item2Cnt}, item3Cnt=#{item3Cnt}, item4Cnt=#{item4Cnt} where userid=#{userId}")
    int updateItem(int item1Cnt, int item2Cnt, int item3Cnt, int item4Cnt, String userId);

    @Update("update item set  item1Cnt=#{item1Cnt}, item2Cnt=#{item2Cnt}, item3Cnt=#{item3Cnt}, item4Cnt=#{item4Cnt}, item5Cnt=#{item5Cnt} where userid=#{userId}")
    int updateItemAll(int item1Cnt, int item2Cnt, int item3Cnt, int item4Cnt,int item5Cnt , String userId);



}
