package com.example.android.tvleanback.ui;
import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.example.android.tvleanback.data.DbRefreshService;
import com.example.android.tvleanback.data.FetchVideoService;


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