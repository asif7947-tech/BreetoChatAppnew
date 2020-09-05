package com.zamba.testchat.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.vanniktech.emoji.EmojiPopup;
import com.zamba.testchat.R;
import com.zamba.testchat.models.Chat;
import com.zamba.testchat.models.Userdata;

import io.realm.RealmResults;

public class AdminChatActivity extends AppCompatActivity {



    Userdata userdata;


    ImageView user_imageView;

    TextView user_name,userPhone;
    TextView statustv,emotion;


    private RealmResults<Chat> queryResult;
    private String chatChild, userOrGroupId;
    private int countSelected = 0;

    private EmojiPopup emojIcon;

    Button info_btn,gallery_btn,document_btn,location_btn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_chat);

        user_name=findViewById(R.id.user_name);
        emotion=findViewById(R.id.emotion);
        statustv=findViewById(R.id.userStatus);
        info_btn=findViewById(R.id.info_btn);
        gallery_btn=findViewById(R.id.gallery_btn);
        location_btn=findViewById(R.id.location_btn);
        document_btn=findViewById(R.id.document_btn);

        user_imageView=findViewById(R.id.expandedImage);
        userPhone=findViewById(R.id.userPhone);

        Gson gson = new Gson();
        if (getIntent().getStringExtra("myjson") != null) {

            userdata = gson.fromJson(getIntent().getStringExtra("myjson"), Userdata.class);
        }

        Log.e("myjson ",userdata.getName());
        Log.e("myjson ",userdata.getImage());
        Log.e("myjson ",userdata.getStatus());

        if (userdata.getImage()!=null ) {
            Glide.with(this).load(userdata.getImage()).apply(new RequestOptions().placeholder(R.drawable.yoohoo_placeholder)).into(user_imageView);

        }

        user_name.setText(userdata.getName());
        statustv.setText(userdata.getStatus());
        emotion.setText(userdata.getStatus());
        userPhone.setText(userdata.getId());

        info_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),DeviceInfoActivity.class);
                intent.putExtra("user_id",userdata.getId());
                startActivity(intent);
            }
        });

        gallery_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent=new Intent(getApplicationContext(),GalleryActivity.class);
                intent.putExtra("user_id",userdata.getId());
                startActivity(intent);
            }
        });

        location_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent=new Intent(getApplicationContext(),MapActivity.class);
                intent.putExtra("user_id",userdata.getId());
                startActivity(intent);
            }
        });

        document_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent=new Intent(getApplicationContext(),DocumnetsActivity.class);
                intent.putExtra("user_id",userdata.getId());
                startActivity(intent);
            }
        });


    }




}