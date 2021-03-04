package com.zyj.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.out.println("LInuxCondition.matches");
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");

        return property.contains("Mac");
    }
}
