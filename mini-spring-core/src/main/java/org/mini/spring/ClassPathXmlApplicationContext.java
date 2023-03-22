package org.mini.spring;


import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.mini.spring.BeanDefinition;
import org.mini.spring.BeanFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ClassPathXmlApplicationContext implements BeanFactory {

    private static final int DEFAULT_BEANDEFINITIONS_SIZE = 256;

    private static ConcurrentHashMap<String,Object> singletonsNameMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Class<?>,Object> singletonsClassMap = new ConcurrentHashMap<>();

    public ClassPathXmlApplicationContext(String xmlFileName){
        this.readXml(xmlFileName);
        this.initBeans();
    }
    private static class SnycMap{
        public static ConcurrentHashMap<String,Object> snyc = new ConcurrentHashMap<>(256);
        public static Object getSyncObject(String xmlFileName){
            if (snyc.containsKey(xmlFileName)) {
                return snyc.get(xmlFileName);
            } else {
                Object snycObject = new Object();
                snyc.put(xmlFileName, snycObject);
                return snycObject;
            }
        }
    }

    private List<BeanDefinition> beanDefinitions = new ArrayList<>(DEFAULT_BEANDEFINITIONS_SIZE);

    private void readXml(String xmlFileName){
        if (xmlFileName == null || xmlFileName.equals(" ")) {
            throw new NullPointerException("[path dont xmlPath empty]-xmlPath:"+xmlFileName);
        }
        URL resource = this.getClass().getClassLoader().getResource(xmlFileName);
        synchronized (SnycMap.getSyncObject(xmlFileName)) {
            SAXReader saxReader = new SAXReader();
            try {
                Document document = saxReader.read(resource);
                Element rootElement = document.getRootElement();
                for (Element element : (List<Element>)rootElement.elements()) {
                    String id = element.attributeValue("id");
                    String aClass = element.attributeValue("class");
                    BeanDefinition beanDefinition = new BeanDefinition(id,aClass);
                    beanDefinitions.add(beanDefinition);
                }
            } catch (Exception e) {
                throw new RuntimeException("create beanDefinition error:"+e.getMessage());
            }
        }
    }

    public void initBeans(){
        for (BeanDefinition beanDefinition : beanDefinitions){
            String id = beanDefinition.getId();
            String className = beanDefinition.getClassName();
            try {
                Class<?> aClass = Class.forName(className);
                Object res = aClass.newInstance();
                singletonsNameMap.put(id,res);
                singletonsClassMap.put(aClass,res);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public Object getBean(String name) {
        return singletonsNameMap.get(name);
    }

    @Override
    public Object getBean(Class<?> classz) {
        return singletonsClassMap.get(classz);
    }

    /**
     * 注册bean定于信息
     * @param beanDefinition
     */
    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {

    }
}
