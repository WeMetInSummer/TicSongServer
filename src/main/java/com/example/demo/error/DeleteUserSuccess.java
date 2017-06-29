package com.example.demo.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by kwongiho on 2017. 6. 26..
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DeleteUserSuccess implements ResponseTimestamp {
    private String resultCode;
    private Long timestamp;
}
