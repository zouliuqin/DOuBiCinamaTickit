package com.liucheng.administrator.doubicinamatickit.entity;

import cn.bmob.v3.BmobObject;


public class User extends BmobObject {
    private  String username;
    private  String passwork;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswork() {
        return passwork;
    }

    public void setPasswork(String passwork) {
        this.passwork = passwork;
    }
}
