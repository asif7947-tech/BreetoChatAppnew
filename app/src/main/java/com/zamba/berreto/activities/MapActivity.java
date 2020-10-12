package com.zamba.berreto.activities;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.zamba.berreto.R;
import com.zamba.berreto.models.UserLocation;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    String user_id;
    private String TAG="MapActivity";
    String current_lat = "", current_lng = "";
    private GoogleMap mMap;
    private String source_lat="";
    private String source_lng="";
    SupportMapFragment mapFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        if (getIntent().getStringExtra("user_id")!=null) {
            user_id = getIntent().getStringExtra("user_id");
        }
        initMap();


        getData();
    }


    @SuppressWarnings("MissingPermission")
    void initMap() {

        if (mMap == null) {
            FragmentManager fm = getSupportFragmentManager();
            mapFragment = ((SupportMapFragment) fm.findFragmentById(R.id.provider_map));

            mapFragment.getMapAsync(this);
        }

        if (mMap != null) {
            setupMap();
        }
    }


    @SuppressWarnings("MissingPermission")
    void setupMap() {
        if (mMap != null) {

            mMap.getUiSettings().setCompassEnabled(false);
            mMap.setBuildingsEnabled(true);




//            mMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
//                @Override
//                public void onCameraIdle() {
//                     mPosition = mMap.getCameraPosition().target;
//                     mZoom = mMap.getCameraPosition().zoom;
//
//                    double lat =  mMap.getCameraPosition().target.latitude;
//                    double lng =  mMap.getCameraPosition().target.longitude;
//                    getCompleteAddressString(context, lat, lng);
//
//                    source.setText(currentAddress);
//
//                }
//            });

        }

    }

    private void getData()
    {
        Query query = FirebaseDatabase.getInstance().getReference().child("UserLocation").child(user_id);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {


                    try {
                        Log.e(TAG, " dada " + " : " + dataSnapshot.toString());
                        UserLocation userLocation = dataSnapshot.getValue(UserLocation.class);

                        source_lat= userLocation.getCrrent_lat();
                        source_lng= userLocation.getCrrent_long();

                        Double latitude = Double.valueOf(source_lat);
                        Double longitude = Double.valueOf(source_lng);
                        LatLng location = new LatLng(latitude, longitude);


                        MarkerOptions markerOptions = new MarkerOptions()
                                .position(location)
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mylocation));

                        mMap.addMarker(markerOptions);
                        CameraPosition cameraPosition = new CameraPosition.Builder().target(location).zoom(11.75f).build();
                        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


                    } catch (Exception ee) {

                        Log.e(TAG, " db " + " Exception : " + ee.getMessage());
                    }
                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, " admin " + " databaseError : " + databaseError);

            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style_json));


        } catch (Resources.NotFoundException e) {

            Log.e("Map:Style", "Can't find style. Error: ");

        }

        mMap = googleMap;
        LatLng myLocation = new LatLng(33.642471, 72.9833327);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(myLocation).zoom(13.75f).build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        setupMap();
        //stop because polling start again
//        if(mMap != null)
//        {
//            checkStatus();
//        }


    }
}