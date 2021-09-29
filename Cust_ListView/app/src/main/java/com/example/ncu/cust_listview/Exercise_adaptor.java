package com.example.ncu.cust_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class Exercise_adaptor extends ArrayAdapter<Exercise> {
     public Exercise_adaptor(Context context,int resource, List<Exercise> exerciseList)
     {
         super(context,resource,exerciseList);
     }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Exercise exercise=getItem(position);
        if (convertView==null)
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.exercise_cell,parent,false);
        TextView tv=(TextView)convertView.findViewById(R.id.ExerciseName);
        ImageView iv=(ImageView)convertView.findViewById(R.id.ExerciseImage);
        tv.setText(exercise.getName());
        iv.setImageResource(exercise.getImage());
        return convertView;
    }
}
