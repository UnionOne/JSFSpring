package com.itibo.spring.bean.bo.impl;

import com.itibo.spring.bean.bo.UserBo;

/**
 * Created by union on 02.03.2016.
 */
public class UserBoImpl implements UserBo {
    @Override
    public String getMessage() {
        return "JSF Spring Integration";
    }
}