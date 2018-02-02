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
    private String move_type;
    private int type;//0:其他，1：欧美，2：日韩，3：国产，4：动画
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

    public String getMove_type() {
        return move_type;
    }

    public void setMove_type(String move_type) {
        this.move_type = move_type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
