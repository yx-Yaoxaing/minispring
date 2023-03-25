package com.mins.spring;

import org.mini.spring.ResourceException;
import org.mini.spring.context.ClassPathXmlApplicationContext;
import org.mini.spring.exception.BeansException;

public class ClassPathXmlApplicationContextTest3 {

    public static void main(String[] args) throws ResourceException, BeansException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context/SpringIocSetterXmlAuto.xml");
        Object item = context.getBean("item");
        System.err.println(item);
        System.err.println(context.containsBean("item"));
    }
}
