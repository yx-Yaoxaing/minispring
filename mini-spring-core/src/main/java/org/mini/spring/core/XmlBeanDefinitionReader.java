package org.mini.spring.core;

import org.dom4j.Element;
import org.mini.spring.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link org.mini.spring.BeanDefinition} 的读取
 */
public class XmlBeanDefinitionReader {

    BeanFactory beanFactory;

    public XmlBeanDefinitionReader(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * 加载xml文件中配置 构建{@link BeanDefinition}
     * @param resource
     */
    public void loadBeanDefinitions(Resource resource){
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanID = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanID, beanClassName);
            // 处理属性 property
            List<Element> propertyElements = element.elements("property");
            PropertyValues pvs = new PropertyValues();
            for (Element e : propertyElements) {
                String type = e.attributeValue("type");
                String name = e.attributeValue("name");
                String value = e.attributeValue("value");
                pvs.addPropertyValue(new PropertyValue(name,value,type));
            }
            beanDefinition.setPropertyValues(pvs);

            // 处理构造器
            List<Element> constructorElements = element.elements("constructor-arg");
            ArgumentValues avs = new ArgumentValues();
            AtomicInteger atomicInteger = new AtomicInteger(0);
            for (Element e : constructorElements) {
                String aType = e.attributeValue("type");
                String aName = e.attributeValue("name");
                String aValue = e.attributeValue("value");
                avs.addArgumentValue(atomicInteger.getAndIncrement(),new ArgumentValue(aValue, aType, aName));
            }
            beanDefinition.setConstructorArgumentValues(avs);
            this.beanFactory.registerBeanDefinition(beanDefinition);
        }
    }


}
