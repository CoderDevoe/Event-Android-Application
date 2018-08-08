package com.example.devashish.tt20;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.afollestad.aesthetic.Aesthetic;
import com.example.devashish.tt20.Contact.Contacts;
import com.example.devashish.tt20.Events.EventFragment;
import com.example.devashish.tt20.FrontUI.featuredFragment;
import com.example.devashish.tt20.Guidelines.Guideline;
import com.example.devashish.tt20.Utility.CustomViewPager;
import com.example.devashish.tt20.Utility.FragmentLifecycle;
import com.example.devashish.tt20.Utility.MyPagerAdapter;


import java.util.ArrayList;
import java.util.List;

import devlight.io.library.ntb.NavigationTabBar;


public class MainActivity extends AppCompatActivity {
TextView text,text1;
    MyPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //INITIALIZE APPBAR
        Aesthetic.attach(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView) findViewById(R.id.textView);
        text.setTypeface(Typeface.createFromAsset(getAssets(),"ass.ttf"));
        //SETTING PARAMETERS TO APPBAR
        Aesthetic.get()
                .colorPrimaryRes(R.color.colorPrimary)
                .colorStatusBar(getResources().getColor(R.color.colorPrimaryDark))
                .colorAccentRes(R.color.colorAccent)
                .activityTheme(R.style.AppTheme_NoActionBar)
                .isDark(true)
                .textColorPrimary(Color.parseColor("#ffffff"))
                .textColorSecondary(Color.parseColor("#ffffff"))
                .apply();

        //INITIALIZE TABS UI
        initTABS();


    }

    //BOTTOM TABS AND VIEWPAGER
    public void initTABS() {
        final CustomViewPager viewPager = (CustomViewPager) findViewById(R.id.vp_horizontal_ntb);
        adapter = new MyPagerAdapter(getSupportFragmentManager());


        viewPager.setAdapter(adapter);
        viewPager.setPagingEnabled(false);
        viewPager.setOffscreenPageLimit(5);
        final String[] colors = getResources().getStringArray(R.array.red_wine);

        final NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(R.id.ntb_horizontal);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.eventicon),
                        Color.parseColor(colors[0]))
                        .title("events")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.acco),
                        Color.parseColor(colors[1]))
                        .title("guidelines")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.featured),
                        Color.parseColor(colors[2]))
                        .title("featured")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.tickets),
                        Color.parseColor(colors[3]))
                        .title("tickets")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.contact),
                        Color.parseColor(colors[4]))
                        .title("contact")
                        .build()
        );

        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(viewPager, 2);

        //IMPORTANT: ENABLE SCROLL BEHAVIOUR IN COORDINATOR LAYOUT
        navigationTabBar.setBehaviorEnabled(true);

        navigationTabBar.setOnTabBarSelectedIndexListener(new NavigationTabBar.OnTabBarSelectedIndexListener() {
            @Override
            public void onStartTabSelected(final NavigationTabBar.Model model, final int index) {
            }

            @Override
            public void onEndTabSelected(final NavigationTabBar.Model model, final int index) {

            }
        });
        navigationTabBar.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            int currentPosition = 0;
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                FragmentLifecycle fragmentToHide = (FragmentLifecycle)adapter.getItem(currentPosition);
                fragmentToHide.onPauseFragment();

                FragmentLifecycle fragmentToShow = (FragmentLifecycle)adapter.getItem(position);
                fragmentToShow.onResumeFragment();

                currentPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });
        String[] Titles={"events","guidelines","featured","tickets","contact"};
        navigationTabBar.setBgColor(Color.parseColor("#0e0e0e"));
           for(int i=0;i < navigationTabBar.getModels().size(); i++){
               NavigationTabBar.Model model = navigationTabBar.getModels().get(i);
               if(!model.isBadgeShowed()){
                   model.setBadgeTitle(Titles[i]);
                   model.showBadge();
               }
           }
           navigationTabBar.setIsTinted(false);

        navigationTabBar.setIsScaled(true);
        navigationTabBar.setTypeface(Typeface.createFromAsset(getAssets(),"ass.ttf"));
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();


        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(android.support.v4.app.Fragment fragment, String title) {
            mFragments.add(fragment);

        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }


    }


    @Override
    public void onBackPressed() {
       super.onBackPressed();
       finish();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Aesthetic.resume(this);
    }

    @Override
    protected void onPause() {
        Aesthetic.pause(this);
        super.onPause();
    }
}
