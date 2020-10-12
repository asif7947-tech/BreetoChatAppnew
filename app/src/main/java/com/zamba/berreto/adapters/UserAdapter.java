package com.zamba.berreto.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.zamba.berreto.R;
import com.zamba.berreto.activities.AdminChatActivity;
import com.zamba.berreto.models.Userdata;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<Userdata> dataList;

    private int selectedCount = 0;




    public UserAdapter(Context context, ArrayList<Userdata> dataList) {
        this.context = context;
        this.dataList = dataList;


    }

    public UserAdapter(Context context) {
        this.context = context;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.user_adapter_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        final Userdata chat=dataList.get(position);
        if (chat.getImage()!=null ) {
            Glide.with(context).load(chat.getImage()).apply(new RequestOptions().placeholder(R.drawable.yoohoo_placeholder)).into(holder.image);

        }

        holder.name.setText(chat.getName());
        holder.status.setText(chat.getStatus());


        holder.user_details_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("tag  ","CLICK  CALL");
                Gson gson = new Gson();
                String myJson = gson.toJson(chat);

                Intent intent=new Intent(context, AdminChatActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("myjson", myJson);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name,status;
        private ImageView image;
        private LinearLayout user_details_container;

        MyViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.user_name);
            status = itemView.findViewById(R.id.emotion);
            image = itemView.findViewById(R.id.user_image);

            user_details_container = itemView.findViewById(R.id.user_details_container);


        }

        private void setData() {



        }
    }




}
