package com.example.ncu.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormatSymbols;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lvMonth;
    String [] months;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMonth = findViewById(R.id.lvMonth);
        months = new DateFormatSymbols().getMonths();
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,months);
        lvMonth.setAdapter(monthAdapter);
        lvMonth.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //String month = parent.getItemAtPosition(position).toString();
        //String month = months[position];
        //String month =((TextView) view).getText().toString();
        String month = lvMonth.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(),"Clicked "+month,Toast.LENGTH_SHORT).show();
    }
}