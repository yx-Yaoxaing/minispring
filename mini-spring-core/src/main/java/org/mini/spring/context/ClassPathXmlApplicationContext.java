package org.mini.spring.context;


import org.mini.spring.BeanDefinition;
import org.mini.spring.BeanFactory;
import org.mini.spring.BeansException;
import org.mini.spring.ResourceException;
import org.mini.spring.core.*;

public class ClassPathXmlApplicationContext implements BeanFactory {

    BeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String fileName) throws ResourceException {
        Resource resource = new ClassPathXmlResource(fileName);
        BeanFactory beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        this.beanFactory = beanFactory;
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public Object getBean(Class<?> classz) {
       return null;
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(beanDefinition);
    }

    @Override
    public Boolean containsBean(String name) {
        return null;
    }

    @Override
    public void registerBean(String beanName, Object obj) {

    }
}
