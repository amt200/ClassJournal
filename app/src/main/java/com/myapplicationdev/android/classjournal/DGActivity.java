package com.myapplicationdev.android.classjournal;

import android.content.Intent;
import android.net.Uri;
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
    int requestCodeAdd = 100;
    int requestCodeInfo = 200;

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

        final String code = intent.getStringExtra("code");

        getSupportActionBar().setTitle("Info for "+code);

        dailyCAS.add(new DailyCA("B", code, 1));
        dailyCAS.add(new DailyCA("C", code, 2));
        dailyCAS.add(new DailyCA("A", code, 3));

        lvDG.setAdapter(dailyCAAdapter);

        dailyCAAdapter.notifyDataSetChanged();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAct3 = new Intent(DGActivity.this, AddDataActivity.class);
                int weekNo = dailyCAAdapter.getLength()+1;
                DailyCA dailyCA = new DailyCA("", code, weekNo);
                intentAct3.putExtra("cag", dailyCA);
                startActivityForResult(intentAct3, requestCodeAdd);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                String url = "https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/"+code;
                // Set the URL to be used.
                rpIntent.setData(Uri.parse(url));
                startActivityForResult(rpIntent, requestCodeInfo);

            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "";

                for(int i = 0; i < dailyCAAdapter.getLength(); i++){
                    DailyCA dailyCA = (DailyCA)dailyCAAdapter.getItem(i);
                    message += "Week "+dailyCA.getWeek()+": DG: "+dailyCA.getDgGrade()+"\n";
                }
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "Test Email from C347");
                email.putExtra(Intent.EXTRA_TEXT,
                        message);
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if(resultCode == RESULT_OK){
            if (data != null) {
                // Get data passed back from 2nd activity
                DailyCA grade = (DailyCA) data.getSerializableExtra("grade");
                if(requestCode == requestCodeAdd){
                    dailyCAAdapter.add(grade);
                    dailyCAAdapter.notifyDataSetChanged();
                }


            }
        }
    }


}
