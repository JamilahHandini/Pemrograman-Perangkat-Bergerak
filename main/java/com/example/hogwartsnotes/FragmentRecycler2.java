package com.example.hogwartsnotes;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class FragmentRecycler2 extends Fragment {

    View v;
    private RecyclerView rcyView;
    private List<Task> listTask;


    public FragmentRecycler2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_recycler2, container, false);



        Toast.makeText(getContext(), "add list", Toast.LENGTH_SHORT).show();

        rcyView = (RecyclerView) v.findViewById(R.id.done_rcy);

        RecyclerViewAdapter2 rcyAdapter = new RecyclerViewAdapter2(getContext(),listTask);
        rcyView.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcyView.setAdapter(rcyAdapter);
        return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listTask = new ArrayList<>();
        listTask.add(new Task("Mobile", "Make an Application", "Application for solving someone problems"));

        Toast.makeText(getContext(), "List Done", Toast.LENGTH_SHORT).show();
    }
}