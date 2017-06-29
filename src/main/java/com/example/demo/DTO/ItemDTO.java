package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

/**
 * Created by kwongiho on 2017. 6. 16..
 */
/*
reference reading about Jpa join to https://stackoverflow.com/questions/11905956/jpa-foreign-key-annotation
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="item")
public class ItemDTO {
    @Id
    private String userId;
    private int item1Cnt;
    private int item2Cnt;
    private int item3Cnt;
    private int item4Cnt;
}
