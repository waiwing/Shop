package com.waiwing.Shop;

import com.waiwing.Shop.test.EnableHeroConfiguration;
import com.waiwing.Shop.test.Hero;
import com.waiwing.Shop.test.HeroConfiguration;
import com.waiwing.Shop.test.HeroConfigurationSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//@ComponentScan("com.") 添加扫码范围
//@ComponentScan
//@Import(HeroConfiguration.class)
//@Import(HeroConfigurationSelector.class)
@EnableHeroConfiguration
public class HeroApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(HeroApplication.class).web(WebApplicationType.NONE).run(args);

        Hero hero = (Hero) context.getBean("luban");
        hero.twoSkill();
    }
}
