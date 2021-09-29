package com.kanika.sehrawat.bakeryapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kanika.sehrawat.bakeryapp.Activity.adapter.CategoryAdapter;
import com.kanika.sehrawat.bakeryapp.Activity.adapter.PopularAdapter;
import com.kanika.sehrawat.bakeryapp.Activity.model.CategoryDomain;
import com.kanika.sehrawat.bakeryapp.Activity.model.FoodDomain;
import com.kanika.sehrawat.bakeryapp.R;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {
    TextView category_title, category_quote;
    ImageView category_header;
    private RecyclerView recyclerView;
    private PopularAdapter adapter;
    //ArrayList<FoodDomain> category_list = new ArrayList<>();
    String category_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        CategoryActivity categoryActivityContext = this;
        bottomNavigation(categoryActivityContext);

        Intent intent = getIntent();
        category_name = intent.getStringExtra("category").toString();

        category_title = (TextView) findViewById(R.id.category_title);
        category_title.setText(category_name);

        category_header = (ImageView) findViewById(R.id.category_header);
        category_quote = (TextView) findViewById(R.id.category_quote);

        if(category_name.equals("Cake")){
            category_quote.setText("\"Beautiful Cakes for Beautiful Occasions.\"");
            category_header.setImageResource(R.drawable.cake_header);
        }
        if(category_name.equals("Cup Cake")){
            category_quote.setText("\"Enjoy the JOY of Best Cup Cakes.\"");
            category_header.setImageResource(R.drawable.cupcake_header);
        }
        else if(category_name.equals("Donut")){
            category_quote.setText("\"Nothing can beat a good Donut\"");
            category_header.setImageResource(R.drawable.donut_header);
        }
        else if(category_name.equals("Cookies")){
            category_quote.setText("\"Life is better with fresh baked cookies.\"");
            category_header.setImageResource(R.drawable.cookies_header);
        }
        else if(category_name.equals("Bread")){
            category_quote.setText("\"Quality bread for a healthy slice of life\"");
            category_header.setImageResource(R.drawable.breads_header);
        }
        else if(category_name.equals("Pizza")){
            category_quote.setText("\"Beauty comes in all shapes and sizes. Small, large, circle, square, thin crust, thick crust, stuffed crust, extra toppings.\"");
            category_header.setImageResource(R.drawable.pizza_header);
        }

        recyclerview();
    }

    private void recyclerview(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView = findViewById(R.id.categories_recycler);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<FoodDomain> category_list = new ArrayList<>();
        for(FoodDomain food:MainActivity.foodlist){
            if(food.getCategory().toString().equals(category_name.toString())){
                Log.d("s","category of food "+food.getCategory().toString());
                category_list.add(food);
            }
        }
        adapter = new PopularAdapter(category_list);
        recyclerView.setAdapter(adapter);

    }

    private void bottomNavigation(Context context) {
        LinearLayout home_btn = findViewById(R.id.home_btn);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("name",IntroActivity.user_name);
                startActivity(intent);
            }
        });

        LinearLayout location_btn = findViewById(R.id.location_btn);
        location_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LocationActivity.class);
                startActivity(intent);
            }
        });


        LinearLayout profile_btn = findViewById(R.id.profile_btn);
        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProfileActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout contact_btn = findViewById(R.id.support_btn);
        contact_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ContactActivity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton cart_btn = findViewById(R.id.cart_btn);
        cart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CartListActivity.class);
                startActivity(intent);
            }
        });

    }

}