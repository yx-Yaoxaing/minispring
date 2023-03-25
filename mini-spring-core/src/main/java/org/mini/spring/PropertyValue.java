package org.mini.spring;


import lombok.Data;

@Data
public class PropertyValue {
    private final String name;
    private final Object value;

    private final String type;

    public PropertyValue(String name, Object value,String type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

}
