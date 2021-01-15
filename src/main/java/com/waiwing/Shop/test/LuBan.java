package com.waiwing.Shop.test;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

public class LuBan implements Hero {

    private String color;

    public LuBan(String color) {
        this.color = color;
        System.out.println(color + "鲁班来啦 带参构造 code"+this.hashCode());

    }

    public LuBan() {
        System.out.println(color + "鲁班来啦 无参构造 code"+this.hashCode());
    }

    @Override
    public void oneSkill() {
        System.out.println(color + "鲁班 使用 1 技能");
    }

    @Override
    public void twoSkill() {
        System.out.println(color + "鲁班 使用2技能");
    }

    @Override
    public void threeSkill() {
        System.out.println(color + "鲁班 使用 3 技能");
    }
}
