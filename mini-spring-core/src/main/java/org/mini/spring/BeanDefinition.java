package org.mini.spring;


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

    private boolean lazyInit = false;



    public BeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }

    public BeanDefinition() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
