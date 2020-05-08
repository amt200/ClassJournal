package com.myapplicationdev.android.classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ModuleAdapter extends ArrayAdapter {

    private ArrayList<Module> modules;
    private Context context;
    private TextView tvCode, tvTitle;

    public ModuleAdapter(Context context, int resource, ArrayList<Module> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        this.modules = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.custom_module_row, parent, false);

        // Get the TextView object
        tvCode = (TextView) rowView.findViewById(R.id.tvModuleCode);

        tvTitle = (TextView) rowView.findViewById(R.id.tvModuleTitle);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Module currentModule = modules.get(position);
        // Set the TextView to show the food

        tvCode.setText(currentModule.getModuleCode());

        tvTitle.setText(currentModule.getModuleTitle());

        return rowView;
    }

    public void add(Module module){
        modules.add(module);
    }

    public Module getItem(int index){
        if(modules.size() < 1) {
            return null;
        }
        return modules.get(index);
    }

    public int getLength(){
        return modules.size();
    }

}
