package com.myapplicationdev.android.classjournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddDataActivity extends AppCompatActivity {

    TextView tvWeek;
    RadioGroup rbGrade;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        tvWeek = findViewById(R.id.tvWeek);
        rbGrade = findViewById(R.id.rbGradeGroup);
        btnSubmit = findViewById(R.id.buttonSubmit);

        Intent intent = getIntent();

        final DailyCA dailyCA = (DailyCA) intent.getSerializableExtra("cag");

        tvWeek.setText("Week "+dailyCA.getWeek());

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                int selectedID = rbGrade.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectedID);

                dailyCA.setDgGrade(radioButton.getText().toString());

                i.putExtra("grade", dailyCA);
                // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }

}
