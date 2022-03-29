package com.example.hogwartsnotes;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_Add_Task extends Fragment {

    private EditText title;
    private EditText desc;
    private TextView courseTxt;
    private ImageButton saveBtn;
    private String course;
    private ImageView imageView1,imageView2;


    public Fragment_Add_Task() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment__add__task, container, false);
        title = v.findViewById(R.id.input_title_task);
        desc = v.findViewById(R.id.input_description_task);
        courseTxt = v.findViewById(R.id.from_course);
        imageView1 = v.findViewById(R.id.hiasan1);
        imageView2 = v.findViewById(R.id.hiasan2);
        saveBtn = v.findViewById(R.id.save);

        Bundle bundle = this.getArguments();
        course = bundle.getString("KEY").toString();

        courseTxt.setText(this.course);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendData();
            }
        });

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void sendData(){
        Intent i = new Intent(getActivity().getBaseContext(), MainActivity2.class);
        i.putExtra("SENDER_KEY","Fragment_Add_Task");
        i.putExtra("Title_Task", title.getText().toString());
        i.putExtra("Desc_Task", desc.getText().toString());
        i.putExtra("From_Course", courseTxt.getText().toString());
        startActivity(i);
    }
}