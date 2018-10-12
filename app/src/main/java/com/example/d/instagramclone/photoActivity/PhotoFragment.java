package com.example.d.instagramclone.photoActivity;


import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.d.instagramclone.R;

import static android.support.constraint.Constraints.TAG;

public class PhotoFragment extends Fragment {


    //constants
    private static final int PHOTO_FRAGMENT_NUM = 1;
    //private static final int GALLERY_FRAGMENT_NUM = 2;
    private static final int CAMERA_REQUEST_CODE = 100;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo, container,false);
        Log.d(TAG,"onCreateView started.");

        Button buttonOpenCamera = (Button)view.findViewById(R.id.buttonOpenCamera);
        buttonOpenCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: open camera started. ");

                if (((UploadPhotoActivity)getActivity()).getCurrentTabNumber() == PHOTO_FRAGMENT_NUM){
                    if (((UploadPhotoActivity)getActivity()).checkPermissions(Permissions.CAMERA_PERMISSION[0])){
                        Log.d(TAG, "onClick: starting camera. ");
                        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
                    }else{
                        /**
                         * if the app does not receive permission on using the camera and storage.
                         * return to a new try of upload photo page.
                         */
                        Intent intent = new Intent(getActivity(), UploadPhotoActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                }
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST_CODE){
            Log.d(TAG, "onActivityResult: finish taking a photo. ");
            Log.d(TAG, "onActivityResult: attempt to navigate to upload page. ");

            //navigate to upload
        }
    }
}
