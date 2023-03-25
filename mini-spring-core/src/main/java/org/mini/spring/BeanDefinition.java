package org.mini.spring;


import lombok.Data;

@Data
public class BeanDefinition {

    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "prototype";

    private String id;

    private String className;

    // 默认为单例模式
    private String scope = SCOPE_SINGLETON;

    private volatile Object beanClass;

    // 初始化方法
    private String initMethod;

    private ArgumentValues argumentValues;

    private PropertyValues propertyValues;

    private boolean lazyInit = false;

    public BeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }

    public BeanDefinition() {
    }

    public boolean isSingleton() {
        return scope == SCOPE_SINGLETON;
    }

    public boolean isPrototype() {
        return scope == SCOPE_PROTOTYPE;
    }

    public void setConstructorArgumentValues(ArgumentValues argumentValues){
        this.argumentValues = argumentValues;
    }

    public void setPropertyValues(PropertyValues propertyValues){
        this.propertyValues = propertyValues;
    }

}
