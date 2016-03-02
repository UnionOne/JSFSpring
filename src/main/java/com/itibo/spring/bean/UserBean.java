package com.itibo.spring.bean;

import com.itibo.spring.bean.bo.UserBo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by union on 02.03.2016.
 */

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {
    UserBo userBo;

    public void setUserBo(UserBo userBo) {
        this.userBo = userBo;
    }

    public String printMsgFromSpring() {
        return userBo.getMessage();
    }
}