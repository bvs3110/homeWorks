package com.ifmo.jjd.hw14;

import java.util.*;

public class Customer {
    private String name;
    private String uuid;
    private int age;

    public Customer(String name, String uuid, int age) {
        this.name = name;
        this.uuid = uuid;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // TODO: переопределить все необходимые методы

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return age == customer.age && Objects.equals(name, customer.name) && Objects.equals(uuid, customer.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, uuid, age);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                ", age=" + age +
                '}';
    }
}
