package org.mini.spring;

/**
 * 发布事件
 */
public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);
}
