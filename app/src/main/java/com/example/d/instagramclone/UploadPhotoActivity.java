package com.example.d.instagramclone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;

/*
* camera function
* */
public class UploadPhotoActivity extends AppCompatActivity {
    private static final String TAG = "UploadPhotoActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_photo);
        Log.d(TAG, "startActivity");

//        setupBottomNavigationView();
        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        sectionPagerAdapter.addFragment(new GalleryFragment());
        sectionPagerAdapter.addFragment(new PhotoFragment());
        ViewPager viewPager = (ViewPager) findViewById(R.id.mainBodyContainer);
        viewPager.setAdapter(sectionPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.uploadPhotoBottom);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupBottomNavigationView()
    {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.mainBottomNav);
        SetBottomNavigation setBottomNavigation = new SetBottomNavigation();
        setBottomNavigation.setupBottomNavigationView(UploadPhotoActivity.this,bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        menu.findItem(R.id.upload_photo).setChecked(true);
    }
}
