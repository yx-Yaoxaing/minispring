package org.mini.spring;


public class ArgumentValue {

    private Object value;

    private String type;

    private String name;

    public ArgumentValue(Object value, String type, String name) {
        this.value = value;
        this.type = type;
        this.name = name;
    }

    public ArgumentValue(Object value, String type) {
        this.value = value;
        this.type = type;
        this.name = name;
    }
    public ArgumentValue() {
    }
    public Object getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
