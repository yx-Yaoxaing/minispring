package org.mini.spring;


public interface BeanFactory {

    Object getBean(String name);

    Object getBean(Class<?> classz);

}
