package com.zamba.testchat.activities;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.zamba.testchat.R;
import com.zamba.testchat.adapters.DocumnetsAdapter;
import com.zamba.testchat.models.DocumentModel;
import com.zamba.testchat.utils.CustomDialog;

import java.util.ArrayList;

public class DocumnetsActivity extends AppCompatActivity {


    private String TAG = "DocumnetsActivity";
    private ArrayList<DocumentModel> images=new ArrayList<>();
    public String user_id = "";

CustomDialog customDialog=null;

    Context context;
    RecyclerView recyclerView;


    DocumnetsAdapter videoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documnets);

        if (getIntent().getStringExtra("user_id")!=null) {
            user_id = getIntent().getStringExtra("user_id");
        }
        customDialog = new CustomDialog(this);
        customDialog.setCancelable(false);

        customDialog.show();
        recyclerView = findViewById(R.id.recyclerViewImage);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Log.e(TAG, "user_id : " + user_id);
        getDataFromDb();
    }


    private void getDataFromDb()
    {

        Query query = FirebaseDatabase.getInstance().getReference().child("UserUploaDocs").child(user_id);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {

                    Log.e(TAG, " dada " + " : " + dataSnapshot.toString());
                    try {


                        for(DataSnapshot ds : dataSnapshot.getChildren()) {
                            DocumentModel documentModel = ds.getValue(DocumentModel.class);


                            Log.e(TAG, " audio_url " + " : " + documentModel.getDocs_url());


                            images.add(documentModel);
                            videoAdapter = new DocumnetsAdapter(getApplicationContext(), images);
                            recyclerView.setAdapter(videoAdapter);


                        }



                    } catch (Exception ee) {

                        Log.e(TAG, " db " + " Exception : " + ee.getMessage());
                    }

                    if (customDialog!=null && customDialog.isShowing()) {
                        customDialog.dismiss();
                        customDialog=null;
                    }
                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, " admin " + " databaseError : " + databaseError);
                if (customDialog!=null && customDialog.isShowing()) {
                    customDialog.dismiss();
                    customDialog=null;
                }
            }
        });
    }
}