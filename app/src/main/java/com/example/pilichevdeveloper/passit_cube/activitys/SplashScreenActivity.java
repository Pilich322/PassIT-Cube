package com.example.pilichevdeveloper.passit_cube.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.pilichevdeveloper.passit_cube.data.Student;
import com.example.pilichevdeveloper.passit_cube.database.DBManager;
import com.pilichevdeveloper.passit_cube.R;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
//            DBManager dbManager = new DBManager(this);
//            dbManager.openDb();
//            if(dbManager.checkStudent()){
//                Student student = dbManager.getStudent();
//                intent.putExtra(Student.class.getName(),student);
//            }
                startActivity(intent);
            finish();
        }, 1000);
    }
}