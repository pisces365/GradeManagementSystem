package com.model.teacher;

public class Region {
    private String num;
    private String name;

    public Region(String num, String name) {
        this.num = num;
        this.name = name;
    }

    public Region() {
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
