package com.example.pilichevdeveloper.passit_cube.fragments;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pilichevdeveloper.passit_cube.data.Student;
import com.pilichevdeveloper.passit_cube.databinding.FragmentMainBinding;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pilichevdeveloper.passit_cube.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.example.pilichevdeveloper.passit_cube.database.DBManager;


public class MainFragment extends Fragment {
    FragmentMainBinding binding;
    DBManager dbManager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //Дописать код, когда будет APi. При проверке получать студента и добовлять его в БД.
        //Если не будет интернета на сплэш скрине, то проверять в БД тут.
        super.onViewCreated(view, savedInstanceState);
        BottomSheetBehavior.from(binding.bottomSheet);
        dbManager = new DBManager(getContext());
        dbManager.openDb();
        binding.buttonCheck.setOnClickListener(v -> {
            String login = binding.editTextLogin.getText().toString();
            String password = binding.editTextPassword.getText().toString();
            try {
                if (login.equals("") & password.equals(""))
                    //Получать студента тут
                    Toast.makeText(getContext(), "Вы не заполнили поля", Toast.LENGTH_SHORT).show();
                    //Если нет интеренета, то чекать через БД
                else if (dbManager.checkStudentInDataBase(login, password)) {
                    Student student = dbManager.getStudent();
                    setFragment(student);
                }
                else
                    Toast.makeText(getContext(), "Вы отсутсвуете в системе", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Log.e("ERROR",e.toString());
            }
        });
    }

    public void setFragment(Student student) {
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, new PassFragment(student)).disallowAddToBackStack()
                .commit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dbManager.closeDb();
    }
}