package com.example.d.instagramclone;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuItem;

import java.sql.BatchUpdateException;

/*
* set bottom navigation bar
* */
public class SetBottomNavigation {

    private static final String TAG = "BottomNav";

    public static void setupBottomNavigationView (final Context context, BottomNavigationView bottomNavigationView)
    {
        /*
        * transfer activity
        * */
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.user_feed) {

                    Intent intentUseFeed = new Intent(context, HomeActivity.class);
                    context.startActivity(intentUseFeed);

                } else if (id == R.id.discover) {

                    Intent intentDiscover = new Intent(context, DiscoverActivity.class);
                    context.startActivity(intentDiscover);


                } else if (id == R.id.upload_photo) {

                    Intent intentUploadPhoto = new Intent(context, UploadPhotoActivity.class);
                    context.startActivity(intentUploadPhoto);

                } else if (id == R.id.activity_feed) {

                    Intent intentActivityFeed = new Intent(context, ActivityFeedActivity.class);
                    context.startActivity(intentActivityFeed);
                    menuItem.setChecked(true);

                } else if (id == R.id.profile) {

                    Intent intentProfile = new Intent(context, ProfileActivity.class);
                    context.startActivity(intentProfile);


                }
                return false;
            }
        });

    }



}
