package com.example.gymworkout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Define ActionBar object
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        // providing title for the ActionBar
        actionBar.setTitle("GYM WORKOUT");

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("black"));

        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);
        Button warmup = findViewById(R.id.warmUp);
        warmup.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "WarmUp", Toast.LENGTH_SHORT).show();
            Intent WarmUp = new Intent(Home.this, WarmUp.class);
            startActivity(WarmUp);
        });

        Button workout = findViewById(R.id.workout);
        workout.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Workouts", Toast.LENGTH_SHORT).show();
            Intent Workouts = new Intent(Home.this,Workouts.class);
            startActivity(Workouts);

        });

        Button diet = findViewById(R.id.diet);
        diet.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Diet Plan", Toast.LENGTH_SHORT).show();
            Intent Diet = new Intent(Home.this, Diet.class);
            startActivity(Diet);
        });

        Button tips = findViewById(R.id.tips);
        tips.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Tips", Toast.LENGTH_SHORT).show();
            Intent Tips = new Intent(Home.this, Tips.class);
            startActivity(Tips);
        });

    }
}

