package com.rabia.arif.sqlite;

public class CustomerModel {
    private String name;
    private int age;
    private boolean isActive;
    private int id;

    public CustomerModel(String name, int age, boolean isActive, int id) {
        this.name = name;
        this.age = age;
        this.isActive = isActive;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isActive=" + isActive +
                ", id=" + id +
                '}';
    }
}
