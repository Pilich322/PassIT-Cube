package com.example.pilichevdeveloper.passit_cube.activitys;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.pilichevdeveloper.passit_cube.data.Student;
import com.example.pilichevdeveloper.passit_cube.fragments.PassFragment;
import com.pilichevdeveloper.passit_cube.R;
import com.pilichevdeveloper.passit_cube.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        Bundle arguments = getIntent().getExtras();
        if(arguments!=null){
            Student student = (Student) arguments.getSerializable(Student.class.getName());
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainerView, new PassFragment(student)).disallowAddToBackStack()
                    .commit();
        }
        setContentView(binding.getRoot());
    }
}