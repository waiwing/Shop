package com.waiwing.Shop.core.enumeration;

import org.hibernate.type.LongType;

public enum LoginType {
    /**
     * 微信登录
     */
    USER_WX(0, "微信登录"),

    /**
     * 用户email
     */
    USER_EMAI(1, "邮箱登录");

     public Integer value;

    LoginType(Integer value, String desc) {
        this.value = value;
    }
}
