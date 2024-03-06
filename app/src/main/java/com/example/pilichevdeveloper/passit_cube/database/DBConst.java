package com.example.pilichevdeveloper.passit_cube.database;

public class DBConst {
    public static final String DATABASE_NAME = "pass.db";
    public static final int DATABASE_VERSION = 1;
    public static final String STUDENTS_TABLE_NAME = "students";
    public static final String STUDENT_ID = "student_id";
    public static final String STUDENT_FIRSTNAME = "firstName";
    public static final String STUDENT_SECONDNAME = "lastName";
    public static final String STUDENT_MIDDLENAME = "middleName";
    public static final String STUDENT_LOGIN = "login";
    public static final String STUDENT_PASSWORD = "password";
    public static final String STUDENT_GROUP_NAME = "groupName";
    public static final String STUDENT_SCHEDULE = "schedule";



    public static final String CREATE_TABLE_STUDENTS = "create table if not exists " +
            STUDENTS_TABLE_NAME + " ( " + STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            STUDENT_FIRSTNAME + " text not null, " + STUDENT_SECONDNAME + " text not null, " +
            STUDENT_MIDDLENAME + " text not null, " + STUDENT_LOGIN + " TEXT UNIQUE not null, " +
            STUDENT_GROUP_NAME + " text not null, " + STUDENT_SCHEDULE + " text not null, " +
            STUDENT_PASSWORD + " text not null )";

    public static final String DELETE_TABLE_USER = "drop table if exists " + STUDENTS_TABLE_NAME;

}
