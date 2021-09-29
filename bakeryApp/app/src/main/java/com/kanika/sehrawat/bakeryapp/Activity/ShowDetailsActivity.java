package com.kanika.sehrawat.bakeryapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kanika.sehrawat.bakeryapp.Activity.helper.ManagementCart;
import com.kanika.sehrawat.bakeryapp.Activity.model.FoodDomain;
import com.kanika.sehrawat.bakeryapp.R;


public class ShowDetailsActivity extends AppCompatActivity {
    private TextView add_to_cart_btn;
    private TextView title_txt, cost_txt, description_txt, quantity_txt;
    private ImageView plus_btn, minus_btn, food_pic;
    private FoodDomain object;
    private int quantity=1;
    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);


        ShowDetailsActivity details_activity = this;
        bottomNavigation(details_activity);

        managementCart = new ManagementCart(this);

        details();
        getBundle();
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


    private void getBundle(){
        object = (FoodDomain) getIntent().getSerializableExtra("object");
        food_pic.setImageResource(object.getPic());
        title_txt.setText(object.getTitle());
        cost_txt.setText("₹"+object.getPrice());
        description_txt.setText(object.getDescription());
        quantity_txt.setText(String.valueOf(quantity));

        plus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity = quantity+1;
                quantity_txt.setText(String.valueOf(quantity));
            }
        });

        minus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity>1){
                    quantity=quantity-1;
                }
                quantity_txt.setText(String.valueOf(quantity));
            }
        });

        add_to_cart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setQuantity(quantity);
                managementCart.insertFood(object);

            }
        });

    }

    private void details(){
        add_to_cart_btn = findViewById(R.id.add_to_cart_btn);
        title_txt = findViewById(R.id.titleText);
        cost_txt = findViewById(R.id.priceText);
        description_txt = findViewById(R.id.description_txt);
        quantity_txt = findViewById(R.id.quantity_txt);
        plus_btn = findViewById(R.id.plus_btn);
        minus_btn = findViewById(R.id.minus_btn);
        food_pic = findViewById(R.id.food_pic);

    }
}