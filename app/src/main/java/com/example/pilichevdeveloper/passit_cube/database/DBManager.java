package com.example.pilichevdeveloper.passit_cube.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pilichevdeveloper.passit_cube.data.Student;


public class DBManager {
    private final DBHelper dbHelper;
    private SQLiteDatabase db;

    public DBManager(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void insertStudent(Student student) {
        ContentValues cv = new ContentValues();
        cv.put(DBConst.STUDENT_FIRSTNAME, student.getFirstName());
        cv.put(DBConst.STUDENT_SECONDNAME, student.getSecondName());
        cv.put(DBConst.STUDENT_MIDDLENAME, student.getMiddleName());
        cv.put(DBConst.STUDENT_LOGIN, student.getLogin());
        cv.put(DBConst.STUDENT_PASSWORD, student.getPassword());
        cv.put(DBConst.STUDENT_GROUP_NAME, student.getGroupName());
        cv.put(DBConst.STUDENT_SCHEDULE, student.getSchedule());
        db.insert(DBConst.STUDENTS_TABLE_NAME, null, cv);
    }
    @SuppressLint("Range")
    public boolean checkStudentInDataBase(String login, String password) {
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("Select * From " + DBConst.STUDENTS_TABLE_NAME + " Where "
                + DBConst.STUDENT_LOGIN + " =  + '"+login+"'" + " and " + DBConst.STUDENT_PASSWORD + " = '"+password+"'", null);
            if(cursor.getCount() > 0) {
                cursor.close();
                return true;
            }
            else{
                cursor.close();
                return false;
            }
    }

    @SuppressLint("Range")
    public boolean checkStudent() {
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("Select * From " + DBConst.STUDENTS_TABLE_NAME, null);
        if(cursor.getCount() > 0) {
            cursor.close();
            return true;
        }

        else{
            cursor.close();
            return false;
        }

    }
    @SuppressLint("Range")
    public Student getStudent(String login, String password) {
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("Select * From " + DBConst.STUDENTS_TABLE_NAME + " Where "
                + DBConst.STUDENT_LOGIN + " =  + '"+login+"'" + " and " + DBConst.STUDENT_PASSWORD + " = '"+password+"'", null);
        if (cursor.getCount() > 0)
            while (cursor.moveToFirst()) {
                Student student = new Student();
                student.setLogin(cursor.getString(cursor.getColumnIndex(DBConst.STUDENT_LOGIN)));
                student.setPassword(cursor.getString(cursor.getColumnIndex(DBConst.STUDENT_PASSWORD)));
                student.setFirstName(cursor.getString(cursor.getColumnIndex(DBConst.STUDENT_FIRSTNAME)));
                student.setMiddleName(cursor.getString(cursor.getColumnIndex(DBConst.STUDENT_MIDDLENAME)));
                student.setSecondName(cursor.getString(cursor.getColumnIndex(DBConst.STUDENT_SECONDNAME)));
                student.setSchedule(cursor.getString(cursor.getColumnIndex(DBConst.STUDENT_SCHEDULE)));
                student.setGroupName(cursor.getString(cursor.getColumnIndex(DBConst.STUDENT_GROUP_NAME)));
                cursor.close();
                return student;
            }
        cursor.close();
        return null;
    }
    public void deleteStudent(Student student){
        db.delete(DBConst.STUDENTS_TABLE_NAME, DBConst.STUDENT_FIRSTNAME + " = +'" +student.getFirstName()+"'", null);
    }
    public void openDb() {
        db = dbHelper.getWritableDatabase();
    }

    public void closeDb() {
        db.close();
    }
}
