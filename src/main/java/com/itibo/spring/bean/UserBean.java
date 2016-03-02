package com.itibo.spring.bean;

import com.itibo.spring.bean.bo.UserBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by union on 02.03.2016.
 */

@Component
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {
    @Autowired
    UserBo userBo;

    public void setUserBo(UserBo userBo) {
        this.userBo = userBo;
    }

    public String printMsgFromSpring() {
        return userBo.getMessage();
    }
}