package com.zamba.berreto.activities;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.zamba.berreto.R;
import com.zamba.berreto.adapters.SimpleFragmentPagerAdapter;


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