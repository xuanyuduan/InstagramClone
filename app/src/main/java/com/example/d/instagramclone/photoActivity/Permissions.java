package com.example.d.instagramclone.photoActivity;

import android.Manifest;

public class Permissions {

    public static final String[] PERMISSIONS = {
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA,
        Manifest.permission.READ_EXTERNAL_STORAGE
    };

    public static final String[] CAMERA_PERMISSION = {
            Manifest.permission.CAMERA
    };

    public static final String[] WRITE_EXTERNAL_PERMISSION = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public static final String[] READ_EXTERNAL_PERMISSION = {
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

}
