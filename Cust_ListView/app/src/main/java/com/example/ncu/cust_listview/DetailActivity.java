package com.example.ncu.cust_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    Exercise selectExercise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSelectedShape();
        getValues();
    }
    private void getSelectedShape()
    {
       Intent previousIntent = getIntent();
       String parsedStringId = previousIntent.getStringExtra("id");
       selectExercise = MainActivity.exerciseList.get(Integer.valueOf(parsedStringId));

    }
    private void getValues()
    {
        TextView tv=(TextView) findViewById(R.id.ExerciseName);
        ImageView iv=(ImageView) findViewById(R.id.ExerciseImage);
        tv.setText(selectExercise.getName());
        iv.setImageResource(selectExercise.getImage());
    }
}