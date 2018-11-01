package com.company.state;

public class NameException extends RuntimeException{

    public NameException(String name){
        super("name[0] != q");
    }
}
