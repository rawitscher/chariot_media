package com.com.android.chariotMedia.ui;
import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.com.android.chariotMedia.BuildConfig;
import com.com.android.chariotMedia.data.DbRefreshService;


public class StartupActivity extends Application {

    private static final String TAG = "MyActivity";

    @Override
    public void onCreate(){
        super.onCreate();
        // Start an Intent to fetch the videos.
        if (BuildConfig.DEBUG)Log.d(TAG, "FETCHING MEDIA UPDATE - FIRST APP LOADING");
        DbRefreshService.enqueueWork(this, new Intent());
    }
}