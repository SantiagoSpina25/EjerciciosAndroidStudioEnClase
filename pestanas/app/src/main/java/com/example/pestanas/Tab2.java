package com.example.pestanas;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;


public class Tab2 extends Fragment {
    private WebView mVideo;


    public Tab2() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_tab2, container, false);
        mVideo=view.findViewById(R.id.videoView);
        mVideo.loadUrl("https://www.youtube.com/watch?v=UelDrZ1aFeY/");

        return view;
    }
}