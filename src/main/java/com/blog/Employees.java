package com.blog;

public class Employees {
 private String name;
 private String city;
 private int age;

    public int getAge() {
        return age;
    }

    public Employees(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
