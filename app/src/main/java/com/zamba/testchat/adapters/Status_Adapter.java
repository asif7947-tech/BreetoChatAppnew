package com.zamba.testchat.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.universalvideoview.UniversalMediaController;
import com.universalvideoview.UniversalVideoView;
import com.zamba.testchat.R;
import com.zamba.testchat.utils.HelpperMethods;


import java.util.ArrayList;

public class Status_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    ArrayList<String> list; // ArrayList of your Data Model
    String path;
    final int VIEW_TYPE_ONE = 1;
    final int VIEW_TYPE_TWO = 2;
    private String Something="video";

    public Status_Adapter(Context context, ArrayList<String> list, String path) { // you can pass other parameters in constructor
        this.context = context;
        this.list = list;
        this.path = path;

    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {

        TextView durationOrSize;
        ImageView videoThumbnail;
        ImageView videoPlay;
        RelativeLayout ll;
        ProgressBar progressBar;

        UniversalVideoView mVideoView;
        UniversalMediaController mMediaController;
        ViewHolder1(final View itemView) {
            super(itemView);
            durationOrSize = itemView.findViewById(R.id.videoSize);
            videoThumbnail = itemView.findViewById(R.id.videoThumbnail);
            videoPlay = itemView.findViewById(R.id.videoPlay);
            ll = itemView.findViewById(R.id.container);
            progressBar = itemView.findViewById(R.id.progressBar);

            mVideoView = (UniversalVideoView) itemView.findViewById(R.id.videoView);
            mMediaController = (UniversalMediaController) itemView.findViewById(R.id.media_controller);
            // Initialize your All views prensent in list items
        }
        void bind(final int position) {
            // This method will be called anytime a list item is created or update its data
            //Do your stuff here
            videoPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                   ll.setVisibility(View.GONE);

                    Uri uri= Uri.parse(path+"/"+list.get(position));
                    mVideoView.setVideoURI(uri);
                    mVideoView.setMediaController(mMediaController);
                    mVideoView.start();



                }
            });
        }
    }

    private class ViewHolder2 extends RecyclerView.ViewHolder {
//        boolean isImageFitToScreen;

       ImageView imageView;
        ViewHolder2(final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_id); // Initialize your All views prensent in list items
        }
        void bind(int position) {
            // This method will be called anytime a list item is created or update its data
            //Do your stuff here
            Glide.with(context).load(path+"/"+list.get(position)).apply(new RequestOptions().override(600, 200).placeholder(R.drawable.emoji_google_1f3c3_1f3fb).fitCenter()).into(imageView);

//            imageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(isImageFitToScreen) {
//                        isImageFitToScreen=false;
//                        imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//                        itemView.setClipBounds(true);
//                    }else{
//                        isImageFitToScreen=true;
//                        imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
//                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//                    }
//                }
//            });


        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ONE) {
            return new ViewHolder1(LayoutInflater.from(context).inflate(R.layout.list_status_adapter_layot, parent, false));
        }
        //if its not VIEW_TYPE_ONE then its VIEW_TYPE_TWO
        return new ViewHolder2(LayoutInflater.from(context).inflate(R.layout.list_status_image_adapter_layout, parent, false));

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (HelpperMethods.isVideo(list.get(position))) { // put your condition, according to your requirements
            ((ViewHolder1) holder).bind(position);
        } else if (HelpperMethods.isImage(list.get(position))) {
            ((ViewHolder2) holder).bind(position);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        // here you can get decide from your model's ArrayList, which type of view you need to load. Like
        if (HelpperMethods.isVideo(list.get(position))) { // put your condition, according to your requirements
            return VIEW_TYPE_ONE;
        }
         else if (HelpperMethods.isImage(list.get(position))) {
            return VIEW_TYPE_TWO;
        }
         else return 3;

    }
}
