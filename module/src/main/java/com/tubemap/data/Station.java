package com.tubemap.data;

/**
 * Created by zhangyi667 on 14-6-10.
 */
public class Station {
    private String name;
    private int rollNo;

    Station(String name, int rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

}
