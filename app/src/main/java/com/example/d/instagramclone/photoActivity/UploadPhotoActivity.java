package com.example.d.instagramclone.photoActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;

import com.example.d.instagramclone.R;
<<<<<<< HEAD
import com.example.d.instagramclone.SectionPagerAdapter;
import com.example.d.instagramclone.SetBottomNavigation;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
=======
import com.example.d.instagramclone.function.SectionPagerAdapter;
import com.example.d.instagramclone.function.SetBottomNavigation;
>>>>>>> f3179a5b77bea0adba0bf97a99f6b45e721e9963

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

<<<<<<< HEAD
        // Create global configuration and initialize ImageLoader with this config
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
			.build();
        ImageLoader.getInstance().init(config);


        //check permissions
        if(checkPermissionArray(Permissions.PERMISSIONS)){
            setupBottomNavigationView();
        } else{
            verifyPermissions(Permissions.PERMISSIONS);
        }

    }

    /**
     * set up the viewPager for other fragments to use.
     */
    private void setupBottomNavigationView() {
//        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.mainBottomNav);
//        SetBottomNavigation setBottomNavigation = new SetBottomNavigation();
//        setBottomNavigation.setupBottomNavigationView(mContext, bottomNavigationView);
//        Menu menu = bottomNavigationView.getMenu();
//        menu.findItem(R.id.upload_photo).setChecked(true);

=======
//        setupBottomNavigationView();
>>>>>>> f3179a5b77bea0adba0bf97a99f6b45e721e9963
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
