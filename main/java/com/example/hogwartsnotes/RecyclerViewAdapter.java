package com.example.hogwartsnotes;

import static android.app.PendingIntent.getActivity;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder> {
    private static RecyclerViewClickListener listener;
    Context mContext;
    List<Task> mData;

    public RecyclerViewAdapter(Context mContext, List<Task> mData, RecyclerViewClickListener listener) {
        this.mContext = mContext;
        this.mData = mData;
        this.listener = listener;
    }



    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.fragment_course,parent,false);
        myViewHolder vHolder = new myViewHolder(v);

        return vHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.courseTxt.setText(mData.get(position).getT_course());
        holder.taskTxt.setText(mData.get(position).getT_task());
        holder.descTxt.setText(mData.get(position).getD_task());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);

    }

    public static class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView courseTxt, taskTxt, descTxt;
        ImageButton addButton;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            courseTxt = itemView.findViewById(R.id.name_course);
            taskTxt = itemView.findViewById(R.id.name_task);
            descTxt = itemView.findViewById(R.id.name_desc);
            itemView.setOnClickListener(this);

            addButton =  itemView.findViewById(R.id.add_note);
        }

        @Override
        public void onClick(View itemView) {
            listener.onClick(itemView, getAdapterPosition());
        }


    }
}
