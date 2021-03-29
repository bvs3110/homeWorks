package com.ifmo.jjd.hw06;

public class Author {
    private String name;
    private String fullName;

    private void setName(String name) {
        if (name == null || name.trim().length() < 2) throw new IllegalArgumentException("Длинна имени менее 2, либо име нулевое");
        this.name = name;
    }

    private void setFullName(String fullName) {
        if (fullName == null || fullName.trim().length() < 2) throw new IllegalArgumentException("Длинна фамилии менее 2, либо фамилия нулевая");
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public Author(String name, String fullName) {
        setName(name);
        setFullName (fullName);
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
