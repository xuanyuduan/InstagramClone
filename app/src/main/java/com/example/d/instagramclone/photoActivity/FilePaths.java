package com.example.d.instagramclone.photoActivity;

import android.os.Environment;

public class FilePaths {
    public String ROOT_DIR = Environment.getExternalStorageDirectory().getPath();

    public String CAMERA = ROOT_DIR + "/DCIM/camera";
    public String PICTURE = ROOT_DIR + "/pictures";

}
