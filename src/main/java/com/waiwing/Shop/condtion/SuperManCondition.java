package com.waiwing.Shop.condtion;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class SuperManCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String hero =  conditionContext.getEnvironment().getProperty("hero");
        return( "superman".equalsIgnoreCase(hero) );

    }
}
