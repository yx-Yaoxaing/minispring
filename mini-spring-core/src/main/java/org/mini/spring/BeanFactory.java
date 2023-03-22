package org.mini.spring;


public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(Class<?> classz);

    /**
     * 向BeanFactory容器中注册一个BeanDefinition
     * @param beanDefinition
     */
    void registerBeanDefinition(BeanDefinition beanDefinition);

    /**
     * 根据名称判断是否有当前单例对象
     * @param name bean的名称
     * @return true or false
     */
    Boolean containsBean(String name);

    /**
     * 向单例容器中 注册一个单例对象
     * @param beanName
     * @param obj
     */
    void registerBean(String beanName,Object obj);


}
