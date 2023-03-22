package org.mini.spring.core;


import org.mini.spring.BeanDefinition;
import org.mini.spring.BeanFactory;
import org.mini.spring.BeansException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleBeanFactory implements BeanFactory {

    private List<BeanDefinition> beanDefinitions = new ArrayList<>();

    private List<String> beanNames = new ArrayList<>();

    private ConcurrentHashMap<String,Object> singletons = new ConcurrentHashMap<>();

    private BeanFactory parentBeanFactory;

    public SimpleBeanFactory() { }

    public SimpleBeanFactory(BeanFactory parentBeanFactory) {
        this.parentBeanFactory = parentBeanFactory;
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        Object singleObject  = null;
        if (singletons.contains(beanName)) {
            singleObject = singletons.get(beanName);
        } else {
            int i = beanNames.indexOf(beanName);
            if (i == -1) {
                throw new BeansException("未查询到当前BeanName");
            }
            BeanDefinition beanDefinition = beanDefinitions.get(i);
            try {
                Class<?> aClass = Class.forName(beanDefinition.getClassName());
                singleObject = aClass.newInstance();
                singletons.put(beanDefinition.getId(),singleObject);
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
        beanDefinitions.add(beanDefinition);
        beanNames.add(beanDefinition.getId());
    }
}
