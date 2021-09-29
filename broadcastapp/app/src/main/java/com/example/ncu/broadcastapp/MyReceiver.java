package com.example.ncu.broadcastapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {//

    @Override
    public void onReceive(Context context, Intent intent) {

        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
       String action = intent.getAction();
        Toast.makeText(context,"I GOT"+action,Toast.LENGTH_LONG).show();
        String timezone = intent.getStringExtra("time_zone");
        Log.d("Changed to",timezone);

    }
}