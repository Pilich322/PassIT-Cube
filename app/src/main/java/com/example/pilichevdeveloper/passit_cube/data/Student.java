package com.example.pilichevdeveloper.passit_cube.data;

import java.io.Serializable;

public class Student implements Serializable {
    private String firstName;
    private String secondName;
    private String middleName;
    private String login;
    private String password;
    private Integer id;
    private String groupName;
    private String schedule;



    public Student(String firstName, String secondName, String middleName, String login, String password, String groupName, String schedule) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.login = login;
        this.password = password;
        this.groupName = groupName;
        this.schedule = schedule;
    }

    public Student() {
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
