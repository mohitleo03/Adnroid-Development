package com.kanika.sehrawat.bakeryapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kanika.sehrawat.bakeryapp.Activity.adapter.PopularAdapter;
import com.kanika.sehrawat.bakeryapp.Activity.model.FoodDomain;
import com.kanika.sehrawat.bakeryapp.R;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PopularAdapter adapter;
    //private ArrayList<FoodDomain> foodlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        FoodActivity food_context = this;
        bottomNavigation(food_context);

        recyclerview();
        EditText search = findViewById(R.id.search_bar);
        showSoftKeyboard(search);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    private void filter(String s){
        ArrayList<FoodDomain> filteredlist = new ArrayList<>();
        for(FoodDomain food:MainActivity.foodlist){
            if(food.getTitle().toLowerCase().contains(s.toLowerCase())){
                filteredlist.add(food);
            }
        }
        adapter.filterList(filteredlist);
    }

    private void recyclerview(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView = findViewById(R.id.search_recycler);
        recyclerView.setLayoutManager(linearLayoutManager);

        /*
        foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("chocolate sprinkled donut", R.drawable.choco_donut,"Moist & fluffy donut glazed with chocolate\n" +
                "\nAllergens: Products may contains wheat, milk, soya or nuts.",80.00));
        foodlist.add(new FoodDomain("pinata cake", R.drawable.pinata_cake,
                "A new way to surprise your loved ones. This Pinata heart comes with a hammer inside the box " +
                        "The heart is hollow, and is filled with chocolate cake and candies.\n" +
                        "\nAllergens: Products may contains wheat, milk, soya or nuts.",2000.00));
        foodlist.add(new FoodDomain("unicorn cake", R.drawable.uni_cake,"It's magical from both inside and outside. " +
                "Swirling in delicious flavors, this unicorn fondant cake is sure to bring the mysterious world " +
                "of fairytale down to the earth and in your party room. ",1200.00));
        foodlist.add(new FoodDomain("choco chip cookies", R.drawable.choco_cookies,"Chocolate Chip Cookies are crunchy and chewy with true rich taste of cocoa and chocolate chips. ",
                180.00));*/

        adapter = new PopularAdapter(MainActivity.foodlist);
        recyclerView.setAdapter(adapter);
    }

    public void showSoftKeyboard(View view) {
        if(view.requestFocus()){
            InputMethodManager imm =(InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view,InputMethodManager.SHOW_IMPLICIT);
        }
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
