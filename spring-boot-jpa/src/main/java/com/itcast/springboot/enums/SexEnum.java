package com.itcast.springboot.enums;

public enum SexEnum {
    男("0"),
    女("1");

    private String name;

    SexEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
