package com.zamba.testchat.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.zamba.testchat.R;
import com.zamba.testchat.models.DocumentModel;

import java.util.ArrayList;

public class DocumnetsAdapter extends RecyclerView.Adapter<DocumnetsAdapter.MyViewHolder> {

    private ArrayList<DocumentModel> documentModelArrayList;

    Context context;

    public DocumnetsAdapter(Context context, ArrayList<DocumentModel> documentModelArrayList){

        this.context=context;
        this.documentModelArrayList=documentModelArrayList;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.documents_adapter__layout, null);
        return new MyViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, @SuppressLint("RecyclerView") final int i) {


        Log.e("DocumnetsAdapter : ", "data : " + documentModelArrayList.get(i).getDocs_url());


        myViewHolder.textView.setText(documentModelArrayList.get(i).getDocs_name());


        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                openWebPage(documentModelArrayList.get(i).getDocs_url());



            }
        });

    }

    @Override
    public int getItemCount() {
        return documentModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {



        TextView textView;


        CardView cardView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            textView = itemView.findViewById(R.id.file_name);
            cardView = itemView.findViewById(R.id.card_view);

        }
    }

    public void openWebPage(String url) {

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setData(Uri.parse(url));
        context.startActivity(i);
    }
}