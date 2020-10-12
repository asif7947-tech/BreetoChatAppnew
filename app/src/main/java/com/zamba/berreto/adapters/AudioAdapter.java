package com.zamba.berreto.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.zamba.berreto.R;
import com.zamba.berreto.models.AudioModel;

import java.util.ArrayList;

public class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.MyViewHolder> {

    private ArrayList<AudioModel> images;
    MediaPlayer player;
    Context context;

    public AudioAdapter(Context context, ArrayList<AudioModel> images){

        this.context=context;
        this.images=images;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_audio_adapter_layot, null);
        return new MyViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, @SuppressLint("RecyclerView") final int i) {


         player = new MediaPlayer();
        myViewHolder.durationOrSize.setText(images.get(i).getAudio_title());


        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    myViewHolder.ll.setVisibility(View.GONE);
                    myViewHolder.stop.setVisibility(View.VISIBLE);
                Uri uri = Uri.parse(images.get(i).getAudio_url());

                player.setAudioStreamType(AudioManager.STREAM_MUSIC);

                    player.setDataSource(context, uri);

                player.prepare();
                player.start();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        myViewHolder.stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myViewHolder.ll.setVisibility(View.VISIBLE);
                myViewHolder.stop.setVisibility(View.GONE);

                if (player.isPlaying()) {
                    player.pause();

                } else {
                    player.start();
                }
            }
        });








    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView durationOrSize;

        LinearLayout ll,stop;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            durationOrSize = itemView.findViewById(R.id.text);

            ll = itemView.findViewById(R.id.playPauseToggleContainer);
            stop = itemView.findViewById(R.id.PauseToggleContainer);
               }
    }
}