package com.mins.spring;


import org.mini.spring.ClassPathXmlApplicationContext;
import org.mini.spring.bean.User;

public class ClassPathXmlApplicationContextTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context/SpringIocContainer.xml");
        Object user1 = context.getBean("user");
        Object user2 = context.getBean(User.class);
        System.err.println(user1);
        System.err.println(user2);
    }

}
