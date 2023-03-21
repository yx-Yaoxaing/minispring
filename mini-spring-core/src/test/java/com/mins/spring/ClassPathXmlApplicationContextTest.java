package com.mins.spring;


import org.mini.spring.ClassPathXmlApplicationContext;

public class ClassPathXmlApplicationContextTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context/SpringIocContainer.xml");
        Object user = context.getBean("user");
        System.err.println(user);
    }

}
