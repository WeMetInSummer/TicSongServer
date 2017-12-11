package com.example.demo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;


/**
 * Created by kwongiho on 2017. 6. 29..
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemRequest implements Request , Item{
    @NotNull
    private String service;
    @NotNull
    private String userId;
    @NotNull
    private int item1Cnt;
    @NotNull
    private int item2Cnt;
    @NotNull
    private int item3Cnt;
    @NotNull
    private int item4Cnt;
    @NotNull
    private int item5Cnt;

}
