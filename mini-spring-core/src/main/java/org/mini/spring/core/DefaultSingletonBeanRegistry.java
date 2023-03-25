package org.mini.spring.core;

import org.mini.spring.SingletonBeanRegistry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 存储所有的单例对象
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    // 单例对象容器 存放所有的名称
    protected List<String> beanNames = new ArrayList<>(256);

    protected Map<String,Object> singletons = new ConcurrentHashMap<>(256);

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        synchronized (singletons){
            singletons.put(beanName,singletonObject);
            beanNames.add(beanName);
        }
    }

    protected void removeSingleton(String beanName){
        singletons.remove(beanName);
    }

    @Override
    public Object getSingleton(String beanName) {
        return singletons.get(beanName);
    }

    @Override
    public boolean containsSingleton(String beanName) {
        return singletons.containsKey(beanName);
    }

    @Override
    public String[] getSingletonNames() {
        return (String[]) beanNames.toArray();
    }
}
