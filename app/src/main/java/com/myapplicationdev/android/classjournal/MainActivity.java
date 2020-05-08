package com.myapplicationdev.android.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvModule;
    ModuleAdapter moduleAdapter;
    ArrayList<Module> modules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modules = new ArrayList<Module>();
        lvModule = findViewById(R.id.lvModule);
        moduleAdapter = new ModuleAdapter(MainActivity.this, R.layout.custom_module_row, modules);

        modules.add(new Module("C347", "Android Programming II"));
        modules.add(new Module("C302", "Web Services"));

        lvModule.setAdapter(moduleAdapter);
        moduleAdapter.notifyDataSetChanged();

        lvModule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, DGActivity.class);

                if(position == 0){
                    intent.putExtra("code", moduleAdapter.getItem(position).getModuleCode());
                }
                else{
                    intent.putExtra("code", moduleAdapter.getItem(position).getModuleCode());
                }

                startActivity(intent);
            }
        });

    }
}
