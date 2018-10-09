package com.example.d.instagramclone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;

/*
* display profile
* */
public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Log.d(TAG, "startActivity");

//        setupBottomNavigationView();

    }

    private void setupBottomNavigationView()
    {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.mainBottomNav);
        SetBottomNavigation setBottomNavigation = new SetBottomNavigation();
        setBottomNavigation.setupBottomNavigationView(ProfileActivity.this,bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        menu.findItem(R.id.profile).setChecked(true);
    }
}
