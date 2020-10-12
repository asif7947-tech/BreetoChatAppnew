package com.zamba.berreto.fragments;

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
import com.zamba.berreto.R;
import com.zamba.berreto.adapters.AudioAdapter;
import com.zamba.berreto.models.AudioModel;
import com.zamba.berreto.utils.CustomDialog;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AudioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AudioFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String TAG = "AudioFragment";
    private ArrayList<AudioModel> audioModelArrayList=new ArrayList<>();
    public static String user_id = "";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

CustomDialog customDialog=null;
    Context context;
    RecyclerView recyclerView;


    AudioAdapter audioAdapter;


    public AudioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AudioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AudioFragment newInstance(String param1, String param2) {
        AudioFragment fragment = new AudioFragment();
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
        View rootView= inflater.inflate(R.layout.fragment_audio, container, false);

        Log.e(TAG,"user_id"+user_id);

        customDialog = new CustomDialog(getContext());
        customDialog.setCancelable(false);
        customDialog.show();
        context=getContext();

        recyclerView = rootView.findViewById(R.id.recyclerViewImage);
        Log.e(TAG,"user_id"+user_id);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getDataFromDb();

        return rootView;
    }


    private void getDataFromDb()
    {
        audioModelArrayList.clear();
        audioAdapter = new AudioAdapter(getContext(), audioModelArrayList);
        audioAdapter.notifyDataSetChanged();
        Query query = FirebaseDatabase.getInstance().getReference().child("UserUploadAudio").child(user_id);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {

                    Log.e(TAG, " dada " + " : " + dataSnapshot.toString());
                    try {

                        for(DataSnapshot ds : dataSnapshot.getChildren()) {

                            AudioModel audioModel = ds.getValue(AudioModel.class);


                            Log.e(TAG, " audio_url " + " : " + audioModel.getAudio_url());
                            audioModelArrayList.add(audioModel);
                            audioAdapter = new AudioAdapter(getContext(), audioModelArrayList);
                            recyclerView.setAdapter(audioAdapter);
                            audioAdapter.notifyDataSetChanged();

                        }
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