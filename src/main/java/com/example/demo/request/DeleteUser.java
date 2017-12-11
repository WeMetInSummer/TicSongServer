package com.example.demo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.annotation.sql.DataSourceDefinitions;
import javax.validation.constraints.NotNull;

/**
 * Created by kwongiho on 2017. 6. 27..
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeleteUser implements UserRequest , Request{
    @NotNull
    private String userId;
    @NotNull
    private String service;
}
