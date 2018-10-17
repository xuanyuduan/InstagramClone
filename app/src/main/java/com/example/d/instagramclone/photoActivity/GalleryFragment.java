package com.example.d.instagramclone.photoActivity;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.d.instagramclone.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    //private static final String TAG = "GalleryFragment";

    private GridView gridView;
    private ImageView galleryImage;
    private ProgressBar progressBar;
    private Spinner directory;
    private ArrayList<String> directories;
    private String mAppend = "file:/";
    private static final int NUM_GRID_COLUMN = 3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container,false);
        galleryImage = (ImageView)view.findViewById(R.id.galleryImageView);
        gridView  = (GridView)view.findViewById(R.id.gridView);
        directory = (Spinner) view.findViewById(R.id.photoDirectory);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        directories = new ArrayList<>();


        /**
         * two functions on the gallery top bar
         * close the tap -- closeGallery
         * go to the next step -- nextStep
         */
        TextView closeGallery = (TextView) view.findViewById(R.id.galleryClose);
        closeGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        TextView nextStep = (TextView) view.findViewById(R.id.galleryNext);
        closeGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * goes to the upload section.
                 */

            }
        });

        init();
        return view;
    }

    private void init(){
        FilePaths filePaths = new FilePaths();

        //access folders
        if(FileSearch.getDirectoryPaths(filePaths.PICTURE) != null){
            directories = FileSearch.getDirectoryPaths(filePaths.PICTURE);
        }
        directories.add(filePaths.CAMERA);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, directories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        directory.setAdapter(adapter);

        directory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setupGridView(directories.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setupGridView(String selectedDirectory){
        final ArrayList<String> imgURLs = FileSearch.getFilePaths(selectedDirectory);
        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth/NUM_GRID_COLUMN;
        gridView.setColumnWidth(imageWidth);

        GridImageAdapter adapter = new GridImageAdapter(getActivity(), R.layout.grid_image, mAppend, imgURLs);
        gridView.setAdapter(adapter);

        setImage(imgURLs.get(0), galleryImage, mAppend);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setImage(imgURLs.get(position), galleryImage, mAppend);
            }
        });

    }

    private void setImage(String imgURL, ImageView image, String append){
        ImageLoader imageLoader = ImageLoader.getInstance();

        imageLoader.displayImage(mAppend + imgURL, image, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });


    }
}
