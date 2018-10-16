package com.example.d.instagramclone.function;

import android.animation.AnimatorSet;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

public class Like {


    public ImageView post_like, post_liked;

    public Like(ImageView post_like, ImageView post_liked) {
        this.post_like = post_like;
        this.post_liked = post_liked;
    }

    public void toggleLike () {

        AnimatorSet animationSet = new AnimatorSet();

        if(post_liked.getVisibility() == View.VISIBLE)
        {

        }

    }
}
