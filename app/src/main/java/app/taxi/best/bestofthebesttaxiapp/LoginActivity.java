package app.taxi.best.bestofthebesttaxiapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import app.taxi.best.bestofthebesttaxiapp.fragments.SignUpFragment;
import app.taxi.best.bestofthebesttaxiapp.view.SlidingTabLayout;

/**
 * Created by eugene on 14.04.15.
 */
public class LoginActivity extends FragmentActivity {
    static final String LOG_TAG = "SlidingTabsBasicFragment";
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new LoginAdapter(getSupportFragmentManager()));
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setSelectedIndicatorColors(Color.BLACK);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    class LoginAdapter extends FragmentPagerAdapter{

        public LoginAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new SignUpFragment();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return position == 0? "Sign Up": "Sign In";
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
