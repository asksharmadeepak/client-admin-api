package com.example.demo.handler;

/**
 * Created by dsm2061 on 11/23/18.
 */
public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String exception) {
        super(exception);
    }

}
