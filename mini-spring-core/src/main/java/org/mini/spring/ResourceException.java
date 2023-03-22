package org.mini.spring;


public class ResourceException extends Exception {

    public ResourceException(String message) {
        super("[解析资源文件失败]:"+message);
    }

}
