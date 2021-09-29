package com.example.ncu.cust_listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.CircularArray;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Exercise> exerciseList = new ArrayList<Exercise>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupData();
        setUpList();
        setUpOnClickListener();
    }

    private void setupData() {
        Exercise benchpress = new Exercise("0", "BenchPress", R.drawable.benchpress);
        exerciseList.add(benchpress);
        Exercise butterfly = new Exercise("1", "Butterfly", R.drawable.butterfly);
        exerciseList.add(butterfly);
        Exercise single_arm_dumbbell_row = new Exercise("2", "Single Arm Dumbbell Row", R.drawable.single_arm_dumbbell_row);
        exerciseList.add(single_arm_dumbbell_row);
        Exercise bent_over_barbell_row = new Exercise("3", "Bent Over Barbell Row", R.drawable.bent_over_barbell_row);
        exerciseList.add(bent_over_barbell_row);
        Exercise concentration_curl = new Exercise("4", "Concentration Curl", R.drawable.concentration_curl);
        exerciseList.add(concentration_curl);
        Exercise zottman_curl = new Exercise("5", "Zottman Curl", R.drawable.zottman_curl);
        exerciseList.add(zottman_curl);
        Exercise benchdip = new Exercise("6", "BenchDip", R.drawable.benchdip);
        exerciseList.add(benchdip);
        Exercise barbell_overhead_shoulder_press = new Exercise("7", "Barbell Overhead Shoulder Press", R.drawable.barbell_overhead_shoulder_press);
        exerciseList.add(barbell_overhead_shoulder_press);
        Exercise bicycle_crunches = new Exercise("8", "bicycle crunches", R.drawable.bicycle_crunches);
        exerciseList.add(bicycle_crunches);
        Exercise seated_russian_twist = new Exercise("9", "seated russian twist", R.drawable.seated_russian_twist);
        exerciseList.add(seated_russian_twist);
        Exercise leg_press = new Exercise("10", "leg press", R.drawable.leg_press);
        exerciseList.add(leg_press);
        Exercise squats_with_smith_machine = new Exercise("11", "squats with smith machine", R.drawable.squats_with_smith_machine);
        exerciseList.add(squats_with_smith_machine);
    }

    private void setUpList() {
        listView = (ListView) findViewById(R.id.exerciseListView);
        Exercise_adaptor adaptor = new Exercise_adaptor(getApplicationContext(), 0, exerciseList);
        listView.setAdapter(adaptor);
    }

    private void setUpOnClickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                Exercise selectExercise = (Exercise) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), DetailActivity.class);
                showDetail.putExtra("id", selectExercise.getId());
                startActivity(showDetail);

            }
        });

    }
}

