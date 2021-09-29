package com.kanika.sehrawat.bakeryapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kanika.sehrawat.bakeryapp.Activity.adapter.CartListAdapter;
import com.kanika.sehrawat.bakeryapp.Activity.Interface.ChangeNumberItemsListener;
import com.kanika.sehrawat.bakeryapp.Activity.helper.Database;
import com.kanika.sehrawat.bakeryapp.Activity.helper.ManagementCart;
import com.kanika.sehrawat.bakeryapp.Activity.Interface.ChangeNumberItemsListener;
import com.kanika.sehrawat.bakeryapp.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class CartListActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    private Database database;
    private TextView totalFeeTxt, taxTxt, deliveryTxt, totalTxt, emptyTxt, checkout_btn;
    private double tax;
    private ScrollView scrollView;
    private ChangeNumberItemsListener changeNumberItemsListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        managementCart = new ManagementCart(this);
        CartListActivity cart_context = this;

        initView();
        initList();
        calculateCart();
        bottomNavigation(cart_context);
        checkout();
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

    private void checkout(){
        TextView checkout_btn = findViewById(R.id.checkout_btn);;

        checkout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managementCart.clearlist();
                Intent intent = new Intent(CartListActivity.this, MainActivity.class);
                //startActivity(intent);
                Toast.makeText(getApplicationContext(), "Order placed successfully", Toast.LENGTH_LONG).show();
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        try{
                            Thread.sleep(1500);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.putExtra("name",IntroActivity.user_name);
                            startActivity(intent);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            }
        });
    }
    public void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(managementCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calculateCart();
            }
        });

        recyclerViewList.setAdapter(adapter);

        if (managementCart.getListCart().isEmpty()) {
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        } else {
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void calculateCart() {
        double percentTax = 5;
        double delivery = 10;
        double itemTotal=0;
        double total = 0;

        if(managementCart.getTotalFee()==0){
            tax=0;
        }
        else{
            tax = Math.round((percentTax/100)*managementCart.getTotalFee());
        }

        if(managementCart.getTotalFee()==0){
            delivery=0;
        }

        itemTotal = Math.round(managementCart.getTotalFee()) ;

        total = Math.round(itemTotal + tax + delivery);

        totalFeeTxt.setText("₹" + itemTotal);
        taxTxt.setText("₹" + tax);
        deliveryTxt.setText("₹" + delivery);
        totalTxt.setText("₹" + total);
        if(total==0){
            initList();
        }
    }

    private void initView() {
        recyclerViewList = findViewById(R.id.recyclerview);
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        totalTxt = findViewById(R.id.totalTxt);
        emptyTxt = findViewById(R.id.emptyTxt);
        scrollView = findViewById(R.id.scrollView4);
        checkout_btn = findViewById(R.id.checkout_btn);
    }
}