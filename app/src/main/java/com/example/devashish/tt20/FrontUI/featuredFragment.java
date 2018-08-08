package com.example.devashish.tt20.FrontUI;


import android.graphics.Typeface;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.text.format.Time;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.devashish.tt20.R;

import com.example.devashish.tt20.Utility.FragmentLifecycle;
import com.jackandphantom.circularprogressbar.CircleProgressbar;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.events.OnBannerClickListener;
import ss.com.bannerslider.views.BannerSlider;




/**
 * A simple {@link Fragment} subclass.
 */
public class featuredFragment extends android.support.v4.app.Fragment implements FragmentLifecycle {
    private View view;
    BannerSlider bannerSlider;
    List<Banner> banners;
    Time conferenceTime = new Time(Time.getCurrentTimezone());
CountDownTimer timer;
    public featuredFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_featured, container, false);


         initFGUI();
         initCount();
         init_about_Spons();
        setRetainInstance(true);
        return view;
    }
    public void init_about_Spons(){
       final TextView desc=(TextView) view.findViewById(R.id.desc);



      final ImageView descread=(ImageView) view.findViewById(R.id.descread);
       descread.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               android.support.v4.app.DialogFragment frag = new AboutDialogFragment();
               frag.show(getFragmentManager(), "");
           }
       });
        TextView spons=(TextView) view.findViewById(R.id.spons);
        spons.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    }
    public void initCount(){
        final CircleProgressbar circleProgressbardays = (CircleProgressbar) view.findViewById(R.id.days);
        final CircleProgressbar circleProgressbarhours = (CircleProgressbar) view.findViewById(R.id.hours);
        final CircleProgressbar circleProgressbarmins = (CircleProgressbar) view.findViewById(R.id.mins);
        final CircleProgressbar circleProgressbarsecs = (CircleProgressbar) view.findViewById(R.id.secs);
        final TextView daystext=(TextView) view.findViewById(R.id.daystext);
        final TextView hourstext=(TextView) view.findViewById(R.id.hourstext);
        final TextView minstext=(TextView) view.findViewById(R.id.minstext);
        final TextView secstext=(TextView) view.findViewById(R.id.secstext);
        TextView dt=(TextView) view.findViewById(R.id.dt);
        TextView ht=(TextView) view.findViewById(R.id.ht);
        TextView mt=(TextView) view.findViewById(R.id.mt);
        TextView st=(TextView) view.findViewById(R.id.st);
        dt.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        ht.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        mt.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        st.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        daystext.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"bs.ttf"));
        hourstext.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"bs.ttf"));
        minstext.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"bs.ttf"));
        secstext.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"bs.ttf"));
        final int[] mDisplayDays = new int[1];
        final int[] mDisplayHours = new int[1];
        final int[] mDisplayMinutes = new int[1];
        final int[] mDisplaySeconds = new int[1];
        conferenceTime.set(0, 0, 9, 5, 0, 2018);
        conferenceTime.normalize(true);
        long confMillis = conferenceTime.toMillis(true);

        Time nowTime = new Time(Time.getCurrentTimezone());
        nowTime.setToNow();
        nowTime.normalize(true);
        long nowMillis = nowTime.toMillis(true);

        long milliDiff = confMillis - nowMillis;
       timer= new CountDownTimer(milliDiff, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                // decompose difference into days, hours, minutes and seconds
                mDisplayDays[0] = (int) ((millisUntilFinished / 1000) / 86400);
                mDisplayHours[0] = (int) (((millisUntilFinished / 1000) - (mDisplayDays[0] * 86400)) / 3600);
                mDisplayMinutes[0] = (int) (((millisUntilFinished / 1000) - ((mDisplayDays[0] * 86400) + (mDisplayHours[0] * 3600))) / 60);
                mDisplaySeconds[0] = (int) ((millisUntilFinished / 1000) % 60);

                daystext.setText(String.valueOf(mDisplayDays[0]));
                circleProgressbardays.setProgress(mDisplayDays[0]);

                hourstext.setText(String.valueOf(mDisplayHours[0]));
                circleProgressbarhours.setProgress(mDisplayHours[0]);

                minstext.setText(String.valueOf(mDisplayMinutes[0]));
                circleProgressbarmins.setProgress(mDisplayMinutes[0]);

                secstext.setText(String.valueOf(mDisplaySeconds[0]));
                circleProgressbarsecs.setProgress(mDisplaySeconds[0]);
            }

            @Override
            public void onFinish() {



            }
        }.start();

    }

    public void initFGUI(){
        bannerSlider = (BannerSlider) view.findViewById(R.id.banner_slider1);
        banners=new ArrayList<>();

            //add banner using resource drawable
            banners.add(new DrawableBanner(R.drawable.amitimg));
            banners.add(new DrawableBanner(R.drawable.lagoriimg));
            banners.add(new DrawableBanner(R.drawable.sunburnimg));



        bannerSlider.setBanners(banners);
        bannerSlider.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void onClick(int position) {

            }
        });
    }

    @Override
    public void onPauseFragment() {
        timer.cancel();
    }

    @Override
    public void onResumeFragment() {
       timer.start();
    }
}
