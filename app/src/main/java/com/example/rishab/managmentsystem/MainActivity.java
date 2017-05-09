package com.example.rishab.managmentsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.rishab.managmentsystem.adapter.AdapterStudent;
import com.example.rishab.managmentsystem.model.Studentinfo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static int REQUEST_CODE = 2;
    private Button button;
    private Intent intent;
    private String mname;
    private String mrollno;
    private ArrayList<Studentinfo> studentInfoArrayList = new ArrayList<>();
    private LinearLayoutManager managerlinear;
    private GridLayoutManager managergrid;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.bt_createStudent);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, CreateStudent.class);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });
    }
    public  void layoutSelection(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Switch simpleSwitch = (Switch) findViewById(R.id.simpleSwitch);
        simpleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    recyclerView.setLayoutManager( new GridLayoutManager(MainActivity.this,2));
                } else{
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent intent){
            Studentinfo obj = intent.getParcelableExtra("infoobject");
            studentInfoArrayList.add(obj);
        AdapterStudent adapterStudent = new AdapterStudent(this, studentInfoArrayList);
        recyclerView = (RecyclerView) findViewById(R.id.rv_Students);
        recyclerView.setAdapter(adapterStudent);
        layoutSelection();
        recyclerView.setHasFixedSize(true);
    }

}
