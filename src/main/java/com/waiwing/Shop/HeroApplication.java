package com.waiwing.Shop;

import com.waiwing.Shop.test.Hero;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

//@ComponentScan("com.") 添加扫码范围
//@ComponentScan
//@Import(HeroConfiguration.class)
//@Import(HeroConfigurationSelector.class)
public class HeroApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(HeroApplication.class).web(WebApplicationType.NONE).run(args);

        Hero hero = (Hero) context.getBean("luban");
        hero.twoSkill();
    }
}
