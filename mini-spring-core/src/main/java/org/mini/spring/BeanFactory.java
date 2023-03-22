package org.mini.spring;


public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(Class<?> classz);

    void registerBeanDefinition(BeanDefinition beanDefinition);

}
