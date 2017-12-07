package com.oli.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oliver on 12/7/2017.
 */

public class CustomStudentsAdapter extends RecyclerView.Adapter<CustomStudentsAdapter.ViewHolder>  {

    List<Student> studentList = new ArrayList<>();

    public void setItems(List<Student>students){
        studentList = students;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.recyclerviewrow,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    Student student = studentList.get(position);
    holder.textView.setText(student.sName);

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text)
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
