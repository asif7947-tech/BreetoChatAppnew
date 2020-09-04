package com.zamba.testchat.fragments;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.zamba.testchat.R;
import com.zamba.testchat.adapters.ChatAdapter;
import com.zamba.testchat.interfaces.HomeIneractor;
import com.zamba.testchat.models.Chat;
import com.zamba.testchat.models.User;
import com.zamba.testchat.models.UserLocation;
import com.zamba.testchat.utils.Helper;
import com.zamba.testchat.views.MyRecyclerView;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by a_man on 30-12-2017.
 */

public class MyUsersFragment extends Fragment {
    private MyRecyclerView recyclerView;
    private ChatAdapter chatAdapter;

    private Realm rChatDb;
    private User userMe;
    private RealmResults<Chat> resultList;
    private ArrayList<Chat> chatDataList = new ArrayList<>();

    // Flag for GPS status
    boolean isGPSEnabled = false;

    // Flag for network status
    boolean isNetworkEnabled = false;

    // Flag for GPS status
    boolean canGetLocation = false;

    Location location; // Location
    double latitude; // Latitude
    double longitude; // Longitude

    private String source_lat="";
    private String source_lng="";

    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 1000; // 10 meters

    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute


    private RealmChangeListener<RealmResults<Chat>> chatListChangeListener = new RealmChangeListener<RealmResults<Chat>>() {
        @Override
        public void onChange(@NonNull RealmResults<Chat> element) {
            if (chatDataList != null && chatAdapter != null) {
                chatDataList.clear();
                chatDataList.addAll(rChatDb.copyFromRealm(element));
                chatAdapter.notifyDataSetChanged();
            }
        }
    };
    private HomeIneractor homeInteractor;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            homeInteractor = (HomeIneractor) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement HomeIneractor");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helper helper = new Helper(getContext());
        userMe = helper.getLoggedInUser();
        Realm.init(getContext());
        rChatDb = Helper.getRealmInstance();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_recycler, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        statusCheck();
        recyclerView.setEmptyView(view.findViewById(R.id.emptyView));
        recyclerView.setEmptyImageView(((ImageView) view.findViewById(R.id.emptyImage)));
        recyclerView.setEmptyTextView(((TextView) view.findViewById(R.id.emptyText)));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RealmQuery<Chat> query = rChatDb.where(Chat.class).equalTo("myId", userMe.getId());//Query from chats whose owner is logged in user
        resultList = query.equalTo("group", false).sort("timeUpdated", Sort.DESCENDING).findAll();//ignore forward list of messages and get rest sorted according to time

        chatDataList.clear();
        chatDataList.addAll(rChatDb.copyFromRealm(resultList));
        chatAdapter = new ChatAdapter(getActivity(), chatDataList);
        recyclerView.setAdapter(chatAdapter);

        resultList.addChangeListener(chatListChangeListener);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        homeInteractor = null;
        if (resultList != null)
            resultList.removeChangeListener(chatListChangeListener);
    }

    //Display user's name as saved in phone!
    public void setUserNamesAsInPhone() {
        if (homeInteractor != null && chatDataList != null) {
            for (Chat chat : chatDataList) {
                String endTrim = Helper.getEndTrim(chat.getChatId());
                if (homeInteractor.getLocalContacts().containsKey(endTrim)) {
                    chat.setChatName(homeInteractor.getLocalContacts().get(endTrim).getName());
                }
            }
            if (chatAdapter != null)
                chatAdapter.notifyDataSetChanged();
        }
    }

    public void deleteSelectedChats() {
        rChatDb.beginTransaction();
        for (Chat chat : chatDataList) {
            if (chat.isSelected()) {
                Chat chatToDelete = rChatDb.where(Chat.class).equalTo("myId", userMe.getId()).equalTo("chatId", chat.getChatId()).findFirst();
                if (chatToDelete != null) {
                    RealmObject.deleteFromRealm(chatToDelete);
                }
            }
        }
        rChatDb.commitTransaction();
    }

    public void disableContextualMode() {
        chatAdapter.disableContextualMode();
    }


    private void getLocation()
    {

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            LocationManager locationManager = (LocationManager) getContext().getSystemService(getContext().LOCATION_SERVICE);
            // Getting GPS status
            isGPSEnabled = locationManager
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);

            // Getting network status
            isNetworkEnabled = locationManager
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!isGPSEnabled && !isNetworkEnabled) {
                // No network provider is enabled
            } else {
                this.canGetLocation = true;
                if (isNetworkEnabled) {
                    int requestPermissionsCode = 50;

                    locationManager.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, mLocationListener);
                    Log.d("Network", "Network");
                    if (locationManager != null) {
                        location = locationManager
                                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (location != null) {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                        }
                    }
                }
            }
            // If GPS enabled, get latitude/longitude using GPS Services
            if (isGPSEnabled) {
                if (location == null) {
                    if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 50);

                    } else {
                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES, mLocationListener);
                        Log.d("GPS Enabled", "GPS Enabled");
                        if (locationManager != null) {

                            location = locationManager
                                    .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location != null) {
                                latitude = location.getLatitude();
                                longitude = location.getLongitude();
                            }
                        }
                    }
                }

            }


            Log.e("mLocationListener ","  CAL   ");


        }
        else {

        }

    }
    private final LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(final Location location) {
            //your code here


            source_lat=""+location.getLatitude();
            source_lng=""+location.getLongitude();


            Log.e("mLocationListener ","  source_lat   "+source_lat);
            Log.e("mLocationListener ","  source_lng   "+source_lng);
            addUserLocation(source_lat,source_lng);
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };

    private void addUserLocation(String crrent_lat,String crrent_long)
    {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("UserLocation").child(userMe.getId());

        UserLocation userLocation=new UserLocation(crrent_lat,crrent_long);

        databaseReference.setValue(userLocation);


    }
    public void statusCheck() {
        LocationManager manager = (LocationManager) getContext().getSystemService(getContext().LOCATION_SERVICE);
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

            showDialogForGPSIntent();
            displayMessage("Please Turn On Your Mobile GPS");
        }
        else {


            getLocation();
        }


    }

    public void displayMessage(String toastString) {

        Snackbar.make(getActivity().findViewById(android.R.id.content), toastString, 3000).show();

        // Toast.makeText(context, ""+toastString, Toast.LENGTH_SHORT).show();

    }
    private void showDialogForGPSIntent() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
        builder.setTitle(getString(R.string.app_name))
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("GPS is disabled in your device. Enable it?")
                .setCancelable(false)
                .setPositiveButton("Enable GPS",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                Intent callGPSSettingIntent = new Intent(
                                        android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                startActivity(callGPSSettingIntent);
                            }
                        });
        builder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert1 = builder.create();

        alert1.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface arg) {
                alert1.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
                alert1.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
            }
        });
        alert1.show();
    }
}
