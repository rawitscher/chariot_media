package com.example.android.chariotMedia.ui;
import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.example.android.chariotMedia.data.DbRefreshService;


public class StartupActivity extends Application {

    private static final String TAG = "MyActivity";

    @Override
    public void onCreate(){
        super.onCreate();
        // Start an Intent to fetch the videos.
        Log.d(TAG, "FETCHING MEDIA UPDATE - FIRST APP LOADING");
        DbRefreshService.enqueueWork(this, new Intent());
    }
}