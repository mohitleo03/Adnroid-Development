package com.kanika.sehrawat.bakeryapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.huawei.hms.maps.CameraUpdateFactory;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.HuaweiMapOptions;
import com.huawei.hms.maps.MapFragment;
import com.huawei.hms.maps.OnMapReadyCallback;
import com.huawei.hms.maps.SupportMapFragment;
import com.huawei.hms.maps.model.BitmapDescriptor;
import com.huawei.hms.maps.model.BitmapDescriptorFactory;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.Marker;
import com.huawei.hms.maps.model.MarkerOptions;
import com.kanika.sehrawat.bakeryapp.R;

public class LocationActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final String TAG = "StoreLocation";

    private HuaweiMap hMap;
    private SupportMapFragment mSupportMapFragment;
    private Marker mMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        LocationActivity location_context = this;
        bottomNavigation(location_context);

        mSupportMapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.supportMap);
        mSupportMapFragment.getMapAsync(this);


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


    public void onMapReady(HuaweiMap huaweiMap) {
        Log.d(TAG, "onMapReady: ");
        hMap = huaweiMap;
        hMap.addMarker(new MarkerOptions().position(new LatLng(28.544148420981802,77.11977789173126)).title("Bakery").icon(BitmapDescriptorFactory.fromResource(R.drawable.bakery_loc)));
    }

    //public void addMarker(View view) {
      //  if (null != mMarker) {
        //    mMarker.remove();
        //}        MarkerOptions options = new MarkerOptions()
          //      .position(new LatLng(77.11977789173126, 28.544148420981802))
            //    .title("Hello Huawei Map")
              //  .snippet("This is a snippet!");
        //mMarker = hMap.addMarker(options);
    //}

}

