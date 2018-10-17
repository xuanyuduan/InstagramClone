package com.example.d.instagramclone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.d.instagramclone.function.SetBottomNavigation;

/*
* display discover
* */
public class DiscoverActivity extends AppCompatActivity {
    private static final String TAG = "DiscoverActivity";

    ImageView view_like, view_liked;

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_view_post);
        Log.d(TAG, "startActivity");
        view_like = (ImageView) findViewById(R.id.post_like);
        view_liked = (ImageView) findViewById(R.id.post_liked);

//        gestureDetector = new GestureDetector(DiscoverActivity.this, new GustureListener());


        likeToggle();
//        setupBottomNavigationView();

    }


    private void likeToggle () {

        view_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view_like.setVisibility(View.GONE);
                view_liked.setVisibility(View.VISIBLE);
            }
        });

        view_liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view_liked.setVisibility(View.GONE);
                view_like.setVisibility(View.VISIBLE);
            }
        });

    }


//    private void likeToggle () {
//
//        view_like.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return gestureDetector.onTouchEvent(event);
//            }
//        });
//
//        view_liked.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return gestureDetector.onTouchEvent(event);
//            }
//        });
//
//    }
//
//    public class GustureListener extends GestureDetector.SimpleOnGestureListener{
//
//        @Override
//        public boolean onDown(MotionEvent e) {
//            return super.onDown(e);
//        }
//
//        @Override
//        public boolean onDoubleTap(MotionEvent e) {
//            return super.onDoubleTap(e);
//        }
//    }

    private void setupBottomNavigationView()
    {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.mainBottomNav);
        SetBottomNavigation setBottomNavigation = new SetBottomNavigation();
        setBottomNavigation.setupBottomNavigationView(DiscoverActivity.this,bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        menu.findItem(R.id.discover).setChecked(true);
    }
}
