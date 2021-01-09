package com.waiwing.Shop.test;

import org.springframework.stereotype.Component;
public class SuperMan implements Hero  {

    public SuperMan(){
        System.out.println("超人来啦");
    }
    
    @Override
    public void oneSkill() {
        System.out.println("超人 使用 1 技能");
    }
    @Override
    public void twoSkill() {
        System.out.println("超人 使用2技能");
    }
    @Override
    public void threeSkill() {
        System.out.println("超人 使用 3 技能");
    }
}
