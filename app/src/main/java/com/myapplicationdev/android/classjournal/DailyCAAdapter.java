package com.myapplicationdev.android.classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DailyCAAdapter extends ArrayAdapter {

        private ArrayList<DailyCA> dailyCAS;
        private Context context;
        private TextView tvWeek, tvGrade;

        public DailyCAAdapter(Context context, int resource, ArrayList<DailyCA> objects){
            super(context, resource, objects);
            // Store the food that is passed to this adapter
            this.dailyCAS = objects;
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
            View rowView = inflater.inflate(R.layout.row, parent, false);

            // Get the TextView object
            tvWeek = (TextView) rowView.findViewById(R.id.textViewWeek);

            tvGrade = (TextView) rowView.findViewById(R.id.textViewGrade);


            // The parameter "position" is the index of the
            //  row ListView is requesting.
            //  We get back the food at the same index.
            DailyCA currentCA = dailyCAS.get(position);
            // Set the TextView to show the food

            tvWeek.setText("Week "+currentCA.getWeek());

            tvGrade.setText(currentCA.getDgGrade());

            return rowView;
        }

        public void add(DailyCA dailyCA){
            dailyCAS.add(dailyCA);
        }

    @Nullable
    @Override
    public Object getItem(int position) {
        return dailyCAS.get(position);
    }

    public int getLength(){
            return dailyCAS.size();
        }



    }
