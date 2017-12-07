package com.oli.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        CustomStudentsAdapter adapter =  new CustomStudentsAdapter(this);

        adapter.setItems(generateList());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    ArrayList<Student> generateList(){
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Oliver",true));
        students.add(new Student("Goran",false));
        students.add(new Student("Pane", true));
        students.add(new Student("Oliver",true));
        students.add(new Student("Oliver",true));
        students.add(new Student("Oliver",true));
        students.add(new Student("Oliver",true));
        students.add(new Student("Oliver",true));
        students.add(new Student("Oliver",true));
        students.add(new Student("Oliver",true));
        students.add(new Student("Oliver",true));
        students.add(new Student("Oliver",true));
        students.add(new Student("Oliver",true));

        for (int i = 0; i <100 ; i++) {
            if (i%2==0) {
                students.add(new Student("Student" + i, true));
            } else {
                students.add(new Student("Student" + i,false));
            }
        }
        return students;
    }


}
