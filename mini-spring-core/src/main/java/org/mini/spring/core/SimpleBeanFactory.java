package org.mini.spring.core;


import org.mini.spring.BeanDefinition;
import org.mini.spring.BeanFactory;
import org.mini.spring.BeansException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {


    protected Map<String,BeanDefinition> beanDefinitions = new ConcurrentHashMap<>(256);

    private List<String> beanNames = new ArrayList<>();

    private BeanFactory parentBeanFactory;

    public SimpleBeanFactory() { }

    public SimpleBeanFactory(BeanFactory parentBeanFactory) {
        this.parentBeanFactory = parentBeanFactory;
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        Object singleObject  = null;
        Object singleton = this.getSingleton(beanName);
        if (singleton == null) {
            BeanDefinition beanDefinition = beanDefinitions.get(beanName);
            if (beanDefinition == null) {
                throw new BeansException("未查询到当前definition");
            }
            try {
                Class<?> aClass = Class.forName(beanDefinition.getClassName());
                singleObject = aClass.newInstance();
                //新注册这个bean实例
                super.registerSingleton(beanName, singleObject);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return singleObject;
    }

    @Override
    public Object getBean(Class<?> classz) {
        return null;
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        beanDefinitions.put(beanDefinition.getId(),beanDefinition);
        beanNames.add(beanDefinition.getId());
    }

    @Override
    public Boolean containsBean(String name) {
        return super.containsSingleton(name);
    }

    @Override
    public void registerBean(String beanName, Object obj) {
        super.registerSingleton(beanName,obj);
    }
}
