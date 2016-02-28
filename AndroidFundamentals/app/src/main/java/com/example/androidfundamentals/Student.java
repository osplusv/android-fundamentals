package com.example.androidfundamentals;

/**
 * Created by Osvaldo Villagrana on 2/27/16.
 */
public class Student {
    private String name;
    private String lastname;
    private String career;

    public Student(String name, String lastname, String career) {
        this.name = name;
        this.lastname = lastname;
        this.career = career;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}
