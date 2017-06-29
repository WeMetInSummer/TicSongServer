package com.example.demo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.annotation.sql.DataSourceDefinitions;

/**
 * Created by kwongiho on 2017. 6. 27..
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeleteUser {
    private String userId;
    private String service;
}
