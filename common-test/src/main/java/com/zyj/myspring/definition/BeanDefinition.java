package com.zyj.myspring.definition;


import com.zyj.myspring.constant.ScopeType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BeanDefinition {

    private Class beanClass;
    private ScopeType scope;
    private Boolean isLazy;


}
