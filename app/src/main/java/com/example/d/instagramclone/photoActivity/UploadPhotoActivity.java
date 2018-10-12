package com.example.d.instagramclone.photoActivity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.webkit.WebBackForwardList;

import com.example.d.instagramclone.R;
import com.example.d.instagramclone.SectionPagerAdapter;
import com.example.d.instagramclone.SetBottomNavigation;

/*
* camera function
* */
public class UploadPhotoActivity extends AppCompatActivity {
    private static final String TAG = "UploadPhotoActivity";
    private static final int VERIFY_PERMISSIONS_REQUEST = 1;
    private Context mContext = UploadPhotoActivity.this;
    ViewPager mViewPager = (ViewPager) findViewById(R.id.mainBodyContainer);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_photo);
        Log.d(TAG, "startActivity");

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
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.mainBottomNav);
        SetBottomNavigation setBottomNavigation = new SetBottomNavigation();
        setBottomNavigation.setupBottomNavigationView(mContext, bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        menu.findItem(R.id.upload_photo).setChecked(true);

        SectionPagerAdapter sectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());
        sectionPagerAdapter.addFragment(new GalleryFragment());
        sectionPagerAdapter.addFragment(new PhotoFragment());

        //ViewPager mViewPager = (ViewPager) findViewById(R.id.mainBodyContainer);
        mViewPager.setAdapter(sectionPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.uploadPhotoBottom);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setText("GALLERY");
        tabLayout.getTabAt(1).setText("PHOTO");
    }

    /**
     * return the current tab number
     * 0 = Gallery Fragment
     * 1 = Photo Fragment
     */
    public int getCurrentTabNumber(){
        return mViewPager.getCurrentItem();
    }

    public void verifyPermissions(String[] permissions){
        Log.d(TAG, "verifyPermissions: verifying permissions.");

        ActivityCompat.requestPermissions(
                UploadPhotoActivity.this,
                permissions,
                VERIFY_PERMISSIONS_REQUEST
        );
    }

    /**
     * Check to see if an array of permissions has been verified.
     * @param permissions
     * @return
     */
    public boolean checkPermissionArray(String[] permissions){
        Log.d(TAG, "checkPermissionArray: checking permissions array");

        for(int i = 0; i< permissions.length; i++){
            String check = permissions[i];
            if(!checkPermissions(check)){
                return false;
            }
        }
        return true;
    }

    /**
     * Check to see if a single permission has been verified.
     * @param permission
     * @return
     */
    public boolean checkPermissions(String permission){
        Log.d(TAG, "checkPermissions: checking permission: " + permission);
        int permissionRequest = ActivityCompat.checkSelfPermission(UploadPhotoActivity.this, permission);

        if (permissionRequest != PackageManager.PERMISSION_GRANTED){
            Log.d(TAG, "checkPermissions: \n Permission was not granted for: " + permission);
            return false;
        }else{
            Log.d(TAG, "checkPermissions: \n Permission was granted for: " + permission);
            return true;
        }


    }


}
