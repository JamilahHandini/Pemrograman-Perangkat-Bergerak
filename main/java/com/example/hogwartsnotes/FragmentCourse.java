package com.example.hogwartsnotes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentCourse extends Fragment {


    private TextView courseTxt, taskTxt, descTxt;
    private String course,task,desc;
    public FragmentCourse() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course, container, false);
        courseTxt = view.findViewById(R.id.name_course);
        taskTxt = view.findViewById(R.id.name_task);
        descTxt = view.findViewById(R.id.name_desc);
        // Inflate the layout for this fragment

        Bundle bundle = getArguments();

        if(bundle != null){
            course = bundle.getString("From_Course");
            task = bundle.getString("Title_Task");
            desc = bundle.getString("Desc_Task");

        }



        courseTxt.setText(course);
        taskTxt.setText(task);
        descTxt.setText(desc);

        return view;
    }
}