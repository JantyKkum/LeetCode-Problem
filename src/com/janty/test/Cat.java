package com.janty.test;

/**
 * @author 简义涛
 * @version V1.0
 */
public class Cat {
    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println(cat.getClass());
    }
    private String name = "hello kitty";

    public String getName() {
        return name;
    }
}
