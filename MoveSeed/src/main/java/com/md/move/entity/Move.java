package com.md.move.entity;

/**
 * Created by 马东 on 2018/1/9.
 *
 * @Author:madong
 * @Description:
 * @Date:Create in 23:59 2018/1/9
 * 关关雎鸠，在河之洲，
 * 窈窕淑女，君子好逑。
 */
public class Move {
    private int id;
    private String type_name;
    private String move_name;
    private String resource;
    private String size;
    private String gain_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getMove_name() {
        return move_name;
    }

    public void setMove_name(String move_name) {
        this.move_name = move_name;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGain_date() {
        return gain_date;
    }

    public void setGain_date(String gain_date) {
        this.gain_date = gain_date;
    }
}
