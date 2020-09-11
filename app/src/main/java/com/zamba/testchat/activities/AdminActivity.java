package com.zamba.testchat.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.zamba.testchat.R;
import com.zamba.testchat.adapters.UserAdapter;
import com.zamba.testchat.models.Userdata;
import com.zamba.testchat.utils.CustomDialog;
import com.zamba.testchat.views.MyRecyclerView;

import java.util.ArrayList;
import java.util.Iterator;

public class AdminActivity extends AppCompatActivity {


    CustomDialog customDialog=null;

    private MyRecyclerView recyclerView;
    private UserAdapter chatAdapter;
    private static final int REQUEST_CODE_CHAT_FORWARD = 99;


    EditText et_search;

    ImageButton btn_search;

    boolean  call_search=false;

    private ArrayList<Userdata> chatDataList = new ArrayList<>();
    private String TAG="AdminActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        customDialog = new CustomDialog(this);
        customDialog.setCancelable(false);

        customDialog.show();

        recyclerView = findViewById(R.id.recycler_view);
        et_search = findViewById(R.id.et_search);
        btn_search = findViewById(R.id.btn_search);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));




        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String  data=et_search.getText().toString();
                chatDataList.clear();
                chatAdapter.notifyDataSetChanged();

                searchData(data);

            }
        });

        chatDb();


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {



        } else {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 22);
        }

        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                Log.e(TAG, "beforeTextChanged "+charSequence.toString() );

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                Log.e(TAG, "onTextChanged "+charSequence.toString() );

            }

            @Override
            public void afterTextChanged(Editable editable) {


                Log.e(TAG, "afterTextChanged "+editable.toString() );
                Log.e(TAG, "afterTextChanged "+editable.length() );
                if (editable.length()==0)
                {
                    Log.e(TAG, "afterTextChanged "+editable.toString() );
                    Log.e(TAG, "afterTextChanged "+editable.length() );
                    chatDb();
                }

            }
        });

    }
    private  void chatDb()
    {
        chatDataList.clear();
        chatAdapter = new UserAdapter(getApplicationContext(), chatDataList);
        chatAdapter.notifyDataSetChanged();
        call_search=false;
        Query query = FirebaseDatabase.getInstance().getReference().child("users");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> snapshotIterator = dataSnapshot.getChildren().iterator();
                while ((snapshotIterator.hasNext())) {


                    try
                    {

                        DataSnapshot data = snapshotIterator.next();
                        Log.e("user  ", "data_key : " + data);
                        String keyadmin = data.getKey();
                        Log.e("user  ", "data_key : " + data);

                        String id = String.valueOf(data.child("id").getValue());
                        String image = String.valueOf(data.child("image").getValue());
                        String name = String.valueOf(data.child("name").getValue());
                        String nameToDisplay = String.valueOf(data.child("nameToDisplay").getValue());
                        String status = String.valueOf(data.child("status").getValue());
                        String userRole = String.valueOf(data.child("user_name").getValue());



                        Userdata userdata = new Userdata();
                        userdata.setId(id);
                        userdata.setName(name);
                        userdata.setNameToDisplay(nameToDisplay);
                        userdata.setImage(image);
                        userdata.setStatus(status);
                        userdata.setUser_name(userRole);

                        chatDataList.add(userdata);
                        if (chatDataList.size() > 0) {
                            recyclerView.setVisibility(View.VISIBLE);

                            Log.e("user  ", "size : " + chatDataList.size());

                            chatAdapter = new UserAdapter(getApplicationContext(), chatDataList);
                            recyclerView.setAdapter(chatAdapter);
                            chatAdapter.notifyDataSetChanged();
                        } else {
                            recyclerView.setVisibility(View.GONE);

                        }


                    }catch (Exception  ee)

                    {
                        Log.e("user  ", "Exception : " + ee.getMessage());
                    }

                    if (customDialog!=null && customDialog.isShowing()) {
                        customDialog.dismiss();
                        customDialog=null;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("user  ", "databaseError : " + databaseError);
                if (customDialog!=null && customDialog.isShowing()) {
                    customDialog.dismiss();
                    customDialog=null;
                }
            }
        });
    }





    private void searchData(String user_name)
    {

        call_search=true;
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference().child("users");


        Query query = rootRef.orderByChild("user_name").equalTo(user_name);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Userdata upload = postSnapshot.getValue(Userdata.class);
                    chatDataList.add(upload);
                }
                chatAdapter = new UserAdapter(getApplicationContext(), chatDataList);

                recyclerView.setAdapter(chatAdapter);
                chatAdapter.notifyDataSetChanged();
                if (customDialog!=null && customDialog.isShowing()) {
                    customDialog.dismiss();
                    customDialog=null;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(AdminActivity.this, databaseError.getMessage(),Toast.LENGTH_SHORT).show();
                if (customDialog!=null && customDialog.isShowing()) {
                    customDialog.dismiss();
                    customDialog=null;
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 22:


                break;





        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Log.e(TAG, "onBackPressed "+"  call " );

        if (call_search==true)
        {
            chatDataList.clear();
            chatAdapter.notifyDataSetChanged();
            chatDb();
        }
        else {
            finish();
        }
    }
}