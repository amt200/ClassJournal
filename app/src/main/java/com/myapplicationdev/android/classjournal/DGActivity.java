package com.myapplicationdev.android.classjournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class DGActivity extends AppCompatActivity {

    ListView lvDG;
    DailyCAAdapter dailyCAAdapter;
    ArrayList<DailyCA> dailyCAS;
    Button btnInfo, btnAdd, btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dg);

        lvDG = findViewById(R.id.lvCAG);
        dailyCAS = new ArrayList<DailyCA>();
        dailyCAAdapter = new DailyCAAdapter(DGActivity.this, R.layout.row, dailyCAS);
        btnInfo = findViewById(R.id.buttonInfo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnEmail = findViewById(R.id.buttonEmail);

        Intent intent = getIntent();

        String code = intent.getStringExtra("code");

        dailyCAS.add(new DailyCA("B", code, 1));
        dailyCAS.add(new DailyCA("C", code, 2));
        dailyCAS.add(new DailyCA("A", code, 3));

        lvDG.setAdapter(dailyCAAdapter);

        dailyCAAdapter.notifyDataSetChanged();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
