package com.example.demo.error;

import javax.xml.ws.Response;

/**
 * Created by kwongiho on 2017. 6. 26..
 */
public interface ResponseTimestamp extends ResponseStatus{
    Long getTimestamp();
}
