package com.zamba.berreto.activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.zamba.berreto.R;
import com.zamba.berreto.utils.CustomDialog;
import com.zamba.berreto.utils.SharedHelper;

import java.util.Iterator;

public class RegisterActivity extends AppCompatActivity {

    CustomDialog customDialog=null;
    EditText user_name_et;

    String user_name;
    TextView submit_btn;
    private String TAG="RegisterActivity";
    private String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        if (getIntent().getStringExtra("user_id")!=null) {
            user_id = getIntent().getStringExtra("user_id");
        }

        Log.e(TAG, "user_id : " + user_id);
        user_name_et=findViewById(R.id.user_name);
        submit_btn=findViewById(R.id.submit);
        customDialog = new CustomDialog(this);
        customDialog.setCancelable(false);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user_name = user_name_et.getText().toString();

                if (TextUtils.isEmpty(user_name)) {

                    Toast.makeText(RegisterActivity.this, "Username field should not be empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    checkifnumberexists(user_name);
                }
            }
        });

    }

    private void checkifnumberexists(final String user_name){
        customDialog.show();
        if(!user_name.isEmpty()) {
            final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("users");
            mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();
                    // Toast.makeText(getContext(), "Total trades : " + dataSnapshot.getChildrenCount(), Toast.LENGTH_SHORT).show();
                    while (items.hasNext()) {
                        DataSnapshot item = items.next();

                        Log.e(TAG," data DB  "+item.getValue().toString());
                        String user_Name = String.valueOf(item.child("user_name").getValue());


                        Log.e(TAG," user_name of DB  "+user_Name);
                        Log.e(TAG," user_name   "+user_name);

                        if (user_Name.equals(user_name)) {

                            Log.e(TAG," user_name   "+" equals   ");
                            Toast.makeText(RegisterActivity.this, "user_Name  (" + user_name + " )is Already exists! Try Another ", Toast.LENGTH_LONG).show();
                            customDialog.dismiss();
                            return;
                        }
                        else if (!items.hasNext()) {

                            Log.e(TAG," user_name   "+" not  equals   ");
                            // progressDialog.setVisibility(View.VISIBLE);
                            Toast.makeText(RegisterActivity.this, "Regiter Successfully", Toast.LENGTH_LONG).show();


                            customDialog.dismiss();
                            SharedHelper.putKey(getApplicationContext(),"login_as","user");

                            mDatabase.child(user_id).child("user_name").setValue(user_name);

                            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            RegisterActivity.this.finish();

                            customDialog.dismiss();
                        }
                    }


                }


                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        else{
            customDialog.dismiss();
            Toast.makeText(this, "Enter Your Number", Toast.LENGTH_SHORT).show();
        }

    }
}