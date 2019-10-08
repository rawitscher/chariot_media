/*
 * Copyright (c) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.chariotMedia.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.example.android.chariotMedia.Manifest;
import com.example.android.chariotMedia.R;

/*
 * MainActivity class that loads MainFragment.
 */
public class MainActivity extends LeanbackActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: Update media content

        setContentView(R.layout.main);
        getPermissionToAccessVideo();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (!sharedPreferences.getBoolean(OnboardingFragment.COMPLETED_ONBOARDING, false)) {
            // This is the first time running the app, let's go to onboarding
            startActivity(new Intent(this, OnboardingActivity.class));
        }
    }

    // Identifier for the permission request
    private static final int VIDEO_PERMISSIONS_REQUEST = 1;

    // Called when the user is performing an action which requires the app to access video
    public void getPermissionToAccessVideo() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_VIDEO_DATA)
                != PackageManager.PERMISSION_GRANTED) {
            // Fire off an async request to actually get the permission
            // This will show the standard permission request dialog UI
            requestPermissions(new String[]{Manifest.permission.ACCESS_VIDEO_DATA},
                    VIDEO_PERMISSIONS_REQUEST);
        }
    }

    // Callback with the request from calling requestPermissions(...)
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        // Make sure it's our original ACCESS_VIDEO_DATA request
        if (requestCode == VIDEO_PERMISSIONS_REQUEST) {
            if (grantResults.length == 1 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Video access permission granted", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}


