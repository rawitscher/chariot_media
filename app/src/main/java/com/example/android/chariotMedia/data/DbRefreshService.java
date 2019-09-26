package com.example.android.chariotMedia.data;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

public class DbRefreshService extends JobIntentService {
    public static final int JOB_ID = 1;

    public static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, DbRefreshService.class, JOB_ID, work);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        // your code
        Intent serviceIntent = new Intent(this, FetchVideoService.class);
        this.startService(serviceIntent);
    }

}
