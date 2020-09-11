package com.zamba.testchat.fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.zamba.testchat.R;
import com.zamba.testchat.adapters.VideoAdapter;
import com.zamba.testchat.utils.CustomDialog;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String TAG = "VideoFragment";
    private ArrayList<String> images=new ArrayList<>();
    public static String user_id = "";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

CustomDialog customDialog=null;
    Context context;
    RecyclerView recyclerView;


    VideoAdapter videoAdapter;

    public VideoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VideoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VideoFragment newInstance(String param1, String param2) {
        VideoFragment fragment = new VideoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_video, container, false);

       Log.e(TAG,"user_id"+user_id);

        context=getContext();
        customDialog = new CustomDialog(getContext());
        customDialog.setCancelable(false);
        customDialog.show();

        recyclerView = view.findViewById(R.id.recyclerViewImage);
        Log.e(TAG,"user_id"+user_id);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getDataFromDb();
        return  view;
    }


    private void getDataFromDb()
    {
        images.clear();
        videoAdapter = new VideoAdapter(getContext(), images);
        videoAdapter.notifyDataSetChanged();
        Query query = FirebaseDatabase.getInstance().getReference().child("UserUploadVideos").child(user_id);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterator<DataSnapshot> snapshotIterator = dataSnapshot.getChildren().iterator();
                while ((snapshotIterator.hasNext())) {
                    try {
                        DataSnapshot data = snapshotIterator.next();
                        Log.e("user  ", "data_key : " + data);
                        String keyadmin = data.getKey();
                        Log.e("user  ", "keyadmin : " + keyadmin);
                        String image_path = data.child("video_url").getValue().toString();

                        Log.e(TAG, " image_path " + " : " + image_path);
                        images.add(image_path);
                        videoAdapter = new VideoAdapter(getContext(), images);
                        recyclerView.setAdapter(videoAdapter);
                        videoAdapter.notifyDataSetChanged();




                    } catch (Exception ee) {

                        if (customDialog!=null && customDialog.isShowing()) {
                            customDialog.dismiss();
                            customDialog=null;
                        }

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