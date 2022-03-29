package com.example.hogwartsnotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.myViewHolder2> {

    Context mContext;
    List<Task> mData;

    public RecyclerViewAdapter2(Context mContext, List<Task> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }



    @NonNull
    @Override
    public myViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.fragment_done,parent,false);
        myViewHolder2 vHolder = new myViewHolder2(v);


        return vHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder2 holder, int position) {
        holder.courseTxt.setText(mData.get(position).getT_course());
        holder.taskTxt.setText(mData.get(position).getT_task());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class myViewHolder2 extends RecyclerView.ViewHolder{
        private TextView courseTxt, taskTxt;

        public myViewHolder2(@NonNull View itemView) {
            super(itemView);

            courseTxt = itemView.findViewById(R.id.title_task_done);
            taskTxt = itemView.findViewById(R.id.title_course_done);

        }
    }
}
