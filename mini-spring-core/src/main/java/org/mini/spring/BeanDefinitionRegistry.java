package org.mini.spring;

/**
 * {@link BeanDefinition} 的操作 添加 删除 获取 判断
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String name,BeanDefinition beanDefinition);

    void removeBeanDefinition(String name);

    BeanDefinition getBeanDefinition(String name);

    boolean containsBeanDefinition(String name);

}
