package org.mini.spring.bean;


public class ItemService {

    private String name;

    private String address;

    public ItemService() {
    }

    public ItemService(String name) {
        System.err.println("构造器注入");
        this.name = name;
    }

    /**
     * setter 注入
     * @param address
     */
    public void setAddress(String address) {
        System.err.println("setter 注入");
        this.address = address;
    }

    @Override
    public String toString() {
        return "ItemService{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
