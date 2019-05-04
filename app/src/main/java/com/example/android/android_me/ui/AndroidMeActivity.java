/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    int headIndex, bodyIndex, legIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        if (savedInstanceState == null) {
            Intent intent=getIntent();
            headIndex=intent.getIntExtra("headIndex",1);
            bodyIndex=intent.getIntExtra("bodyIndex",1);
            legIndex=intent.getIntExtra("legIndex",1);
            MyCustomFragment headFragment = new MyCustomFragment();
            headFragment.setListImage(AndroidImageAssets.getHeads());
            headFragment.setIndexNumber(headIndex);
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().add(R.id.head_id, headFragment).commit();

            MyCustomFragment bodyFragment = new MyCustomFragment();
            bodyFragment.setListImage(AndroidImageAssets.getBodies());
            bodyFragment.setIndexNumber(bodyIndex);
            fragmentManager.beginTransaction().add(R.id.body_id, bodyFragment).commit();

            MyCustomFragment legFragment = new MyCustomFragment();
            legFragment.setListImage(AndroidImageAssets.getLegs());
            legFragment.setIndexNumber(legIndex);
            fragmentManager.beginTransaction().add(R.id.leg_id, legFragment).commit();
        }
    }
}