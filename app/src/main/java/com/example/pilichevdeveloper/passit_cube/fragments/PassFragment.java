package com.example.pilichevdeveloper.passit_cube.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pilichevdeveloper.passit_cube.data.Student;
import com.pilichevdeveloper.passit_cube.databinding.FragmentPassBinding;

public class PassFragment extends Fragment {

    private Student student;
    public PassFragment(Student student){
        this.student = student;
    }
    FragmentPassBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPassBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.textViewStudent.setText(student.getSecondName() + " " +student.getFirstName()+" " + student.getMiddleName());
        binding.textViewGroupName.setText(student.getGroupName());
        binding.textViewTime.setText(student.getSchedule());
    }
}