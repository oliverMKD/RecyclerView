package com.oli.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by oliver on 12/7/2017.
 */

public class CustomStudentsAdapter extends RecyclerView.Adapter<CustomStudentsAdapter.ViewHolder> {


    Context context;
    List<Student> studentList = new ArrayList<>();

    public void setItems(List<Student> students) {
        studentList = students;
    }

    public CustomStudentsAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }
    public CustomStudentsAdapter(Context context2){
        context = context2;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.recyclerviewrow, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.textView.setText(student.sName);
        if (student.issOnline()) {
            holder.textView2.setText("online");
            holder.textView2.setBackgroundColor(Color.GRAY);
            holder.textView2.setTextColor(Color.CYAN);
        } else {
            holder.textView2.setText("Offline");
            holder.textView2.setBackgroundColor(Color.BLUE);
            holder.textView2.setTextColor(Color.CYAN);
        }
        Picasso.with(context).load("http://www.abc.net.au/news/image/6473316-3x2-340x227.jpg").fit().centerInside().into(holder.slika);
    }





    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.slika)
        ImageView slika;
        @BindView(R.id.text)
        TextView textView;
        @BindView(R.id.text2)
        TextView textView2;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
