package com.example.hogwartsnotes;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class FragmentRecycler extends Fragment {

    View v;
    private RecyclerView rcyView;
    private List<Task> listTask;
    private RecyclerViewAdapter.RecyclerViewClickListener listener;


    String course,task,desc;


    public FragmentRecycler() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler, container, false);



        Toast.makeText(getContext(), "add list", Toast.LENGTH_SHORT).show();

        rcyView = (RecyclerView) v.findViewById(R.id.course_rcy);

        RecyclerViewAdapter rcyAdapter = new RecyclerViewAdapter(getContext(),listTask,listener);
        rcyView.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcyView.setAdapter(rcyAdapter);
        return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listTask = new ArrayList<>();
        Bundle bundle = getArguments();

        if(bundle != null){
            course = bundle.getString("key1");
            task = bundle.getString("key2");
            desc = bundle.getString("key3");

            Toast.makeText(getContext(), "bundle ada", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getContext(), "bundle kosong", Toast.LENGTH_SHORT).show();
        }




        listTask.add(new Task(this.course, this.task, this.desc));

        Toast.makeText(getContext(), "FR rcy", Toast.LENGTH_SHORT).show();
    }
}