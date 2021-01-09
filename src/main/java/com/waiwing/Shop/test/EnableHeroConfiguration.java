package com.waiwing.Shop.test;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(HeroConfigurationSelector.class)
public @interface EnableHeroConfiguration {
}
