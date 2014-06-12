package com.tubemap.data;

/**
 * Created by zhangyi667 on 14-6-10.
 */
public class Station {
    public int id;
    private String name;
    private String description;
    private String tubeStyle;

//    private int rollNo;

    Station(int id){
        this.id = id;
//        this.name = name;
//        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription(){return description;}
    public String getTubeStyle(){return tubeStyle;}

    public void setDescription(String desc){this.description = desc;}
    public void setTubeStyle(String tubeStyle){this.tubeStyle = tubeStyle;}

//    public int getRollNo() {
////        return rollNo;
//    }
//
//    public void setRollNo(int rollNo) {
//        this.rollNo = rollNo;
//    }

}
