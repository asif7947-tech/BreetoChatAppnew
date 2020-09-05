package com.zamba.testchat.fragments;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
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
import android.widget.Toast;


import com.zamba.testchat.R;
import com.zamba.testchat.adapters.Status_Adapter;
import com.zamba.testchat.views.MyRecyclerView;

import java.io.File;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StatusFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatusFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private final int STORAGE_REQUEST_CODE = 212;
    private MyRecyclerView recyclerView;
    private Status_Adapter status_adapter;
    final ArrayList<String> arrayList = new ArrayList<>();
    private String TAG="StatusFragment";

    public StatusFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StatusFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StatusFragment newInstance(String param1, String param2) {
        StatusFragment fragment = new StatusFragment();
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

        Log.e(TAG,"  onCreate  "+ "CALL");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.e(TAG,"  onAttach  "+ "CALL");

    }

    @Override
    public void onResume() {
        super.onResume();

        Log.e(TAG,"  onResume  "+ "CALL");

        if (ContextCompat.checkSelfPermission(getContext(),  Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            getDataFromStorage();
        }
        else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE,
            },STORAGE_REQUEST_CODE);
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.e(TAG,"  onPause  "+ "CALL");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_status, container, false);

        Log.e(TAG,"  onCreateView  "+ "CALL");
        recyclerView = view.findViewById(R.id.recycler_view);

        recyclerView.setEmptyView(view.findViewById(R.id.emptyView));
        recyclerView.setEmptyImageView(((ImageView) view.findViewById(R.id.emptyImage)));
        recyclerView.setEmptyTextView(((TextView) view.findViewById(R.id.emptyText)));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        if (ContextCompat.checkSelfPermission(getContext(),  Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            getDataFromStorage();
        }
        else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                   },STORAGE_REQUEST_CODE);
        }

        return view;
    }

    private void getDataFromStorage() {

        arrayList.clear();
        status_adapter =new Status_Adapter(getContext(),arrayList,"hiddenpath.getAbsolutePath()");
status_adapter.notifyDataSetChanged();
        final File hiddenpath = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/WhatsApp/Media/.Statuses/");

        if (hiddenpath == null) {
            Toast.makeText(getContext(), "path is null of videos", Toast.LENGTH_SHORT).show();

        } else {
            Log.e("LOAD", "------------- " + hiddenpath.getAbsolutePath());
            String[] fileName = hiddenpath.list();



            for (String f : fileName) {
                Log.e("LOAD", " -------------  " + f);
//                if (HelpperMethods.isVideo(f)) {
//
//                    String path = hiddenpath.getAbsolutePath() +"/"+ f;
//
//
//                    Log.e("path", " -------------  " + path);
//
//
//
//                    arrayList.add(f);
//
//                    Log.e("size", " -------video------  " + arrayList.size());
//
//                }
//                else  if(HelpperMethods.isImage(f)){
//                    String path = hiddenpath.getAbsolutePath() +"/"+f;
//
//                    Log.e("path", " -------------  " + path);
//                    statusModel.setPath(path);
//                    statusModel.setType(1);
//                    arrayList.add(statusModel);
//
//                    Log.e("size", " -------image------  " + arrayList.size());
//                }
                arrayList.add(f);

            }


            Log.e("size", " -------total------  " + arrayList.size());
            status_adapter =new Status_Adapter(getContext(),arrayList,hiddenpath.getAbsolutePath());

            recyclerView.setAdapter(status_adapter);
            status_adapter.notifyDataSetChanged();


        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {

            case STORAGE_REQUEST_CODE:
                Log.e("WORK ","STORAGE_REQUEST_CODE "+ "WORK  ON Permission ");
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED

                ) {

                    Log.e("WORK ","STORAGE_REQUEST_CODE "+ "WORK  ON Permission ");
                    getDataFromStorage();
                }
//                docs_list = getAllDocmnetsPath();
//                uploadDocsToserver(docs_list);
                break;
        }
    }

}