package com.example.gymworkout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Define ActionBar object
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        // providing title for the ActionBar
        actionBar.setTitle("GYM WORKOUT");

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter

        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#FF171717"));
        int heading = Color.rgb(0,0,0);
        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);
        ImageButton info = findViewById(R.id.info_button);
        info.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "INFO", Toast.LENGTH_SHORT).show();
            Intent Info = new Intent(MainActivity.this,info.class);
            startActivity(Info);
        });
        Button login=findViewById(R.id.login_button);
        login.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
            Intent home=new Intent(MainActivity.this,Home.class);
            startActivity(home);

        });
        Button a=findViewById(R.id.hidden);
        a.setOnLongClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Mohit Malik apk", Toast.LENGTH_SHORT).show();
            Intent b=new Intent(MainActivity.this,owner.class);
            startActivity(b);
            return true;
        });
    }
}