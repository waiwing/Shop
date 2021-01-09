package com.waiwing.Shop.test;

import com.waiwing.Shop.condtion.LuBanCondition;
import com.waiwing.Shop.condtion.SuperManCondition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeroConfiguration {
    @Value("${color}")
    private  String color;

    @Bean
//    @ConditionalOnProperty(value="hero",havingValue = "luban",matchIfMissing = true)
//    @Conditional(LuBanCondition.class)
    public Hero luban() {
        return new LuBan(this.color);
    }

//    @Bean
//    @ConditionalOnProperty(value="hero",havingValue = "superman")
////    @Conditional(SuperManCondition.class)
//    public Hero superMan() {
//        return new SuperMan();
//    }
}
