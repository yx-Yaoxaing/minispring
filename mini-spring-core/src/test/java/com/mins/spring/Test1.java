package com.mins.spring;


import org.mini.spring.exception.BusinessException;
import org.mini.spring.exception.NumberException;
import org.mini.spring.exception.SystemException;

public class Test1 {

    public static void main(String[] args) {

        try {
            System.err.println(m1());
        } catch (BusinessException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            String className = null;
            int lineNumber = 0;
            String methodName =  null;
            for (StackTraceElement stackTraceElement : stackTrace) {
                className = stackTraceElement.getClassName();
                 lineNumber = stackTraceElement.getLineNumber();
                 methodName = stackTraceElement.getMethodName();
            }
            throw new BusinessException("这是我捕获的BusinessException"+"[className]:"+className+"[lineNumber]:"+lineNumber+"[methodName]:"+methodName);
        }

    }

    /**
     *
     * @return
     * @throws SystemException 当i=20 的时候就会抛出{@link SystemException} 调用方需要进行处理
     */
    private static int m1() {
        try {
            int i = 20;
            if (i==20) {
                throw new BusinessException("2000","非受检异常(运行时异常)");
            }
            return i;
        } finally {

        }
    }
}
