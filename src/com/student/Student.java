package com.student;

public class Student {
    private int id;
    private String name;
    private String address;
    private String grade;

    public Student() {
        id = 0;
        name = null;
        address = null;
        this(id, name, address);
    }

    public Student(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public static void main(String[] args) {
        Student s = new Student();
        s.grade = "A";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        if (isManager()) {
            this.grade = grade;
        }
    }

    private boolean isManager() {
        return true;
    }
}
