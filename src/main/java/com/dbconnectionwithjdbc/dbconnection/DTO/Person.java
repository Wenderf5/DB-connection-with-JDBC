package com.dbconnectionwithjdbc.dbconnection.DTO;

public class Person {
    private String id;
    private String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "ID: " + this.id + ", Name: " + this.name;
    }
}
