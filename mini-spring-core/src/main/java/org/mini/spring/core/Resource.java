package org.mini.spring.core;


import java.util.Iterator;

/**
 * 抽象资源 后面可以根据网络读取、数据库、等等 目前只实现xml本地文件的读取
 */
public interface Resource extends Iterator<Object> {
}
