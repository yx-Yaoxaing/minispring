package com.mins.spring;

import org.mini.spring.exception.BeansException;
import org.mini.spring.ResourceException;
import org.mini.spring.context.ClassPathXmlApplicationContext;

public class ClassPathXmlApplicationContextTest2 {

    public static void main(String[] args) throws ResourceException, BeansException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context/SpringIocContainer.xml");
        Object user = context.getBean("user");
        System.err.println(user);
        System.err.println(context.containsBean("user"));
    }
}
