package com.zamba.testchat.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.zamba.testchat.adapters.StatusImageAdapter;
import com.zamba.testchat.utils.CustomDialog;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageFragment extends Fragment {

    int cont=0;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static String user_id = "";
    private ArrayList<String> images=new ArrayList<>();
    private String TAG = "ImageFragment";
    GridLayoutManager gridLayoutManager;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    CustomDialog customDialog=null;

    Context context;
    RecyclerView recyclerView;
    StatusImageAdapter statusImageAdapter;

    public ImageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ImageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ImageFragment newInstance(String param1, String param2) {
        ImageFragment fragment = new ImageFragment();
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
        View view= inflater.inflate(R.layout.fragment_image, container, false);

        context=getContext();
        customDialog = new CustomDialog(getContext());
        customDialog.setCancelable(false);
        customDialog.show();
        recyclerView = view.findViewById(R.id.recyclerViewImage);
        Log.e(TAG,"user_id"+user_id);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
         gridLayoutManager = new GridLayoutManager(getActivity(),2);

        getDataFromDb();


        // on item list clicked





        return  view;
    }

    private void getDataFromDb()
    {
        images.clear();
        statusImageAdapter = new StatusImageAdapter(getContext(), images);
        statusImageAdapter.notifyDataSetChanged();
        Query query = FirebaseDatabase.getInstance().getReference().child("UserUploaImages").child(user_id);
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
                            String image_path = data.child("ImgLink").getValue().toString();

                            Log.e(TAG, " image_path " + " : " + image_path);
                            images.add(image_path);
                             statusImageAdapter = new StatusImageAdapter(getContext(), images);
                            recyclerView.setAdapter(statusImageAdapter);
                            recyclerView.setLayoutManager(gridLayoutManager);
                        statusImageAdapter.notifyDataSetChanged();


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