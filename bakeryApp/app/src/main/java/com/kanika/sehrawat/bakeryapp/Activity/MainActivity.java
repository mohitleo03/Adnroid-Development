package com.kanika.sehrawat.bakeryapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.huawei.agconnect.appmessaging.AGConnectAppMessaging;
import com.huawei.agconnect.appmessaging.AGConnectAppMessagingOnClickListener;
import com.huawei.agconnect.appmessaging.model.AppMessage;
import com.kanika.sehrawat.bakeryapp.Activity.adapter.CategoryAdapter;
import com.kanika.sehrawat.bakeryapp.Activity.adapter.PopularAdapter;
import com.kanika.sehrawat.bakeryapp.Activity.model.CategoryDomain;
import com.kanika.sehrawat.bakeryapp.Activity.model.FoodDomain;
import com.kanika.sehrawat.bakeryapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, popularAdapter;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;
    TextView welcome_msg;
    LinearLayout location_btn;
    FloatingActionButton cart_btn;
    ConstraintLayout order_now;
    public static ArrayList<FoodDomain> foodlist = new ArrayList<>();
    public static ArrayList<CategoryDomain> categoryList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String str = intent.getStringExtra("name");
        /*
        if(str==null){
            str = "";
        }*/
        welcome_msg = (TextView) findViewById(R.id.welcome_message);
        welcome_msg.setText("Welcome "+ str);

        order_now = findViewById(R.id.order_now);
        order_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent food_activity = new Intent(MainActivity.this, FoodActivity.class);
                startActivity(food_activity);
            }
        });

        MainActivity main_context = MainActivity.this;
        bottomNavigation(main_context);
        recyclerViewCategory();
        recyclerViewPopular();
        search();
        inAppMessage();
    }

    public void inAppMessage(){
        //AGConnectAppMessaging.getInstance().setFetchMessageEnable(true);
        AGConnectAppMessaging appMessaging = AGConnectAppMessaging.getInstance();
        appMessaging.setFetchMessageEnable(true);
        appMessaging.setDisplayEnable(true);
        appMessaging.setForceFetch();
        ClickListener listener = new ClickListener();
        appMessaging.addOnClickListener(listener);
    }

    public class ClickListener implements AGConnectAppMessagingOnClickListener {
        @Override
        public void onMessageClick(AppMessage appMessage) {
            // Obtain the content of the tapped message.
        }
    }


    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("chocolate sprinkled donut", R.drawable.choco_donut,"Moist & fluffy donut glazed with chocolate\n" +
                "\nAllergens: Products may contains wheat, milk, soya or nuts.",80.00,"Donut"));
        foodlist.add(new FoodDomain("pinata cake", R.drawable.pinata_cake,
                "A new way to surprise your loved ones. This Pinata heart comes with a hammer inside the box " +
                        "The heart is hollow, and is filled with chocolate cake and candies."
                        ,2000.00,"Cake"));
        foodlist.add(new FoodDomain("unicorn cake", R.drawable.uni_cake,"It's magical from both inside and outside. " +
                "Swirling in delicious flavors, this unicorn fondant cake is sure to bring the mysterious world " +
                "of fairytale down to the earth and in your party room. ",1200.00,"Cake"));
        foodlist.add(new FoodDomain("choco chip cookies", R.drawable.choco_cookies,"Chocolate Chip Cookies are crunchy and chewy with true rich taste of cocoa and chocolate chips. ",
                180.00,"Cookies"));
        foodlist.add(new FoodDomain("Nutella cupcakes", R.drawable.nutella_cupcakes,"These Nutella cupcakes have a delicious vanilla"+
                "and nutella sponge. Topped with a creamy nutella icing. ",420.00,"Cup Cake"));
        foodlist.add(new FoodDomain("Rainbow cupcakes",R.drawable.rainbow_cupcakes,"All our products are handcrafted and hence might vary from the picture visible on our website, which is for reference only",840.00,"Cup Cake"));
        foodlist.add(new FoodDomain("Choco Vanilla Cupcake",R.drawable.choco_vanilla_cupcakes,"Coming with chocolate cup cake base, whipped vanilla cream, chocolate sauce and the sprinkles of edible sugar candies, these cupcakes can easily hold a permanent space in anyone's heart. ",420.00,"Cup Cake"));
        foodlist.add(new FoodDomain("Garlic breadsticks",R.drawable.garlic_bread_sticks,"Baked to perfection! Tastes best with dip",99.00,"Bread"));
        foodlist.add(new FoodDomain("Stuffed garlic bread",R.drawable.stuffed_garlic_bread,"Freshly Baked Garlic Bread stuffed with mozzarella cheese,"+
                " sweet corns & tangy and spicy jalapeños",149.00,"Bread"));
        foodlist.add(new FoodDomain("Farmhouse Pizza",R.drawable.farmhouse_pizza,"Delightful combination of onion, capsicum, tomato & grilled mushroom",399.00,"Pizza"));
        foodlist.add(new FoodDomain("Peppy Paneer Pizza",R.drawable.peppy_paneer,"Flavorful trio of juicy paneer, crisp capsicum with spicy red paprika",399.00,"Pizza"));
        foodlist.add(new FoodDomain("Double Cheese Pizza",R.drawable.double_cheese,"A classic delight loaded with extra 100% real mozzarella cheese",339.00,"Pizza"));

        popularAdapter = new PopularAdapter(foodlist);
        recyclerViewPopularList.setAdapter(popularAdapter);
    }

    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.CategoryRecyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        categoryList=new ArrayList<>();
        categoryList.add(new CategoryDomain("Cake", R.drawable.cake));
        categoryList.add(new CategoryDomain("Cup Cake", R.drawable.cupcake));
        categoryList.add(new CategoryDomain("Donut", R.drawable.donut));
        categoryList.add(new CategoryDomain("Cookies", R.drawable.cookies));
        categoryList.add(new CategoryDomain("Bread", R.drawable.bread));
        categoryList.add(new CategoryDomain("Pizza", R.drawable.pizza));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
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

    private void search(){
        EditText search_box = findViewById(R.id.search_box);
        search_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FoodActivity.class);
                startActivity(intent);
            }
        });
    }

}