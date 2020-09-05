package com.zamba.testchat.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.zamba.testchat.R;
import com.zamba.testchat.adapters.SimpleFragmentPagerAdapter;


public class GalleryActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    SimpleFragmentPagerAdapter adapter;

    String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);



        if (getIntent().getStringExtra("user_id")!=null) {
            user_id = getIntent().getStringExtra("user_id");
        }

        Bundle bundle = new Bundle();
        bundle.putString("user_id", user_id);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        //ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter = new SimpleFragmentPagerAdapter(this, getSupportFragmentManager(),user_id);
      /*  adapter.addFragment(new ImageFragment(), "IMAGES");
        adapter.addFragment(new VideoFragment(), "VIDEOS");*/

        viewPager.setAdapter(adapter);
    }
}