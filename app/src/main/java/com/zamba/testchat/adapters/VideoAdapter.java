package com.zamba.testchat.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.universalvideoview.UniversalMediaController;
import com.universalvideoview.UniversalVideoView;
import com.zamba.testchat.R;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyViewHolder> {

    private ArrayList<String> images;

    Context context;

    public VideoAdapter(Context context, ArrayList<String> images){

        this.context=context;
        this.images=images;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_adapter_layout, null);
        return new MyViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, @SuppressLint("RecyclerView") final int i) {




        myViewHolder.videoPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myViewHolder.ll.setVisibility(View.GONE);

                Uri uri= Uri.parse(images.get(i));
                myViewHolder.mVideoView.setVideoURI(uri);
                myViewHolder.mVideoView.setMediaController(myViewHolder.mMediaController);
                myViewHolder.mVideoView.start();



            }
        });

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView durationOrSize;
        ImageView videoThumbnail;
        ImageView videoPlay;
        LinearLayout ll;
        ProgressBar progressBar;

        UniversalVideoView mVideoView;
        UniversalMediaController mMediaController;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            durationOrSize = itemView.findViewById(R.id.videoSize);
            videoThumbnail = itemView.findViewById(R.id.videoThumbnail);
            videoPlay = itemView.findViewById(R.id.videoPlay);
            ll = itemView.findViewById(R.id.container);
            progressBar = itemView.findViewById(R.id.progressBar);

            mVideoView = (UniversalVideoView) itemView.findViewById(R.id.videoView);
            mMediaController = (UniversalMediaController) itemView.findViewById(R.id.media_controller);
        }
    }
}