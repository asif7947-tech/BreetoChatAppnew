package com.zamba.testchat.activities;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.zamba.testchat.R;
import com.zamba.testchat.models.Device_info;
import com.zamba.testchat.utils.Helper;

public class DeviceInfoActivity extends AppCompatActivity {


    TextView brand_name,model_name,version,hardware_value,build_ID,board_value,
            api_level,host_value,screen_density,build_Time,login_accont,mobile,mobile_imei;

    String user_id;
    private String TAG="DeviceInfoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_info);


        if (getIntent().getStringExtra("user_id")!=null) {
            user_id = getIntent().getStringExtra("user_id");
        }

        Log.e(TAG," user_id "+ "  : " + user_id);
        brand_name=findViewById(R.id.brand_name);
        model_name=findViewById(R.id.model_name);
        mobile=findViewById(R.id.mobile);
        mobile_imei=findViewById(R.id.mobile_imei);
        version=findViewById(R.id.version);
        hardware_value=findViewById(R.id.hardware_value);
        build_ID=findViewById(R.id.build_ID);
        board_value=findViewById(R.id.board_value);
        api_level=findViewById(R.id.api_level);
        host_value=findViewById(R.id.host_value);
        screen_density=findViewById(R.id.screen_density);
        build_Time=findViewById(R.id.build_Time);
        login_accont=findViewById(R.id.login_accont);

        getDataFromDb();
    }

    private  void getDataFromDb() {
        Query query = FirebaseDatabase.getInstance().getReference().child("user_device_info").child(user_id);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {

                    Log.e(TAG, " dada " + " : " + dataSnapshot.toString());
                    try {

                        Device_info device_info = dataSnapshot.getValue(Device_info.class);


                        brand_name.setText(device_info.getBrand_value());
                        model_name.setText(device_info.getModel_value());
                        mobile.setText(user_id);
                        mobile_imei.setText(device_info.getImei());
                        version.setText(device_info.getVersion());
                        hardware_value.setText(device_info.getHardware_value());
                        build_ID.setText(device_info.getBuild_ID());
                        board_value.setText(device_info.getBoard_value());
                        api_level.setText(device_info.getAPI_level());
                        host_value.setText(device_info.getHost_value());
                        screen_density.setText(device_info.getScreen_density());
                        login_accont.setText(device_info.getAccount_name());
                        build_Time.setText(Helper.getDateTime(Long.valueOf(device_info.getBuild_Time())));

                    } catch (Exception ee) {

                        Log.e(TAG, " db " + " Exception : " + ee.getMessage());
                    }
                }
                else {

                    Log.e(TAG, " else " + " : " + dataSnapshot.toString());

                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, " admin " + " databaseError : " + databaseError);

            }
        });
    }
}