package org.mini.spring.core;

/**
 * bean初始化前后 进行操作
 */
public interface BeanPostProcessor {

    /**
     * bean初始化之前 进行操作
     * @param bean bean对象
     * @param beanName bean的名称
     * @return bean
     */
   default Object postProcessBeforeInitialization(Object bean,String beanName){
       return bean;
   }


    /**
     * bean初始化之后 进行操作
     * @param bean bean对象
     * @param beanName bean的名称
     * @return bean
     */
     default Object postProcessAfterInitialization(Object bean,String beanName){
         return bean;
     }

}
