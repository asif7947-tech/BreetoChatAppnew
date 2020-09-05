package com.zamba.testchat.adapters;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zamba.testchat.R;
import com.zamba.testchat.fragments.AudioFragment;
import com.zamba.testchat.fragments.ImageFragment;
import com.zamba.testchat.fragments.VideoFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {


    String user_id;
    private Context mContext;
    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm, String user_id) {
        super(fm);
        mContext = context;
        this.user_id=user_id;
        // Required empty public constructor
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {

            ImageFragment.user_id=user_id;
            return new ImageFragment();
        }
        if (position==1)
        {
            VideoFragment.user_id=user_id;
            return new VideoFragment();
        }else
            {

                AudioFragment.user_id=user_id;
            return new AudioFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position)
        {
            case 0:
                return
                        mContext.getString(R.string.songsFragment);
            case 1:
                return
                        mContext.getString(R.string.albumFragment);
                case 2:
                return
                        mContext.getString(R.string.audioFragment);
                default:
                    return null;
        }
    }
}
