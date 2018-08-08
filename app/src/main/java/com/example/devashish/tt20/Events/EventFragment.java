package com.example.devashish.tt20.Events;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;


import com.cunoraz.gifview.library.GifView;
import com.example.devashish.tt20.BuildConfig;
import com.example.devashish.tt20.MainActivity;
import com.example.devashish.tt20.R;
import com.example.devashish.tt20.Utility.FragmentLifecycle;
import com.example.devashish.tt20.Utility.OnSwipeTouchListener;
import com.fujiyuu75.sequent.Sequent;
import com.gigamole.navigationtabstrip.NavigationTabStrip;


import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.ViewPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.ViewPagerItems;
import com.yarolegovich.discretescrollview.DiscreteScrollView;

import org.w3c.dom.Text;

import java.util.List;

import in.championswimmer.sfg.lib.SimpleFingerGestures;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends android.support.v4.app.Fragment implements
        DiscreteScrollView.ScrollListener<EventsAdapter.ViewHolder>,
        DiscreteScrollView.OnItemChangedListener<EventsAdapter.ViewHolder>,FragmentLifecycle{


View view;
DiscreteScrollView event_view;
TextSwitcher title,date_feat;
GifView gifView1;
public static RelativeLayout nav;

    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_event, container, false);
        initRecycler();
        initTexts();
        initnav();
        initSunburn();
        initSingphonic();
        if(checkFirstRun()){
            nav.setVisibility(View.VISIBLE);
        }
        initMokshMantra();
        initSunburn();
        initFalsetto();
        initBurniton();
        initDestroix();
        initSports();
        initMattermind();
        initFocusia();
        initPerspective();
        initTechnova();
        initWinterRunway();
        initRangmanch();
        initnav_menu();
        new Load().execute("");
        setRetainInstance(true);
        return view;
    }

    @Override
    public void onPauseFragment() {
        gifView1.pause();
    }

    @Override
    public void onResumeFragment() {
        gifView1.play();
    }

    private class Load extends AsyncTask<String,Void,String> {
        @Override
        protected void onPreExecute() {

            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

        }

        @Override
        protected String doInBackground(String... strings) {
            initgif();

            return null;
        }
    }

    public boolean checkFirstRun() {

        final String PREFS_NAME = "MyPrefsFile";
        final String PREF_VERSION_CODE_KEY = "version_code";
        final int DOESNT_EXIST = -1;
        boolean what=false;
        // Get current version code
        int currentVersionCode = BuildConfig.VERSION_CODE;

        // Get saved version code
        SharedPreferences prefs = getActivity().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        int savedVersionCode = prefs.getInt(PREF_VERSION_CODE_KEY, DOESNT_EXIST);

        // Check for first run or upgrade
        if (currentVersionCode == savedVersionCode) {

            // This is just a normal run


        } else if (savedVersionCode == DOESNT_EXIST) {
            what=true;
            // TODO This is a new install (or the user cleared the shared preferences)

        } else if (currentVersionCode > savedVersionCode) {

            // TODO This is an upgrade
        }

        // Update the shared preferences with the current version code
        prefs.edit().putInt(PREF_VERSION_CODE_KEY, currentVersionCode).apply();
        return what;
    }
public void initgif(){
    gifView1 = (GifView) view.findViewById(R.id.gif_main);
    gifView1.setVisibility(View.VISIBLE);
    gifView1.play();
}

public void initnav_menu(){
    final RelativeLayout nav_menu=(RelativeLayout) view.findViewById(R.id.nav_menu);
    TextView nav_head_text=(TextView) view.findViewById(R.id.nav_head_text);
    RelativeLayout nav_close=(RelativeLayout) view.findViewById(R.id.nav_close);
    TextView nav_close_text=(TextView) view.findViewById(R.id.nav_close_text);
    Events events=Events.get();
    final List<Event_data> data=events.getData();
    nav_head_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    nav_close.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            nav_menu.setVisibility(View.GONE);
            nav.setVisibility(View.VISIBLE);
        }
    });
LinearLayout lagori=(LinearLayout) view.findViewById(R.id.lagori_nav);
TextView lagori_text=(TextView) view.findViewById(R.id.lagori_nav_text);
lagori_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
lagori.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        event_view.scrollToPosition(0);
        switchcases(0);
        title.setText(data.get(0).getEvent_name());
        date_feat.setVisibility(View.VISIBLE);
        date_feat.setText(Html.fromHtml(event_feat_date_data.dates[0]));
    }
});

    LinearLayout sunburn=(LinearLayout) view.findViewById(R.id.sunburn_nav);
    TextView sunburn_text=(TextView) view.findViewById(R.id.sunburn_nav_text);
    sunburn_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sunburn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            event_view.scrollToPosition(1);
            switchcases(1);
            title.setText(data.get(1).getEvent_name());
            date_feat.setVisibility(View.VISIBLE);
            date_feat.setText(Html.fromHtml(event_feat_date_data.dates[1]));
        }
    });

    LinearLayout amit=(LinearLayout) view.findViewById(R.id.amit_nav);
    TextView amit_text=(TextView) view.findViewById(R.id.amit_nav_text);
    amit_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    amit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            event_view.scrollToPosition(2);
            switchcases(2);
            title.setText(data.get(2).getEvent_name());
            date_feat.setVisibility(View.VISIBLE);
            date_feat.setText(Html.fromHtml(event_feat_date_data.dates[2]));
        }
    });

    LinearLayout moksh=(LinearLayout) view.findViewById(R.id.moksh_nav);
    TextView moksh_text=(TextView) view.findViewById(R.id.moksh_nav_text);
    moksh_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    moksh.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            event_view.scrollToPosition(3);
            switchcases(3);
            date_feat.setVisibility(View.GONE);

            title.setText(data.get(3).getEvent_name());
        }
    });

    LinearLayout singphonic=(LinearLayout) view.findViewById(R.id.singphonic_nav);
    TextView singphonic_text=(TextView) view.findViewById(R.id.singphonic_nav_text);
    singphonic_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    singphonic.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            event_view.scrollToPosition(4);
            switchcases(4);
            date_feat.setVisibility(View.GONE);

            title.setText(data.get(4).getEvent_name());
        }
    });

    LinearLayout falsetto=(LinearLayout) view.findViewById(R.id.falsetto_nav);
    TextView falsetto_text=(TextView) view.findViewById(R.id.falsetto_nav_text);
    falsetto_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    falsetto.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            event_view.scrollToPosition(5);
            switchcases(5);
            date_feat.setVisibility(View.GONE);

            title.setText(data.get(5).getEvent_name());
        }
    });

    LinearLayout burniton=(LinearLayout) view.findViewById(R.id.burniton_nav);
    TextView burniton_text=(TextView) view.findViewById(R.id.burniton_nav_text);
    burniton_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    burniton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            event_view.scrollToPosition(6);
            switchcases(6);
            date_feat.setVisibility(View.GONE);

            title.setText(data.get(6).getEvent_name());
        }
    });

    LinearLayout destroix=(LinearLayout) view.findViewById(R.id.destroix_nav);
    TextView destroix_text=(TextView) view.findViewById(R.id.destroix_nav_text);
    destroix_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            event_view.scrollToPosition(7);
            switchcases(7);
            date_feat.setVisibility(View.GONE);

            title.setText(data.get(7).getEvent_name());
        }
    });

    LinearLayout sports=(LinearLayout) view.findViewById(R.id.sports_nav);
    TextView sports_text=(TextView) view.findViewById(R.id.sports_nav_text);
    sports_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            event_view.scrollToPosition(8);
            switchcases(8);
            date_feat.setVisibility(View.GONE);

            title.setText(data.get(8).getEvent_name());
        }
    });

    LinearLayout mattermind=(LinearLayout) view.findViewById(R.id.mattermind_nav);
    TextView mattermind_text=(TextView) view.findViewById(R.id.mattermind_nav_text);
    mattermind_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            event_view.scrollToPosition(9);
            switchcases(9);
            date_feat.setVisibility(View.GONE);

            title.setText(data.get(9).getEvent_name());
        }
    });

    LinearLayout focusia=(LinearLayout) view.findViewById(R.id.focusia_nav);
    TextView focusia_text=(TextView) view.findViewById(R.id.focusia_nav_text);
    focusia_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    focusia.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            event_view.scrollToPosition(10);
            switchcases(10);
            date_feat.setVisibility(View.GONE);

            title.setText(data.get(10).getEvent_name());
        }
    });

    LinearLayout perspective=(LinearLayout) view.findViewById(R.id.perspective_nav);
    TextView perspective_text=(TextView) view.findViewById(R.id.perspective_nav_text);
    perspective_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            event_view.scrollToPosition(11);
            switchcases(11);
            date_feat.setVisibility(View.GONE);

            title.setText(data.get(11).getEvent_name());
        }
    });

    LinearLayout technova=(LinearLayout) view.findViewById(R.id.technova_nav);
    TextView technova_text=(TextView) view.findViewById(R.id.technova_nav_text);
    technova_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            event_view.scrollToPosition(12);
            switchcases(12);
            date_feat.setVisibility(View.GONE);

            title.setText(data.get(12).getEvent_name());
        }
    });

    LinearLayout winterrunway=(LinearLayout) view.findViewById(R.id.winterrunway_nav);
    TextView winterrunway_text=(TextView) view.findViewById(R.id.winterrunway_nav_text);
    winterrunway_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    winterrunway.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            event_view.scrollToPosition(13);
            switchcases(13);
            date_feat.setVisibility(View.GONE);

            title.setText(data.get(13).getEvent_name());
        }
    });

    LinearLayout rangmanch=(LinearLayout) view.findViewById(R.id.rangmanch_nav);
    TextView rangmanch_text=(TextView) view.findViewById(R.id.rangmanch_nav_text);
    rangmanch_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    rangmanch.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            event_view.scrollToPosition(14);
            date_feat.setVisibility(View.GONE);

            title.setText(data.get(14).getEvent_name());


        }
    });




}

public void initnav(){
    final RelativeLayout nav_menu=(RelativeLayout) view.findViewById(R.id.nav_menu);
    nav=(RelativeLayout) view.findViewById(R.id.nav);
    nav.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           nav_menu.setVisibility(View.VISIBLE);
            Sequent.origin(nav_menu).anim(getContext(), com.fujiyuu75.sequent.Animation.FADE_IN_LEFT).start();
            nav.setVisibility(View.GONE);
        }
    });
    final Animation in = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_left);
    final Animation out = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_left);
    final LinearLayout main=(LinearLayout) view.findViewById(R.id.event_main);
    main.setOnTouchListener(new OnSwipeTouchListener(getActivity()){
        public void onSwipeRight() {
            nav.setVisibility(View.VISIBLE);
        }
        public void onSwipeLeft() {
            nav.setVisibility(View.GONE);
        }
    });

}

public void switchcases(int eventCode){
    LinearLayout view_lagori=(LinearLayout) view.findViewById(R.id.view_lagori);
    LinearLayout view_sunburn=(LinearLayout) view.findViewById(R.id.view_sunburn);
    LinearLayout view_amit=(LinearLayout) view.findViewById(R.id.view_amit);
    LinearLayout view_moksh=(LinearLayout) view.findViewById(R.id.view_mokshmantra);
    LinearLayout view_singphonic=(LinearLayout) view.findViewById(R.id.view_singphonic);
    LinearLayout view_falsetto=(LinearLayout) view.findViewById(R.id.view_falsetto);
    LinearLayout view_burniton=(LinearLayout) view.findViewById(R.id.view_burniton);
    LinearLayout view_Destroix=(LinearLayout) view.findViewById(R.id.view_destroix);
    LinearLayout view_Sports=(LinearLayout) view.findViewById(R.id.view_sports);
    LinearLayout view_mattermind=(LinearLayout) view.findViewById(R.id.view_mattermind);
    LinearLayout view_focusia=(LinearLayout) view.findViewById(R.id.view_focusia);
    LinearLayout view_perspective=(LinearLayout) view.findViewById(R.id.view_perspective);
    LinearLayout view_technova=(LinearLayout) view.findViewById(R.id.view_technova);
    LinearLayout view_winter_runway=(LinearLayout) view.findViewById(R.id.view_winter_runway);
    LinearLayout view_rangmanch=(LinearLayout) view.findViewById(R.id.view_rangmanch);
    switch (eventCode){
        case 0:view_lagori.setVisibility(View.VISIBLE);
               view_amit.setVisibility(View.GONE);
            view_sunburn.setVisibility(View.GONE);
            view_moksh.setVisibility(View.GONE);
            view_singphonic.setVisibility(View.GONE);
            view_falsetto.setVisibility(View.GONE);
            view_burniton.setVisibility(View.GONE);
            view_Destroix.setVisibility(View.GONE);
            view_Sports.setVisibility(View.GONE);
            view_mattermind.setVisibility(View.GONE);
            view_focusia.setVisibility(View.GONE);
            view_perspective.setVisibility(View.GONE);
            view_technova.setVisibility(View.GONE);
            view_winter_runway.setVisibility(View.GONE);
            view_rangmanch.setVisibility(View.GONE);
               break;
        case 1:view_sunburn.setVisibility(View.VISIBLE);
            view_lagori.setVisibility(View.GONE);
            view_amit.setVisibility(View.GONE);
            view_moksh.setVisibility(View.GONE);
            view_singphonic.setVisibility(View.GONE);
            view_falsetto.setVisibility(View.GONE);
            view_burniton.setVisibility(View.GONE);
            view_Destroix.setVisibility(View.GONE);
            view_Sports.setVisibility(View.GONE);
            view_mattermind.setVisibility(View.GONE);
            view_focusia.setVisibility(View.GONE);
            view_perspective.setVisibility(View.GONE);
            view_technova.setVisibility(View.GONE);
            view_winter_runway.setVisibility(View.GONE);
            view_rangmanch.setVisibility(View.GONE);
               break;
        case 2:view_amit.setVisibility(View.VISIBLE);
            view_lagori.setVisibility(View.GONE);
            view_sunburn.setVisibility(View.GONE);
            view_moksh.setVisibility(View.GONE);
            view_singphonic.setVisibility(View.GONE);
            view_falsetto.setVisibility(View.GONE);
            view_burniton.setVisibility(View.GONE);
            view_Destroix.setVisibility(View.GONE);
            view_Sports.setVisibility(View.GONE);
            view_mattermind.setVisibility(View.GONE);
            view_focusia.setVisibility(View.GONE);
            view_perspective.setVisibility(View.GONE);
            view_technova.setVisibility(View.GONE);
            view_winter_runway.setVisibility(View.GONE);
            view_rangmanch.setVisibility(View.GONE);
            break;
        case 3:view_moksh.setVisibility(View.VISIBLE);
            view_lagori.setVisibility(View.GONE);
            view_sunburn.setVisibility(View.GONE);
            view_amit.setVisibility(View.GONE);
            view_singphonic.setVisibility(View.GONE);
            view_falsetto.setVisibility(View.GONE);
            view_burniton.setVisibility(View.GONE);
            view_Destroix.setVisibility(View.GONE);
            view_Sports.setVisibility(View.GONE);
            view_mattermind.setVisibility(View.GONE);
            view_focusia.setVisibility(View.GONE);
            view_perspective.setVisibility(View.GONE);
            view_technova.setVisibility(View.GONE);
            view_winter_runway.setVisibility(View.GONE);
            view_rangmanch.setVisibility(View.GONE);
               break;
        case 4:view_singphonic.setVisibility(View.VISIBLE);
            view_lagori.setVisibility(View.GONE);
            view_sunburn.setVisibility(View.GONE);
            view_amit.setVisibility(View.GONE);
            view_moksh.setVisibility(View.GONE);
            view_falsetto.setVisibility(View.GONE);
            view_burniton.setVisibility(View.GONE);
            view_Destroix.setVisibility(View.GONE);
            view_Sports.setVisibility(View.GONE);
            view_mattermind.setVisibility(View.GONE);
            view_focusia.setVisibility(View.GONE);
            view_perspective.setVisibility(View.GONE);
            view_technova.setVisibility(View.GONE);
            view_winter_runway.setVisibility(View.GONE);
            view_rangmanch.setVisibility(View.GONE);
             break;
        case 5:view_falsetto.setVisibility(View.VISIBLE);
            view_singphonic.setVisibility(View.GONE);
            view_lagori.setVisibility(View.GONE);
            view_sunburn.setVisibility(View.GONE);
            view_amit.setVisibility(View.GONE);
            view_moksh.setVisibility(View.GONE);
            view_burniton.setVisibility(View.GONE);
            view_Destroix.setVisibility(View.GONE);
            view_Sports.setVisibility(View.GONE);
            view_mattermind.setVisibility(View.GONE);
            view_focusia.setVisibility(View.GONE);
            view_perspective.setVisibility(View.GONE);
            view_technova.setVisibility(View.GONE);
            view_winter_runway.setVisibility(View.GONE);
            view_rangmanch.setVisibility(View.GONE);
               break;
        case 6:view_burniton.setVisibility(View.VISIBLE);
            view_singphonic.setVisibility(View.GONE);
            view_lagori.setVisibility(View.GONE);
            view_sunburn.setVisibility(View.GONE);
            view_amit.setVisibility(View.GONE);
            view_moksh.setVisibility(View.GONE);
            view_falsetto.setVisibility(View.GONE);
            view_Destroix.setVisibility(View.GONE);
            view_Sports.setVisibility(View.GONE);
            view_mattermind.setVisibility(View.GONE);
            view_focusia.setVisibility(View.GONE);
            view_perspective.setVisibility(View.GONE);
            view_technova.setVisibility(View.GONE);
            view_winter_runway.setVisibility(View.GONE);
            view_rangmanch.setVisibility(View.GONE);
               break;
        case 7:view_Destroix.setVisibility(View.VISIBLE);
            view_singphonic.setVisibility(View.GONE);
            view_lagori.setVisibility(View.GONE);
            view_sunburn.setVisibility(View.GONE);
            view_amit.setVisibility(View.GONE);
            view_moksh.setVisibility(View.GONE);
            view_falsetto.setVisibility(View.GONE);
            view_burniton.setVisibility(View.GONE);
            view_Sports.setVisibility(View.GONE);
            view_mattermind.setVisibility(View.GONE);
            view_focusia.setVisibility(View.GONE);
            view_perspective.setVisibility(View.GONE);
            view_technova.setVisibility(View.GONE);
            view_winter_runway.setVisibility(View.GONE);
            view_rangmanch.setVisibility(View.GONE);
               break;
        case 8:view_Sports.setVisibility(View.VISIBLE);
            view_singphonic.setVisibility(View.GONE);
            view_lagori.setVisibility(View.GONE);
            view_sunburn.setVisibility(View.GONE);
            view_amit.setVisibility(View.GONE);
            view_moksh.setVisibility(View.GONE);
            view_falsetto.setVisibility(View.GONE);
            view_burniton.setVisibility(View.GONE);
            view_Destroix.setVisibility(View.GONE);
            view_mattermind.setVisibility(View.GONE);
            view_focusia.setVisibility(View.GONE);
            view_perspective.setVisibility(View.GONE);
            view_technova.setVisibility(View.GONE);
            view_winter_runway.setVisibility(View.GONE);
            view_rangmanch.setVisibility(View.GONE);
             break;
        case 9:view_mattermind.setVisibility(View.VISIBLE);
            view_singphonic.setVisibility(View.GONE);
            view_lagori.setVisibility(View.GONE);
            view_sunburn.setVisibility(View.GONE);
            view_amit.setVisibility(View.GONE);
            view_moksh.setVisibility(View.GONE);
            view_falsetto.setVisibility(View.GONE);
            view_burniton.setVisibility(View.GONE);
            view_Destroix.setVisibility(View.GONE);
            view_Sports.setVisibility(View.GONE);
            view_focusia.setVisibility(View.GONE);
            view_perspective.setVisibility(View.GONE);
            view_technova.setVisibility(View.GONE);
            view_winter_runway.setVisibility(View.GONE);
            view_rangmanch.setVisibility(View.GONE);
            break;
        case 10:view_focusia.setVisibility(View.VISIBLE);
            view_singphonic.setVisibility(View.GONE);
            view_lagori.setVisibility(View.GONE);
            view_sunburn.setVisibility(View.GONE);
            view_amit.setVisibility(View.GONE);
            view_moksh.setVisibility(View.GONE);
            view_falsetto.setVisibility(View.GONE);
            view_burniton.setVisibility(View.GONE);
            view_Destroix.setVisibility(View.GONE);
            view_Sports.setVisibility(View.GONE);
            view_mattermind.setVisibility(View.GONE);
            view_perspective.setVisibility(View.GONE);
            view_technova.setVisibility(View.GONE);
            view_winter_runway.setVisibility(View.GONE);
            view_rangmanch.setVisibility(View.GONE);
            break;
        case 11: view_perspective.setVisibility(View.VISIBLE);
            view_singphonic.setVisibility(View.GONE);
            view_lagori.setVisibility(View.GONE);
            view_sunburn.setVisibility(View.GONE);
            view_amit.setVisibility(View.GONE);
            view_moksh.setVisibility(View.GONE);
            view_falsetto.setVisibility(View.GONE);
            view_burniton.setVisibility(View.GONE);
            view_Destroix.setVisibility(View.GONE);
            view_Sports.setVisibility(View.GONE);
            view_mattermind.setVisibility(View.GONE);
            view_focusia.setVisibility(View.GONE);
            view_technova.setVisibility(View.GONE);
            view_winter_runway.setVisibility(View.GONE);
            view_rangmanch.setVisibility(View.GONE);
            break;
        case 12:view_technova.setVisibility(View.VISIBLE);
            view_singphonic.setVisibility(View.GONE);
            view_lagori.setVisibility(View.GONE);
            view_sunburn.setVisibility(View.GONE);
            view_amit.setVisibility(View.GONE);
            view_moksh.setVisibility(View.GONE);
            view_falsetto.setVisibility(View.GONE);
            view_burniton.setVisibility(View.GONE);
            view_Destroix.setVisibility(View.GONE);
            view_Sports.setVisibility(View.GONE);
            view_mattermind.setVisibility(View.GONE);
            view_focusia.setVisibility(View.GONE);
            view_perspective.setVisibility(View.GONE);
            view_winter_runway.setVisibility(View.GONE);
            view_rangmanch.setVisibility(View.GONE);
            break;
        case 13:view_winter_runway.setVisibility(View.VISIBLE);
            view_singphonic.setVisibility(View.GONE);
            view_lagori.setVisibility(View.GONE);
            view_sunburn.setVisibility(View.GONE);
            view_amit.setVisibility(View.GONE);
            view_moksh.setVisibility(View.GONE);
            view_falsetto.setVisibility(View.GONE);
            view_burniton.setVisibility(View.GONE);
            view_Destroix.setVisibility(View.GONE);
            view_Sports.setVisibility(View.GONE);
            view_mattermind.setVisibility(View.GONE);
            view_focusia.setVisibility(View.GONE);
            view_perspective.setVisibility(View.GONE);
            view_technova.setVisibility(View.GONE);
            view_rangmanch.setVisibility(View.GONE);
            break;
        case 14:view_rangmanch.setVisibility(View.VISIBLE);
            view_singphonic.setVisibility(View.GONE);
            view_lagori.setVisibility(View.GONE);
            view_sunburn.setVisibility(View.GONE);
            view_amit.setVisibility(View.GONE);
            view_moksh.setVisibility(View.GONE);
            view_falsetto.setVisibility(View.GONE);
            view_burniton.setVisibility(View.GONE);
            view_Destroix.setVisibility(View.GONE);
            view_Sports.setVisibility(View.GONE);
            view_mattermind.setVisibility(View.GONE);
            view_focusia.setVisibility(View.GONE);
            view_perspective.setVisibility(View.GONE);
            view_technova.setVisibility(View.GONE);
            view_winter_runway.setVisibility(View.GONE);
    }
}

public void initSunburn(){
    TextView txt=(TextView) view.findViewById(R.id.sunburn_text);
    txt.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));


}
public void initMokshMantra(){
    TextView moksh_dates_title=(TextView) view.findViewById(R.id.moksh_dates);
    moksh_dates_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    TextView moksh_date1=(TextView) view.findViewById(R.id.date1);
    RelativeLayout moksh_register=(RelativeLayout) view.findViewById(R.id.moksh_register);
    moksh_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://www.talenttantra.com/registration.php/mokshmantra";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    moksh_date1.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    moksh_date1.setText(Html.fromHtml("4<sup>th</sup> january 2018<br/>5<sup>th</sup> january 2018"));
    TextView moksh_format=(TextView) view.findViewById(R.id.moksh_format);
    moksh_format.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    TextView moksh_rules=(TextView) view.findViewById(R.id.moksh_rules);
    moksh_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    TextView moksh_reg_title=(TextView) view.findViewById(R.id.moksh_reg_title);
    moksh_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    TextView moksh_reg=(TextView) view.findViewById(R.id.moksh_reg);
    moksh_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    TextView moksh_coordinators=(TextView) view.findViewById(R.id.moksh_coordinators);
    moksh_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    TextView moksh_coordinators_text=(TextView) view.findViewById(R.id.moksh_coordinators_text);
    moksh_coordinators_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));

}
    public void initSingphonic(){
        TextView singphonic_dates_title=(TextView) view.findViewById(R.id.singphonic_dates);
        singphonic_dates_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
        TextView singphonic_date1=(TextView) view.findViewById(R.id.sing_date1);
        RelativeLayout singphonic_register=(RelativeLayout) view.findViewById(R.id.singphonic_register);
        singphonic_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="http://www.talenttantra.com/registration.php/singphonic";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        singphonic_date1.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        singphonic_date1.setText(Html.fromHtml("5<sup>th</sup> january 2018 prelims<br/>6<sup>th</sup> january 2018 final competition"));
        TextView singphonic_rules1=(TextView) view.findViewById(R.id.sing_rules1);
        singphonic_rules1.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        TextView singphonic_rules2=(TextView) view.findViewById(R.id.sing_rules2);
        singphonic_rules2.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        singphonic_rules1.setText(Html.fromHtml("1<sup>st</sup> round"));
        singphonic_rules2.setText(Html.fromHtml("2<sup>nd</sup> round"));

        TextView singphonic_rules=(TextView) view.findViewById(R.id.singphonic_rules);
        singphonic_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        TextView singphonic_reg_title=(TextView) view.findViewById(R.id.singphonic_reg_title);
        singphonic_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        TextView singphonic_reg=(TextView) view.findViewById(R.id.singphonic_reg);
        singphonic_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        TextView singphonic_coordinators=(TextView) view.findViewById(R.id.singphonic_coordinators);
        singphonic_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        TextView singphonic_coordinators_text=(TextView) view.findViewById(R.id.singphonic_coordinators_text);
        singphonic_coordinators_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        TextView singphonic_spons=(TextView) view.findViewById(R.id.singphonic_spons);
        singphonic_spons.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        TextView singphonic_types=(TextView) view.findViewById(R.id.singphonic_types);
        TextView singphonic_limit=(TextView) view.findViewById(R.id.singphonic_limit);
        singphonic_limit.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        singphonic_types.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));

    }
    public void initFalsetto(){
        TextView falsetto_dates_title=(TextView) view.findViewById(R.id.falsetto_dates);
        falsetto_dates_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
        TextView falsetto_date=(TextView) view.findViewById(R.id.falsetto_date);
        RelativeLayout falsetto_register_solo=(RelativeLayout) view.findViewById(R.id.falsetto_register_solo);
        falsetto_register_solo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="http://www.talenttantra.com/registration.php/f-solo";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        RelativeLayout falsetto_register_group=(RelativeLayout) view.findViewById(R.id.falsetto_register_group);
        falsetto_register_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="http://www.talenttantra.com/registration.php/f-group";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        falsetto_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        falsetto_date.setText(Html.fromHtml("<br/>7<sup>th</sup> january 2018"));

        TextView falsetto_rules=(TextView) view.findViewById(R.id.falsetto_rules);
        falsetto_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        TextView falsetto_reg_title=(TextView) view.findViewById(R.id.falsetto_reg_title);
        falsetto_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        TextView falsetto_reg_solo=(TextView) view.findViewById(R.id.falsetto_reg_solo);
        falsetto_reg_solo.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        TextView falsetto_reg_group=(TextView) view.findViewById(R.id.falsetto_reg_group);
        falsetto_reg_group.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        TextView falsetto_coordinators=(TextView) view.findViewById(R.id.falsetto_coordinators);
        falsetto_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        TextView falsetto_coordinators_text=(TextView) view.findViewById(R.id.falsetto_coordinators_text);
        falsetto_coordinators_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        TextView falsetto_reg_fee_solo_text=(TextView) view.findViewById(R.id.solo_text);
        TextView falsetto_reg_fee_group_text=(TextView) view.findViewById(R.id.group_text);
        falsetto_reg_fee_solo_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        falsetto_reg_fee_group_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));

    }

    void initBurniton(){
        final NavigationTabStrip view_burniton_modern_tabs=(NavigationTabStrip) view.findViewById(R.id.tabs_burniton_modern);
        final LinearLayout view_burniton=(LinearLayout) view.findViewById(R.id.view_burniton);
        final LinearLayout view_burniton_classical=(LinearLayout) view.findViewById(R.id.view_burniton_classical);
        final LinearLayout view_burniton_modern=(LinearLayout) view.findViewById(R.id.view_burniton_modern);
        final LinearLayout view_burniton_adaptune=(LinearLayout) view.findViewById(R.id.view_burniton_adaptune);
        final NavigationTabStrip navigationTabStrip = (NavigationTabStrip) view.findViewById(R.id.tabs_burniton);
        navigationTabStrip.setTabIndex(0,true);
        navigationTabStrip.setOnTabStripSelectedIndexListener(new NavigationTabStrip.OnTabStripSelectedIndexListener() {
            @Override
            public void onStartTabSelected(String title, int index) {
                if(index==0){

                    //classical
                   view_burniton_classical.setVisibility(View.VISIBLE);
                   view_burniton_modern.setVisibility(View.GONE);
                   view_burniton_adaptune.setVisibility(View.GONE);
                }else if(index==1){
                    //modern
                    view_burniton_modern_tabs.setTabIndex(0,true);
                    view_burniton_modern.setVisibility(View.VISIBLE);
                    view_burniton_classical.setVisibility(View.GONE);
                    view_burniton_adaptune.setVisibility(View.GONE);
                }else if(index==2){
                    //adaptune
                    view_burniton_adaptune.setVisibility(View.VISIBLE);
                    view_burniton_classical.setVisibility(View.GONE);
                    view_burniton_modern.setVisibility(View.GONE);
                }
            }

            @Override
            public void onEndTabSelected(String title, int index) {

            }
        });
        //Classical
        TextView view_burniton_classical_datetitle=(TextView) view.findViewById(R.id.view_burniton_classical_dates);
        TextView view_burniton_classical_date=(TextView) view.findViewById(R.id.view_burniton_classical_date);
        view_burniton_classical_datetitle.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
        view_burniton_classical_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        view_burniton_classical_date.setText(Html.fromHtml("<br/>5<sup>th</sup> january 2018 final competition"));
        TextView view_burniton_classical_rules=(TextView) view.findViewById(R.id.view_burniton_classical_rules);
        view_burniton_classical_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        TextView view_burniton_classical_reg_title=(TextView) view.findViewById(R.id.view_burniton_classical_reg_title);
        TextView view_burniton_classical_reg=(TextView) view.findViewById(R.id.view_burniton_classical_reg);
        view_burniton_classical_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        view_burniton_classical_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        TextView view_burniton_classical_coordinators=(TextView) view.findViewById(R.id.view_burniton_classical_coordinators);
        TextView view_burniton_classical_coordinators_text=(TextView) view.findViewById(R.id.view_burniton_classical_coordinator_text);
        view_burniton_classical_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        view_burniton_classical_coordinators_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        RelativeLayout view_burniton_classical_register=(RelativeLayout) view.findViewById(R.id.view_burniton_classical_register);
        view_burniton_classical_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="http://www.talenttantra.com/registration.php/classicaldance";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        //modern
        final LinearLayout view_burniton_modern_solo_rules=(LinearLayout) view.findViewById(R.id.view_burniton_modern_rules_solo);
        final LinearLayout view_burniton_modern_group_rules=(LinearLayout) view.findViewById(R.id.view_burniton_modern_rules_group);
        final LinearLayout view_burniton_modern_solo_reg=(LinearLayout) view.findViewById(R.id.burniton_modern_solo_reg);
        final LinearLayout view_burniton_modern_group_reg=(LinearLayout) view.findViewById(R.id.burniton_modern_group_reg);
        final TextView view_burniton_modern_solo_desc=(TextView) view.findViewById(R.id.burniton_modern_solo_desc);
        final TextView view_burniton_modern_group_desc=(TextView) view.findViewById(R.id.burniton_modern_group_desc);

        view_burniton_modern_tabs.setOnTabStripSelectedIndexListener(new NavigationTabStrip.OnTabStripSelectedIndexListener() {
            @Override
            public void onStartTabSelected(String title, int index) {
                  if(index==0){
                      //solo
                      view_burniton_modern_solo_rules.setVisibility(View.VISIBLE);
                      view_burniton_modern_solo_reg.setVisibility(View.VISIBLE);
                      view_burniton_modern_group_rules.setVisibility(View.GONE);
                      view_burniton_modern_group_reg.setVisibility(View.GONE);
                      view_burniton_modern_solo_desc.setVisibility(View.VISIBLE);
                      view_burniton_modern_group_desc.setVisibility(View.GONE);
                  }else if(index==1){
                      //group
                      view_burniton_modern_solo_rules.setVisibility(View.GONE);
                      view_burniton_modern_solo_reg.setVisibility(View.GONE);
                      view_burniton_modern_group_rules.setVisibility(View.VISIBLE);
                      view_burniton_modern_group_reg.setVisibility(View.VISIBLE);
                      view_burniton_modern_solo_desc.setVisibility(View.GONE);
                      view_burniton_modern_group_desc.setVisibility(View.VISIBLE);
                  }

            }

            @Override
            public void onEndTabSelected(String title, int index) {

            }
        });
        TextView view_burniton_modern_coordinators=(TextView) view.findViewById(R.id.view_burniton_modern_coordinators);
        TextView view_burniton_modern_coordinators_text=(TextView) view.findViewById(R.id.view_burniton_modern_coordinator_text);
        view_burniton_modern_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        view_burniton_modern_coordinators_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));

        TextView view_burniton_modern_dates=(TextView) view.findViewById(R.id.view_burniton_modern_dates);
        view_burniton_modern_dates.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
        TextView view_burniton_modern_date=(TextView) view.findViewById(R.id.view_burniton_modern_date);
        view_burniton_modern_date.setText(Html.fromHtml("<br/>5<sup>th</sup> january 2018 final competition"));
        view_burniton_modern_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        TextView view_burniton_modern_rules_solo=(TextView) view.findViewById(R.id.view_burniton_modern_rules_solo_title);
        TextView view_burniton_modern_rules_group=(TextView) view.findViewById(R.id.view_burniton_modern_rules_group_title);
         view_burniton_modern_rules_solo.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        view_burniton_modern_rules_group.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
         TextView view_burniton_modern_solo_reg_title=(TextView) view.findViewById(R.id.view_burniton_modern_solo_reg_title);
         TextView view_burniton_modern_solo_rs=(TextView) view.findViewById(R.id.view_burniton_modern_solo_reg);
        TextView view_burniton_modern_group_reg_title=(TextView) view.findViewById(R.id.view_burniton_modern_group_reg_title);
        TextView view_burniton_modern_group_rs=(TextView) view.findViewById(R.id.view_burniton_modern_group_reg);
        RelativeLayout view_burniton_modern_solo_register=(RelativeLayout) view.findViewById(R.id.view_burniton_modern_solo_register);
        RelativeLayout view_burniton_modern_group_register=(RelativeLayout) view.findViewById(R.id.view_burniton_modern_group_register);
        view_burniton_modern_solo_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        view_burniton_modern_group_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        view_burniton_modern_solo_rs.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        view_burniton_modern_group_rs.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        view_burniton_modern_solo_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="http://www.talenttantra.com/registration.php/mdsolo";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        view_burniton_modern_group_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="http://www.talenttantra.com/registration.php/mdgroup";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        //adaptune
        TextView view_burniton_adaptune_coordinators=(TextView) view.findViewById(R.id.view_burniton_adaptune_coordinators);
        TextView view_burniton_adaptune_coordinators_text=(TextView) view.findViewById(R.id.view_burniton_adaptune_coordinator_text);
        view_burniton_adaptune_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        view_burniton_adaptune_coordinators_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));

        TextView view_burniton_adaptune_dates=(TextView) view.findViewById(R.id.view_burniton_adaptune_dates);
        view_burniton_adaptune_dates.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
        TextView view_burniton_adaptune_date=(TextView) view.findViewById(R.id.view_burniton_adaptune_date);
        view_burniton_adaptune_date.setText(Html.fromHtml("<br/>5<sup>th</sup> january 2018 final competition"));
        view_burniton_adaptune_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));

        TextView view_burniton_adaptune_all=(TextView) view.findViewById(R.id.view_burniton_adaptune_all);
        TextView view_burniton_adaptune_breaking=(TextView) view.findViewById(R.id.view_burniton_adaptune_breaking);
        TextView view_burniton_adaptune_rules=(TextView) view.findViewById(R.id.view_burniton_adaptune_rules);
        TextView view_burniton_adaptune_reg_title=(TextView) view.findViewById(R.id.view_burniton_adaptune_reg_title);
        RelativeLayout view_burniton_adaptune_register=(RelativeLayout) view.findViewById(R.id.view_burniton_adaptune_register);
        TextView view_burniton_adaptune_reg=(TextView) view.findViewById(R.id.view_burniton_adaptune_reg);

        view_burniton_adaptune_all.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        view_burniton_adaptune_breaking.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        view_burniton_adaptune_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        view_burniton_adaptune_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        view_burniton_adaptune_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));

        view_burniton_adaptune_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="http://www.talenttantra.com/registration.php/adaptune";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }

public void initDestroix(){
        LinearLayout view_Destroix=(LinearLayout) view.findViewById(R.id.view_destroix);
        final LinearLayout destroix_dota=(LinearLayout) view.findViewById(R.id.destroix_dota);
    final LinearLayout destroix_cod=(LinearLayout) view.findViewById(R.id.destroix_cod);
    final LinearLayout destroix_fifa=(LinearLayout) view.findViewById(R.id.destroix_fifa);
    final LinearLayout destroix_cr=(LinearLayout) view.findViewById(R.id.destroix_cr);
    final LinearLayout destroix_mm=(LinearLayout) view.findViewById(R.id.destroix_mm);
    final LinearLayout destroix_nfs=(LinearLayout) view.findViewById(R.id.destroix_nfs);
    final SmartTabLayout view_destroix_tabs=(SmartTabLayout) view.findViewById(R.id.viewpagertab_destroix);

    ViewPager viewPager=(ViewPager) view.findViewById(R.id.viewpager_destroix);
    ViewPagerItemAdapter adapter = new ViewPagerItemAdapter(ViewPagerItems.with(getActivity())
            .add("dota 2", R.layout.destroix_dota)
            .add("nfs mw", R.layout.destroix_nfs)
            .add("fifa 15",R.layout.destroix_fifa)
            .add("call of duty 4",R.layout.destroix_cod)
            .add("clash royale",R.layout.destroix_cr)
            .add("mini militia",R.layout.destroix_mm)
            .create());

    view_destroix_tabs.setOnTabClickListener(new SmartTabLayout.OnTabClickListener() {

        public void onTabClicked(int position) {
            switch(position){
                case 0:view_destroix_tabs.animate();
                    destroix_dota.setVisibility(View.VISIBLE);
                    destroix_cod.setVisibility(View.GONE);
                    destroix_cr.setVisibility(View.GONE);
                    destroix_fifa.setVisibility(View.GONE);
                    destroix_nfs.setVisibility(View.GONE);
                    destroix_mm.setVisibility(View.GONE);
                    break;
                case 1:view_destroix_tabs.animate();
                    destroix_nfs.setVisibility(View.VISIBLE);
                    destroix_cod.setVisibility(View.GONE);
                    destroix_cr.setVisibility(View.GONE);
                    destroix_fifa.setVisibility(View.GONE);
                    destroix_dota.setVisibility(View.GONE);
                    destroix_mm.setVisibility(View.GONE);
                    break;
                case 2:view_destroix_tabs.animate();
                    destroix_fifa.setVisibility(View.VISIBLE);
                    destroix_cod.setVisibility(View.GONE);
                    destroix_cr.setVisibility(View.GONE);
                    destroix_nfs.setVisibility(View.GONE);
                    destroix_dota.setVisibility(View.GONE);
                    destroix_mm.setVisibility(View.GONE);
                    break;
                case 3:view_destroix_tabs.animate();
                    destroix_cod.setVisibility(View.VISIBLE);
                    destroix_fifa.setVisibility(View.GONE);
                    destroix_cr.setVisibility(View.GONE);
                    destroix_nfs.setVisibility(View.GONE);
                    destroix_dota.setVisibility(View.GONE);
                    destroix_mm.setVisibility(View.GONE);
                    break;
                case 4:view_destroix_tabs.animate();
                    destroix_cr.setVisibility(View.VISIBLE);
                    destroix_fifa.setVisibility(View.GONE);
                    destroix_cod.setVisibility(View.GONE);
                    destroix_nfs.setVisibility(View.GONE);
                    destroix_dota.setVisibility(View.GONE);
                    destroix_mm.setVisibility(View.GONE);
                    break;
                case 5:view_destroix_tabs.animate();
                    destroix_mm.setVisibility(View.VISIBLE);
                    destroix_fifa.setVisibility(View.GONE);
                    destroix_cod.setVisibility(View.GONE);
                    destroix_nfs.setVisibility(View.GONE);
                    destroix_dota.setVisibility(View.GONE);
                    destroix_cr.setVisibility(View.GONE);
                    break;
            }
        }
    });
    viewPager.setAdapter(adapter);
    view_destroix_tabs.setViewPager(viewPager);



    //DOTA 2

    TextView destroix_dota_rules=(TextView) view.findViewById(R.id.view_destroix_dota_rules);
    TextView destroix_dota_date_title=(TextView) view.findViewById(R.id.view_destroix_dota_dates);
    TextView destroix_dota_date=(TextView) view.findViewById(R.id.view_destroix_dota_date);
    destroix_dota_date.setText(Html.fromHtml("5<sup>th</sup> january 2018<br/>6<sup>th</sup> january 2018"));
    TextView destroix_dota_reg_title=(TextView) view.findViewById(R.id.view_destroix_dota_reg_title);
    TextView destroix_dota_reg=(TextView) view.findViewById(R.id.view_destroix_dota_reg);
    RelativeLayout destroix_dota_register=(RelativeLayout) view.findViewById(R.id.view_destroix_dota_register);
    TextView destroix_dota_coordinators_title=(TextView) view.findViewById(R.id.view_destroix_dota_coordinators);
    TextView destroix_dota_coordinators=(TextView) view.findViewById(R.id.view_destroix_dota_coordinator_text);
    destroix_dota_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_dota_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_dota_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    destroix_dota_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_dota_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_dota_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_dota_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_dota_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://www.talenttantra.com/registration.php/dota2";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    TextView destroix_dota_spons=(TextView) view.findViewById(R.id.destroix_dota_spons);
    destroix_dota_spons.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    //DOTA 2 ends

    //COD MW4 Starts

    TextView destroix_cod_mode=(TextView) view.findViewById(R.id.view_destroix_cod_mode);
    TextView destroix_cod_mode_text=(TextView) view.findViewById(R.id.view_destroix_cod_mode_text);
    TextView destroix_cod_rules=(TextView) view.findViewById(R.id.view_destroix_cod_rules);
    TextView destroix_cod_date_title=(TextView) view.findViewById(R.id.view_destroix_cod_dates);
    TextView destroix_cod_date=(TextView) view.findViewById(R.id.view_destroix_cod_date);
    destroix_cod_date.setText(Html.fromHtml("5<sup>th</sup> january 2018<br/>6<sup>th</sup> january 2018"));
    TextView destroix_cod_reg_title=(TextView) view.findViewById(R.id.view_destroix_cod_reg_title);
    TextView destroix_cod_reg=(TextView) view.findViewById(R.id.view_destroix_cod_reg);
    RelativeLayout destroix_cod_register=(RelativeLayout) view.findViewById(R.id.view_destroix_cod_register);
    TextView destroix_cod_coordinators_title=(TextView) view.findViewById(R.id.view_destroix_cod_coordinators);
    TextView destroix_cod_coordinators=(TextView) view.findViewById(R.id.view_destroix_cod_coordinator_text);
    destroix_cod_mode.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_cod_mode_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_cod_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_cod_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_cod_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    destroix_cod_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_cod_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_cod_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_cod_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_cod_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://www.talenttantra.com/registration.php/cod4";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    TextView destroix_cod_spons=(TextView) view.findViewById(R.id.destroix_cod_spons);
    destroix_cod_spons.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    //COD MW4 Ends

    //NFS MW Starts

    TextView destroix_nfs_rules=(TextView) view.findViewById(R.id.view_destroix_nfs_rules);
    TextView destroix_nfs_date_title=(TextView) view.findViewById(R.id.view_destroix_nfs_dates);
    TextView destroix_nfs_date=(TextView) view.findViewById(R.id.view_destroix_nfs_date);
    destroix_nfs_date.setText(Html.fromHtml("5<sup>th</sup> january 2018<br/>6<sup>th</sup> january 2018"));
    TextView destroix_nfs_reg_title=(TextView) view.findViewById(R.id.view_destroix_nfs_reg_title);
    TextView destroix_nfs_reg=(TextView) view.findViewById(R.id.view_destroix_nfs_reg);
    RelativeLayout destroix_nfs_register=(RelativeLayout) view.findViewById(R.id.view_destroix_nfs_register);
    TextView destroix_nfs_coordinators_title=(TextView) view.findViewById(R.id.view_destroix_nfs_coordinators);
    TextView destroix_nfs_coordinators=(TextView) view.findViewById(R.id.view_destroix_nfs_coordinator_text);
    destroix_nfs_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_nfs_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    destroix_nfs_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_nfs_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_nfs_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_nfs_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_nfs_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_nfs_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://www.talenttantra.com/registration.php/nfsmsw";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    TextView destroix_nfs_spons=(TextView) view.findViewById(R.id.destroix_nfs_spons);
    destroix_nfs_spons.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    //NFS MW Ends

   //FIFA 15 Starts

    TextView destroix_fifa_rules=(TextView) view.findViewById(R.id.view_destroix_fifa_rules);
    TextView destroix_fifa_date_title=(TextView) view.findViewById(R.id.view_destroix_fifa_dates);
    TextView destroix_fifa_date=(TextView) view.findViewById(R.id.view_destroix_fifa_date);
    destroix_fifa_date.setText(Html.fromHtml("5<sup>th</sup> january 2018<br/>6<sup>th</sup> january 2018"));
    TextView destroix_fifa_reg_title=(TextView) view.findViewById(R.id.view_destroix_fifa_reg_title);
    TextView destroix_fifa_reg=(TextView) view.findViewById(R.id.view_destroix_fifa_reg);
    RelativeLayout destroix_fifa_register=(RelativeLayout) view.findViewById(R.id.view_destroix_fifa_register);
    TextView destroix_fifa_coordinators_title=(TextView) view.findViewById(R.id.view_destroix_fifa_coordinators);
    TextView destroix_fifa_coordinators=(TextView) view.findViewById(R.id.view_destroix_fifa_coordinator_text);
    destroix_fifa_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_fifa_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    destroix_fifa_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_fifa_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_fifa_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_fifa_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_fifa_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_fifa_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://www.talenttantra.com/registration.php/fifa15";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    TextView destroix_fifa_spons=(TextView) view.findViewById(R.id.destroix_fifa_spons);
    destroix_fifa_spons.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));

    //FIFA 15 Ends

    //CLASH ROYALE Starts

    TextView destroix_cr_rules=(TextView) view.findViewById(R.id.view_destroix_cr_rules);
    TextView destroix_cr_date_title=(TextView) view.findViewById(R.id.view_destroix_cr_dates);
    TextView destroix_cr_date=(TextView) view.findViewById(R.id.view_destroix_cr_date);
    destroix_cr_date.setText(Html.fromHtml("5<sup>th</sup> january 2018<br/>6<sup>th</sup> january 2018"));
    TextView destroix_cr_reg_title=(TextView) view.findViewById(R.id.view_destroix_cr_reg_title);
    TextView destroix_cr_reg=(TextView) view.findViewById(R.id.view_destroix_cr_reg);
    RelativeLayout destroix_cr_register=(RelativeLayout) view.findViewById(R.id.view_destroix_cr_register);
    TextView destroix_cr_coordinators_title=(TextView) view.findViewById(R.id.view_destroix_cr_coordinators);
    TextView destroix_cr_coordinators=(TextView) view.findViewById(R.id.view_destroix_cr_coordinator_text);
    TextView destroix_cr_mode=(TextView) view.findViewById(R.id.view_destroix_cr_mode);
    TextView destroix_cr_mode_text=(TextView) view.findViewById(R.id.view_destroix_cr_mode_text);
    destroix_cr_mode.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_cr_mode_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_cr_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_cr_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    destroix_cr_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_cr_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_cr_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_cr_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_cr_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_cr_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Do nothing
        }
    });
    TextView destroix_cr_spons=(TextView) view.findViewById(R.id.destroix_cr_spons);
    destroix_cr_spons.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
   //CLASH ROYALE Ends

    //MINI MILITIA Starts
    TextView destroix_mm_rules=(TextView) view.findViewById(R.id.view_destroix_mm_rules);
    TextView destroix_mm_date_title=(TextView) view.findViewById(R.id.view_destroix_mm_dates);
    TextView destroix_mm_date=(TextView) view.findViewById(R.id.view_destroix_mm_date);
    destroix_mm_date.setText(Html.fromHtml("5<sup>th</sup> january 2018<br/>6<sup>th</sup> january 2018"));
    TextView destroix_mm_reg_title=(TextView) view.findViewById(R.id.view_destroix_mm_reg_title);
    TextView destroix_mm_reg_single=(TextView) view.findViewById(R.id.destroix_mm_reg_single);
    TextView destroix_mm_reg_team=(TextView) view.findViewById(R.id.destroix_mm_reg_team);
    TextView destroix_mm_reg_single_text=(TextView) view.findViewById(R.id.single_text);
    TextView destroix_mm_reg_team_text=(TextView) view.findViewById(R.id.team_text);

    TextView destroix_mm_coordinators_title=(TextView) view.findViewById(R.id.view_destroix_mm_coordinators);
    TextView destroix_mm_coordinators=(TextView) view.findViewById(R.id.view_destroix_mm_coordinator_text);
    TextView destroix_mm_mode=(TextView) view.findViewById(R.id.view_destroix_mm_mode);
    TextView destroix_mm_mode_text=(TextView) view.findViewById(R.id.view_destroix_mm_mode_text);
    destroix_mm_mode.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_mm_mode_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_mm_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_mm_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    destroix_mm_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_mm_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_mm_reg_single.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_mm_reg_team.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_mm_reg_single_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_mm_reg_team_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_mm_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    destroix_mm_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));

    TextView destroix_mm_spons=(TextView) view.findViewById(R.id.destroix_mm_spons);
    destroix_mm_spons.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));

}

public void initSports(){
    LinearLayout view_Sports=(LinearLayout) view.findViewById(R.id.view_sports);
    final LinearLayout view_sports_arm=(LinearLayout) view.findViewById(R.id.sports_arm);
    final LinearLayout view_sports_cricket=(LinearLayout) view.findViewById(R.id.sports_cricket);
    final LinearLayout view_sports_football=(LinearLayout) view.findViewById(R.id.sports_football);
    final LinearLayout view_sports_basketball=(LinearLayout) view.findViewById(R.id.sports_basketball);
    final LinearLayout view_sports_badminton=(LinearLayout) view.findViewById(R.id.sports_badminton);
    final SmartTabLayout view_destroix_tabs=(SmartTabLayout) view.findViewById(R.id.viewpagertab_sports);

    ViewPager viewPager=(ViewPager) view.findViewById(R.id.viewpager_sports);
    ViewPagerItemAdapter adapter = new ViewPagerItemAdapter(ViewPagerItems.with(getActivity())
            .add("arm wrestling", R.layout.sports_arm)
            .add("cricket", R.layout.sports_cricket)
            .add("football",R.layout.sports_football)
            .add("basketball",R.layout.destroix_cod)
            .add("badminton",R.layout.destroix_cr)
            .create());

    view_destroix_tabs.setOnTabClickListener(new SmartTabLayout.OnTabClickListener() {

        public void onTabClicked(int position) {
            switch(position){
                case 0:view_destroix_tabs.animate();
                    view_sports_arm.setVisibility(View.VISIBLE);
                    view_sports_cricket.setVisibility(View.GONE);
                    view_sports_football.setVisibility(View.GONE);
                    view_sports_basketball.setVisibility(View.GONE);
                    view_sports_badminton.setVisibility(View.GONE);

                    break;
                case 1:view_destroix_tabs.animate();
                    view_sports_cricket.setVisibility(View.VISIBLE);
                    view_sports_arm.setVisibility(View.GONE);
                    view_sports_football.setVisibility(View.GONE);
                    view_sports_basketball.setVisibility(View.GONE);
                    view_sports_badminton.setVisibility(View.GONE);
                    break;
                case 2:view_destroix_tabs.animate();
                    view_sports_football.setVisibility(View.VISIBLE);
                    view_sports_arm.setVisibility(View.GONE);
                    view_sports_cricket.setVisibility(View.GONE);
                    view_sports_basketball.setVisibility(View.GONE);
                    view_sports_badminton.setVisibility(View.GONE);
                    break;
                case 3:view_destroix_tabs.animate();
                    view_sports_basketball.setVisibility(View.VISIBLE);
                    view_sports_arm.setVisibility(View.GONE);
                    view_sports_cricket.setVisibility(View.GONE);
                    view_sports_football.setVisibility(View.GONE);
                    view_sports_badminton.setVisibility(View.GONE);
                    break;
                case 4:view_destroix_tabs.animate();
                    view_sports_badminton.setVisibility(View.VISIBLE);
                    view_sports_arm.setVisibility(View.GONE);
                    view_sports_cricket.setVisibility(View.GONE);
                    view_sports_football.setVisibility(View.GONE);
                    view_sports_basketball.setVisibility(View.GONE);
                    break;

            }
        }
    });
    viewPager.setAdapter(adapter);
    view_destroix_tabs.setViewPager(viewPager);

    //Arm
    TextView sports_arm_regulations=(TextView) view.findViewById(R.id.view_sports_arm_regulations);
    TextView sports_arm_rules=(TextView) view.findViewById(R.id.view_sports_arm_rules);
    TextView sports_arm_fouls=(TextView) view.findViewById(R.id.view_sports_arm_fouls);
    TextView sports_arm_date_title=(TextView) view.findViewById(R.id.view_sports_arm_dates);
    TextView sports_arm_date=(TextView) view.findViewById(R.id.view_sports_arm_date);
    sports_arm_date.setText(Html.fromHtml("<br/>6<sup>th</sup> january 2018"));
    TextView sports_arm_reg_title=(TextView) view.findViewById(R.id.view_sports_arm_reg_title);
    TextView sports_arm_reg=(TextView) view.findViewById(R.id.view_sports_arm_reg);
    RelativeLayout sports_arm_register=(RelativeLayout) view.findViewById(R.id.view_sports_arm_register);
    TextView sports_arm_coordinators_title=(TextView) view.findViewById(R.id.view_sports_arm_coordinators);
    TextView sports_arm_coordinators=(TextView) view.findViewById(R.id.view_sports_arm_coordinator_text);

    sports_arm_regulations.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_arm_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_arm_fouls.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_arm_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_arm_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    sports_arm_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_arm_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_arm_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_arm_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_arm_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://talenttantra.com/registration.php/armwrestling";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
   //arm ends

    //cricket

    TextView sports_cricket_rules=(TextView) view.findViewById(R.id.view_sports_cricket_rules);
    TextView sports_cricket_date_title=(TextView) view.findViewById(R.id.view_sports_cricket_dates);
    TextView sports_cricket_date=(TextView) view.findViewById(R.id.view_sports_cricket_date);
    sports_cricket_date.setText(Html.fromHtml("5<sup>th</sup> january 2018<br/>6<sup>th</sup> january 2018"));
    TextView sports_cricket_reg_title=(TextView) view.findViewById(R.id.view_sports_cricket_reg_title);
    TextView sports_cricket_reg=(TextView) view.findViewById(R.id.view_sports_cricket_reg);
    RelativeLayout sports_cricket_register=(RelativeLayout) view.findViewById(R.id.view_sports_cricket_register);
    TextView sports_cricket_coordinators_title=(TextView) view.findViewById(R.id.view_sports_cricket_coordinators);
    TextView sports_cricket_coordinators=(TextView) view.findViewById(R.id.view_sports_cricket_coordinator_text);

    sports_cricket_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_cricket_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_cricket_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    sports_cricket_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_cricket_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_cricket_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_cricket_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_cricket_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://talenttantra.com/registration.php/cricket";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });

    //cricket ends

    //football
    TextView sports_football_rules=(TextView) view.findViewById(R.id.view_sports_football_rules);
    TextView sports_football_date_title=(TextView) view.findViewById(R.id.view_sports_football_dates);
    TextView sports_football_date=(TextView) view.findViewById(R.id.view_sports_football_date);
    sports_football_date.setText(Html.fromHtml("5<sup>th</sup> january 2018<br/>6<sup>th</sup> january 2018"));
    TextView sports_football_reg_title=(TextView) view.findViewById(R.id.view_sports_football_reg_title);
    TextView sports_football_reg=(TextView) view.findViewById(R.id.view_sports_football_reg);
    RelativeLayout sports_football_register=(RelativeLayout) view.findViewById(R.id.view_sports_football_register);
    TextView sports_football_coordinators_title=(TextView) view.findViewById(R.id.view_sports_football_coordinators);
    TextView sports_football_coordinators=(TextView) view.findViewById(R.id.view_sports_football_coordinator_text);

    sports_football_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_football_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_football_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    sports_football_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_football_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_football_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_football_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_football_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://talenttantra.com/registration.php/football";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });

    //football ends

    //basketball
    TextView sports_basketball_rules=(TextView) view.findViewById(R.id.view_sports_basketball_rules);
    TextView sports_basketball_date_title=(TextView) view.findViewById(R.id.view_sports_basketball_dates);
    TextView sports_basketball_date=(TextView) view.findViewById(R.id.view_sports_basketball_date);
    sports_basketball_date.setText(Html.fromHtml("5<sup>th</sup> january 2018<br/>6<sup>th</sup> january 2018"));
    TextView sports_basketball_reg_title=(TextView) view.findViewById(R.id.view_sports_basketball_reg_title);
    TextView sports_basketball_reg=(TextView) view.findViewById(R.id.view_sports_basketball_reg);
    RelativeLayout sports_basketball_register=(RelativeLayout) view.findViewById(R.id.view_sports_basketball_register);
    TextView sports_basketball_coordinators_title=(TextView) view.findViewById(R.id.view_sports_basketball_coordinators);
    TextView sports_basketball_coordinators=(TextView) view.findViewById(R.id.view_sports_basketball_coordinator_text);

    sports_basketball_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_basketball_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_basketball_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    sports_basketball_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_basketball_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_basketball_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_basketball_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_basketball_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://talenttantra.com/registration.php/basketball";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });

    //basketball ends

    //badminton
    TextView sports_badminton_rules=(TextView) view.findViewById(R.id.view_sports_badminton_rules);
    TextView sports_badminton_date_title=(TextView) view.findViewById(R.id.view_sports_badminton_dates);
    TextView sports_badminton_date=(TextView) view.findViewById(R.id.view_sports_badminton_date);
    sports_badminton_date.setText(Html.fromHtml("5<sup>th</sup> january 2018<br/>6<sup>th</sup> january 2018"));
    TextView sports_badminton_reg_title=(TextView) view.findViewById(R.id.view_sports_badminton_reg_title);
    TextView sports_badminton_reg=(TextView) view.findViewById(R.id.view_sports_badminton_reg);
    RelativeLayout sports_badminton_register=(RelativeLayout) view.findViewById(R.id.view_sports_badminton_register);
    TextView sports_badminton_coordinators_title=(TextView) view.findViewById(R.id.view_sports_badminton_coordinators);
    TextView sports_badminton_coordinators=(TextView) view.findViewById(R.id.view_sports_badminton_coordinator_text);

    sports_badminton_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_badminton_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_badminton_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    sports_badminton_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_badminton_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_badminton_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_badminton_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    sports_badminton_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://talenttantra.com/registration.php/badminton";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    //badminton ends
}

public void initMattermind(){
    final NavigationTabStrip view_mattermind_tabs=(NavigationTabStrip) view.findViewById(R.id.tabs_mattermind);
    final LinearLayout view_mattermind=(LinearLayout) view.findViewById(R.id.view_mattermind);
    final LinearLayout view_mattermind_admania=(LinearLayout) view.findViewById(R.id.mattermind_admania);
    final LinearLayout view_mattermind_fuel=(LinearLayout) view.findViewById(R.id.mattermind_fuel);
    final LinearLayout view_mattermind_quiz=(LinearLayout) view.findViewById(R.id.mattermind_quiz);

    final NavigationTabStrip navigationTabStrip = (NavigationTabStrip) view.findViewById(R.id.tabs_mattermind);
    navigationTabStrip.setTabIndex(0,true);
    navigationTabStrip.setOnTabStripSelectedIndexListener(new NavigationTabStrip.OnTabStripSelectedIndexListener() {
        @Override
        public void onStartTabSelected(String title, int index) {
            if(index==0){

                //Admania
                view_mattermind_admania.setVisibility(View.VISIBLE);
                view_mattermind_quiz.setVisibility(View.GONE);
                view_mattermind_fuel.setVisibility(View.GONE);
            }else if(index==1){
                //Fuel

                view_mattermind_fuel.setVisibility(View.VISIBLE);
                view_mattermind_quiz.setVisibility(View.GONE);
                view_mattermind_admania.setVisibility(View.GONE);
            }else if(index==2){
                //Quiz
                view_mattermind_quiz.setVisibility(View.VISIBLE);
                view_mattermind_fuel.setVisibility(View.GONE);
                view_mattermind_admania.setVisibility(View.GONE);
            }
        }

        @Override
        public void onEndTabSelected(String title, int index) {

        }
    });

    //ADMANIA
    TextView mattermind_admania_format=(TextView) view.findViewById(R.id.view_mattermind_admania_format);
    TextView mattermind_admania_eligibility=(TextView) view.findViewById(R.id.view_mattermind_admania_eligibility);
    TextView mattermind_admania_rules=(TextView) view.findViewById(R.id.view_mattermind_admania_rules);
    TextView mattermind_admania_formation_teams=(TextView) view.findViewById(R.id.view_mattermind_admania_formation_teams);
    TextView mattermind_admania_general_rules=(TextView) view.findViewById(R.id.view_mattermind_admania_general_rules);
    TextView mattermind_admania_date_title=(TextView) view.findViewById(R.id.view_mattermind_admania_dates);
    TextView mattermind_admania_date=(TextView) view.findViewById(R.id.view_mattermind_admania_date);
    mattermind_admania_date.setText(Html.fromHtml("5<sup>th</sup> january 2018<br/>6<sup>th</sup> january 2018"));
    TextView mattermind_admania_reg_title=(TextView) view.findViewById(R.id.view_mattermind_admania_reg_title);
    TextView mattermind_admania_reg=(TextView) view.findViewById(R.id.view_mattermind_admania_reg);
    RelativeLayout mattermind_admania_register=(RelativeLayout) view.findViewById(R.id.view_mattermind_admania_register);
    TextView mattermind_admania_coordinators_title=(TextView) view.findViewById(R.id.view_mattermind_admania_coordinators);
    TextView mattermind_admania_coordinators=(TextView) view.findViewById(R.id.view_mattermind_admania_coordinator_text);

    mattermind_admania_format.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_admania_eligibility.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_admania_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_admania_formation_teams.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_admania_general_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_admania_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_admania_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    mattermind_admania_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_admania_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_admania_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_admania_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_admania_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://talenttantra.com/registration.php/admania";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
//ADMANIA ends

    //Fuel your dream
    TextView mattermind_fuel_eligibility=(TextView) view.findViewById(R.id.view_mattermind_fuel_eligibility);
    TextView mattermind_fuel_evaluation=(TextView) view.findViewById(R.id.view_mattermind_fuel_evaluation);
    TextView mattermind_fuel_rules=(TextView) view.findViewById(R.id.view_mattermind_fuel_rules);
    TextView mattermind_fuel_formation_teams=(TextView) view.findViewById(R.id.view_mattermind_fuel_formation_teams);
    TextView mattermind_fuel_general_rules=(TextView) view.findViewById(R.id.view_mattermind_fuel_general_rules);
    TextView mattermind_fuel_date_title=(TextView) view.findViewById(R.id.view_mattermind_fuel_dates);
    TextView mattermind_fuel_date=(TextView) view.findViewById(R.id.view_mattermind_fuel_date);
    mattermind_fuel_date.setText(Html.fromHtml("5<sup>th</sup> january 2018<br/>6<sup>th</sup> january 2018"));
    TextView mattermind_fuel_reg_title=(TextView) view.findViewById(R.id.view_mattermind_fuel_reg_title);
    TextView mattermind_fuel_reg=(TextView) view.findViewById(R.id.view_mattermind_fuel_reg);
    RelativeLayout mattermind_fuel_register=(RelativeLayout) view.findViewById(R.id.view_mattermind_fuel_register);
    TextView mattermind_fuel_coordinators_title=(TextView) view.findViewById(R.id.view_mattermind_fuel_coordinators);
    TextView mattermind_fuel_coordinators=(TextView) view.findViewById(R.id.view_mattermind_fuel_coordinator_text);

    mattermind_fuel_evaluation.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_fuel_eligibility.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_fuel_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_fuel_formation_teams.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_fuel_general_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_fuel_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_fuel_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    mattermind_fuel_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_fuel_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_fuel_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_fuel_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_fuel_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://talenttantra.com/registration.php/fuelyourdream";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    //fuel your dream ends

   //quiz
    TextView mattermind_quiz_eligibility=(TextView) view.findViewById(R.id.view_mattermind_quiz_eligibility);
    TextView mattermind_quiz_formation_teams=(TextView) view.findViewById(R.id.view_mattermind_quiz_formation_teams);
    TextView mattermind_quiz_general_rules=(TextView) view.findViewById(R.id.view_mattermind_quiz_general_rules);
    TextView mattermind_quiz_requirements=(TextView) view.findViewById(R.id.view_mattermind_quiz_requirements);
    TextView mattermind_quiz_date_title=(TextView) view.findViewById(R.id.view_mattermind_quiz_dates);
    TextView mattermind_quiz_date=(TextView) view.findViewById(R.id.view_mattermind_quiz_date);
    mattermind_quiz_date.setText(Html.fromHtml("5<sup>th</sup> january 2018<br/>6<sup>th</sup> january 2018"));
    TextView mattermind_quiz_reg_title=(TextView) view.findViewById(R.id.view_mattermind_quiz_reg_title);
    TextView mattermind_quiz_reg_single=(TextView) view.findViewById(R.id.mattermind_quiz_reg_single);
    TextView mattermind_quiz_reg_team=(TextView) view.findViewById(R.id.mattermind_quiz_reg_team);
    TextView mattermind_quiz_reg_single_text=(TextView) view.findViewById(R.id.single_text_mattermind_quiz);
    TextView mattermind_quiz_reg_team_text=(TextView) view.findViewById(R.id.team_text_mattermind_quiz);
    RelativeLayout mattermind_quiz_register_single=(RelativeLayout) view.findViewById(R.id.mattermind_quiz_register_single);
    RelativeLayout mattermind_quiz_register_team=(RelativeLayout) view.findViewById(R.id.mattermind_quiz_register_team);
    TextView mattermind_quiz_coordinators_title=(TextView) view.findViewById(R.id.view_mattermind_quiz_coordinators);
    TextView mattermind_quiz_coordinators=(TextView) view.findViewById(R.id.view_mattermind_quiz_coordinator_text);

    mattermind_quiz_requirements.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_quiz_eligibility.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));

    mattermind_quiz_formation_teams.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_quiz_general_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_quiz_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_quiz_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    mattermind_quiz_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_quiz_reg_single.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_quiz_reg_team.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_quiz_reg_single_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_quiz_reg_team_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_quiz_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_quiz_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    mattermind_quiz_register_single.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://talenttantra.com/registration.php/quizoholic-member";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    mattermind_quiz_register_team.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://talenttantra.com/registration.php/quizoholic-team";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    //quiz ends
}

public void initFocusia(){
    final LinearLayout view_focusia=(LinearLayout) view.findViewById(R.id.view_focusia);
    final LinearLayout view_focusia_selfie=(LinearLayout) view.findViewById(R.id.focusia_selfie);
    final LinearLayout view_focusia_movie=(LinearLayout) view.findViewById(R.id.focusia_movie);
    final LinearLayout view_focusia_rowd=(LinearLayout) view.findViewById(R.id.focusia_rowd);

    final NavigationTabStrip navigationTabStrip = (NavigationTabStrip) view.findViewById(R.id.tabs_focusia);
    navigationTabStrip.setTabIndex(0,true);
    navigationTabStrip.setOnTabStripSelectedIndexListener(new NavigationTabStrip.OnTabStripSelectedIndexListener() {
        @Override
        public void onStartTabSelected(String title, int index) {
            if(index==0){

                //SELFIE
                view_focusia_selfie.setVisibility(View.VISIBLE);
                view_focusia_rowd.setVisibility(View.GONE);
                view_focusia_movie.setVisibility(View.GONE);
            }else if(index==1){
                //MOVIE

                view_focusia_movie.setVisibility(View.VISIBLE);
                view_focusia_rowd.setVisibility(View.GONE);
                view_focusia_selfie.setVisibility(View.GONE);

            }else if(index==2){
                //ROWD
                view_focusia_rowd.setVisibility(View.VISIBLE);
                view_focusia_movie.setVisibility(View.GONE);
                view_focusia_selfie.setVisibility(View.GONE);
            }
        }

        @Override
        public void onEndTabSelected(String title, int index) {

        }
    });

    //SELFIE
    TextView focusia_selfie_rules=(TextView) view.findViewById(R.id.view_focusia_selfie_rules);
    TextView focusia_selfie_coordinators=(TextView) view.findViewById(R.id.view_focusia_selfie_coordinators);
    TextView focusia_selfie_coordinators_text=(TextView) view.findViewById(R.id.view_focusia_selfie_coordinator_text);
    TextView focusia_selfie_photobooth_title=(TextView) view.findViewById(R.id.view_focusia_selfie_photobooth);
    TextView focusia_selfie_photobooth_coordinators=(TextView) view.findViewById(R.id.view_focusia_selfie_coordinators_photobooth);
    TextView focusia_selfie_coordinator_text_photobooth=(TextView) view.findViewById(R.id.view_focusia_selfie_coordinator_text_photobooth);
    focusia_selfie_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    focusia_selfie_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    focusia_selfie_coordinators_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    focusia_selfie_photobooth_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    focusia_selfie_photobooth_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    focusia_selfie_coordinator_text_photobooth.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    //Selfie ends

    //MOVIE
    TextView focusia_movie_rules=(TextView) view.findViewById(R.id.view_focusia_movie_rules);
    TextView focusia_movie_theme=(TextView) view.findViewById(R.id.view_focusia_movie_theme);
    TextView focusia_movie_theme_text=(TextView) view.findViewById(R.id.view_focusia_movie_theme_text);
    TextView focusia_movie_reg_title=(TextView) view.findViewById(R.id.view_focusia_movie_reg_title);
    TextView focusia_movie_reg_text=(TextView) view.findViewById(R.id.view_focusia_movie_reg);
    TextView focusia_movie_note=(TextView) view.findViewById(R.id.view_focusia_movie_note);
    focusia_movie_note.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    focusia_movie_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    focusia_movie_theme.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    focusia_movie_theme_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    focusia_movie_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    focusia_movie_reg_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    RelativeLayout focusia_movie_register=(RelativeLayout) view.findViewById(R.id.view_focusia_movie_register);
    focusia_movie_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://talenttantra.com/registration.php/moviemaking";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
   //MOVIE ends

//ROWD
    TextView focusia_rowd_rules=(TextView) view.findViewById(R.id.view_focusia_rowd_rules);
    TextView focusia_rowd_theme=(TextView) view.findViewById(R.id.view_focusia_rowd_theme);
    TextView focusia_rowd_theme_text=(TextView) view.findViewById(R.id.view_focusia_rowd_theme_text);
    TextView focusia_rowd_reg_title=(TextView) view.findViewById(R.id.view_focusia_rowd_reg_title);
    TextView focusia_rowd_reg_text=(TextView) view.findViewById(R.id.view_focusia_rowd_reg);
    TextView focusia_rowd_coordinators=(TextView) view.findViewById(R.id.view_focusia_rowd_coordinators);
    TextView focusia_rowd_coordinators_text=(TextView) view.findViewById(R.id.view_focusia_rowd_coordinator_text);
    TextView focusia_rowd_note=(TextView) view.findViewById(R.id.view_focusia_rowd_note);
    focusia_rowd_note.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    focusia_rowd_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    focusia_rowd_theme.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    focusia_rowd_theme_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    focusia_rowd_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    focusia_rowd_reg_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    focusia_rowd_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    focusia_rowd_coordinators_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    RelativeLayout focusia_rowd_register=(RelativeLayout) view.findViewById(R.id.view_focusia_rowd_register);
    focusia_rowd_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://talenttantra.com/registration.php/photography";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    //ROWD ends
}

public void initPerspective(){
    LinearLayout view_perspective=(LinearLayout) view.findViewById(R.id.view_perspective);
    final LinearLayout view_perspective_crime=(LinearLayout) view.findViewById(R.id.perspective_crime);
    final LinearLayout view_perspective_treasure=(LinearLayout) view.findViewById(R.id.perspective_treasure);
    final LinearLayout view_perspective_quiz=(LinearLayout) view.findViewById(R.id.perspective_quiz);
    final LinearLayout view_perspective_face=(LinearLayout) view.findViewById(R.id.perspective_face);
    final LinearLayout view_perspective_comic=(LinearLayout) view.findViewById(R.id.perspective_comic);
    final LinearLayout view_perspective_love=(LinearLayout) view.findViewById(R.id.perspective_love);
    final LinearLayout view_perspective_live=(LinearLayout) view.findViewById(R.id.perspective_live);
    final LinearLayout view_perspective_mys=(LinearLayout) view.findViewById(R.id.perspective_mys);

    final SmartTabLayout view_perspective_tabs=(SmartTabLayout) view.findViewById(R.id.viewpagertab_perspective);


    ViewPager viewPager=(ViewPager) view.findViewById(R.id.viewpager_perspective);
    ViewPagerItemAdapter adapter = new ViewPagerItemAdapter(ViewPagerItems.with(getActivity())
            .add("crime scene investigation", R.layout.perspective_crime)
            .add("treasure hunt", R.layout.perspective_treasure)
            .add("quiz",R.layout.perspective_quiz)
            .add("face painting",R.layout.perspective_face)
            .add("comic strip drawing",R.layout.perspective_comic)
            .add("love letter writing",R.layout.perspective_love)
            .add("live painting",R.layout.perspective_live)
            .add("mysterio",R.layout.perspective_mys)
            .create());

    view_perspective_tabs.setOnTabClickListener(new SmartTabLayout.OnTabClickListener() {

        public void onTabClicked(int position) {
            switch(position){
                case 0:view_perspective_tabs.animate();
                    view_perspective_crime.setVisibility(View.VISIBLE);
                    view_perspective_treasure.setVisibility(View.GONE);
                    view_perspective_quiz.setVisibility(View.GONE);
                    view_perspective_face.setVisibility(View.GONE);
                    view_perspective_comic.setVisibility(View.GONE);
                    view_perspective_love.setVisibility(View.GONE);
                    view_perspective_live.setVisibility(View.GONE);
                    view_perspective_mys.setVisibility(View.GONE);
                    break;
                case 1:view_perspective_tabs.animate();
                    view_perspective_treasure.setVisibility(View.VISIBLE);
                    view_perspective_crime.setVisibility(View.GONE);
                    view_perspective_quiz.setVisibility(View.GONE);
                    view_perspective_face.setVisibility(View.GONE);
                    view_perspective_comic.setVisibility(View.GONE);
                    view_perspective_love.setVisibility(View.GONE);
                    view_perspective_live.setVisibility(View.GONE);
                    view_perspective_mys.setVisibility(View.GONE);
                    break;
                case 2:view_perspective_tabs.animate();
                    view_perspective_quiz.setVisibility(View.VISIBLE);
                    view_perspective_crime.setVisibility(View.GONE);
                    view_perspective_treasure.setVisibility(View.GONE);
                    view_perspective_face.setVisibility(View.GONE);
                    view_perspective_comic.setVisibility(View.GONE);
                    view_perspective_love.setVisibility(View.GONE);
                    view_perspective_live.setVisibility(View.GONE);
                    view_perspective_mys.setVisibility(View.GONE);
                    break;
                case 3:view_perspective_tabs.animate();
                    view_perspective_face.setVisibility(View.VISIBLE);
                    view_perspective_crime.setVisibility(View.GONE);
                    view_perspective_treasure.setVisibility(View.GONE);
                    view_perspective_quiz.setVisibility(View.GONE);
                    view_perspective_comic.setVisibility(View.GONE);
                    view_perspective_love.setVisibility(View.GONE);
                    view_perspective_live.setVisibility(View.GONE);
                    view_perspective_mys.setVisibility(View.GONE);
                    break;
                case 4:view_perspective_tabs.animate();
                    view_perspective_comic.setVisibility(View.VISIBLE);
                    view_perspective_crime.setVisibility(View.GONE);
                    view_perspective_treasure.setVisibility(View.GONE);
                    view_perspective_quiz.setVisibility(View.GONE);
                    view_perspective_face.setVisibility(View.GONE);
                    view_perspective_love.setVisibility(View.GONE);
                    view_perspective_live.setVisibility(View.GONE);
                    view_perspective_mys.setVisibility(View.GONE);
                    break;
                case 5: view_perspective_tabs.animate();
                    view_perspective_love.setVisibility(View.VISIBLE);
                    view_perspective_crime.setVisibility(View.GONE);
                    view_perspective_treasure.setVisibility(View.GONE);
                    view_perspective_quiz.setVisibility(View.GONE);
                    view_perspective_face.setVisibility(View.GONE);
                    view_perspective_comic.setVisibility(View.GONE);
                    view_perspective_live.setVisibility(View.GONE);
                    view_perspective_mys.setVisibility(View.GONE);
                    break;
                case 6: view_perspective_tabs.animate();
                    view_perspective_live.setVisibility(View.VISIBLE);
                    view_perspective_crime.setVisibility(View.GONE);
                    view_perspective_treasure.setVisibility(View.GONE);
                    view_perspective_quiz.setVisibility(View.GONE);
                    view_perspective_face.setVisibility(View.GONE);
                    view_perspective_comic.setVisibility(View.GONE);
                    view_perspective_love.setVisibility(View.GONE);
                    view_perspective_mys.setVisibility(View.GONE);
                    break;
                case 7: view_perspective_tabs.animate();
                    view_perspective_mys.setVisibility(View.VISIBLE);
                    view_perspective_crime.setVisibility(View.GONE);
                    view_perspective_treasure.setVisibility(View.GONE);
                    view_perspective_quiz.setVisibility(View.GONE);
                    view_perspective_face.setVisibility(View.GONE);
                    view_perspective_comic.setVisibility(View.GONE);
                    view_perspective_love.setVisibility(View.GONE);
                    view_perspective_live.setVisibility(View.GONE);
                    break;
            }
        }
    });

    viewPager.setAdapter(adapter);
    view_perspective_tabs.setViewPager(viewPager);

    //crime

    TextView perspective_crime_rules=(TextView) view.findViewById(R.id.view_perspective_crime_rules);
    TextView perspective_crime_date_title=(TextView) view.findViewById(R.id.view_perspective_crime_dates);
    TextView perspective_crime_date=(TextView) view.findViewById(R.id.view_perspective_crime_date);
    perspective_crime_date.setText(Html.fromHtml("5<sup>th</sup> january 2018\n<br/>6<sup>th</sup> january 2018\n<br/>7<sup>th</sup> january 2018"));
    TextView perspective_crime_reg_title=(TextView) view.findViewById(R.id.view_perspective_crime_reg_title);
    TextView perspective_crime_reg=(TextView) view.findViewById(R.id.view_perspective_crime_reg);
    RelativeLayout perspective_crime_register=(RelativeLayout) view.findViewById(R.id.view_perspective_crime_register);
    TextView perspective_crime_coordinators_title=(TextView) view.findViewById(R.id.view_perspective_crime_coordinators);
    TextView perspective_crime_coordinators=(TextView) view.findViewById(R.id.view_perspective_crime_coordinator_text);

    perspective_crime_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));

    perspective_crime_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_crime_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    perspective_crime_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_crime_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_crime_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_crime_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_crime_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://talenttantra.com/registration.php/crimesceneinvestigation";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    //crime ends

    //treasure hunt

    TextView perspective_treasure_rules=(TextView) view.findViewById(R.id.view_perspective_treasure_rules);
    TextView perspective_treasure_date_title=(TextView) view.findViewById(R.id.view_perspective_treasure_dates);
    TextView perspective_treasure_date=(TextView) view.findViewById(R.id.view_perspective_treasure_date);
    perspective_treasure_date.setText(Html.fromHtml("5<sup>th</sup> january 2018\n<br/>6<sup>th</sup> january 2018"));
    TextView perspective_treasure_reg_title=(TextView) view.findViewById(R.id.view_perspective_treasure_reg_title);
    TextView perspective_treasure_reg=(TextView) view.findViewById(R.id.view_perspective_treasure_reg);
    RelativeLayout perspective_treasure_register=(RelativeLayout) view.findViewById(R.id.view_perspective_treasure_register);
    TextView perspective_treasure_coordinators_title=(TextView) view.findViewById(R.id.view_perspective_treasure_coordinators);
    TextView perspective_treasure_coordinators=(TextView) view.findViewById(R.id.view_perspective_treasure_coordinator_text);

    perspective_treasure_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_treasure_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_treasure_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    perspective_treasure_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_treasure_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_treasure_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_treasure_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_treasure_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://talenttantra.com/registration.php/treasurehunt";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });

    //treasure ends

    //quiz
    TextView perspective_quiz_rules=(TextView) view.findViewById(R.id.view_perspective_quiz_rules);
    TextView perspective_quiz_date_title=(TextView) view.findViewById(R.id.view_perspective_quiz_dates);
    TextView perspective_quiz_date=(TextView) view.findViewById(R.id.view_perspective_quiz_date);
    perspective_quiz_date.setText(Html.fromHtml("5<sup>th</sup> january 2018\n<br/>6<sup>th</sup> january 2018"));
    TextView perspective_quiz_reg_title=(TextView) view.findViewById(R.id.view_perspective_quiz_reg_title);
    TextView perspective_quiz_reg=(TextView) view.findViewById(R.id.view_perspective_quiz_reg);
    RelativeLayout perspective_quiz_register=(RelativeLayout) view.findViewById(R.id.view_perspective_quiz_register);
    TextView perspective_quiz_coordinators_title=(TextView) view.findViewById(R.id.view_perspective_quiz_coordinators);
    TextView perspective_quiz_coordinators=(TextView) view.findViewById(R.id.view_perspective_quiz_coordinator_text);

    perspective_quiz_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_quiz_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_quiz_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    perspective_quiz_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_quiz_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_quiz_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_quiz_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_quiz_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://talenttantra.com/registration.php/pquiz";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    //quiz ends

    //face painting
    TextView perspective_face_rules=(TextView) view.findViewById(R.id.view_perspective_face_rules);
    TextView perspective_face_date_title=(TextView) view.findViewById(R.id.view_perspective_face_dates);
    TextView perspective_face_date=(TextView) view.findViewById(R.id.view_perspective_face_date);
    perspective_face_date.setText(Html.fromHtml("5<sup>th</sup> january 2018\n<br/>6<sup>th</sup> january 2018"));
    TextView perspective_face_reg_title=(TextView) view.findViewById(R.id.view_perspective_face_reg_title);
    TextView perspective_face_reg=(TextView) view.findViewById(R.id.view_perspective_face_reg);
    RelativeLayout perspective_face_register=(RelativeLayout) view.findViewById(R.id.view_perspective_face_register);
    TextView perspective_face_coordinators_title=(TextView) view.findViewById(R.id.view_perspective_face_coordinators);
    TextView perspective_face_coordinators=(TextView) view.findViewById(R.id.view_perspective_face_coordinator_text);

    perspective_face_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_face_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_face_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    perspective_face_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_face_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_face_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_face_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_face_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://talenttantra.com/registration.php/facepainting";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    //face ends

    //comic
    TextView perspective_comic_rules=(TextView) view.findViewById(R.id.view_perspective_comic_rules);
    TextView perspective_comic_date_title=(TextView) view.findViewById(R.id.view_perspective_comic_dates);
    TextView perspective_comic_date=(TextView) view.findViewById(R.id.view_perspective_comic_date);
    perspective_comic_date.setText(Html.fromHtml("5<sup>th</sup> january 2018\n<br/>6<sup>th</sup> january 2018"));


    TextView perspective_comic_coordinators_title=(TextView) view.findViewById(R.id.view_perspective_comic_coordinators);
    TextView perspective_comic_coordinators=(TextView) view.findViewById(R.id.view_perspective_comic_coordinator_text);
    perspective_comic_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_comic_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_comic_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));

    perspective_comic_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_comic_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));

    TextView perspective_comic_reg_title=(TextView) view.findViewById(R.id.view_perspective_comic_reg_title);
    TextView perspective_comic_reg_single=(TextView) view.findViewById(R.id.perspective_comic_reg_single);
    TextView perspective_comic_reg_team=(TextView) view.findViewById(R.id.perspective_comic_reg_team);
    TextView perspective_comic_reg_single_text=(TextView) view.findViewById(R.id.single_text_perspective_comic);
    TextView perspective_comic_reg_team_text=(TextView) view.findViewById(R.id.team_text_perspective_comic);
    RelativeLayout perspective_comic_register_single=(RelativeLayout) view.findViewById(R.id.perspective_comic_register_single);
    RelativeLayout perspective_comic_register_team=(RelativeLayout) view.findViewById(R.id.perspective_comic_register_team);

    perspective_comic_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_comic_reg_single.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_comic_reg_team.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_comic_reg_single_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_comic_reg_team_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));

    perspective_comic_register_single.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://talenttantra.com/registration.php/comicstripdrawing";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    perspective_comic_register_team.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://talenttantra.com/registration.php/comicstripdrawing";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });

    //comic ends

  //love letter writing
    TextView perspective_love_rules=(TextView) view.findViewById(R.id.view_perspective_love_rules);
    TextView perspective_love_date_title=(TextView) view.findViewById(R.id.view_perspective_love_dates);
    TextView perspective_love_date=(TextView) view.findViewById(R.id.view_perspective_love_date);
    perspective_love_date.setText(Html.fromHtml("5<sup>th</sup> january 2018\n<br/>6<sup>th</sup> january 2018"));
    TextView perspective_love_reg_title=(TextView) view.findViewById(R.id.view_perspective_love_reg_title);
    TextView perspective_love_reg=(TextView) view.findViewById(R.id.view_perspective_love_reg);
    RelativeLayout perspective_love_register=(RelativeLayout) view.findViewById(R.id.view_perspective_love_register);
    TextView perspective_love_coordinators_title=(TextView) view.findViewById(R.id.view_perspective_love_coordinators);
    TextView perspective_love_coordinators=(TextView) view.findViewById(R.id.view_perspective_love_coordinator_text);

    perspective_love_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_love_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_love_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    perspective_love_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_love_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_love_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_love_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_love_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://talenttantra.com/registration.php/loveletterwriting";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });

    //love ends

    //live painting
    TextView perspective_live_rules=(TextView) view.findViewById(R.id.view_perspective_live_rules);
    TextView perspective_live_date_title=(TextView) view.findViewById(R.id.view_perspective_live_dates);
    TextView perspective_live_date=(TextView) view.findViewById(R.id.view_perspective_live_date);
    perspective_live_date.setText(Html.fromHtml("5<sup>th</sup> january 2018\n<br/>6<sup>th</sup> january 2018"));
    TextView perspective_live_reg_title=(TextView) view.findViewById(R.id.view_perspective_live_reg_title);
    TextView perspective_live_reg=(TextView) view.findViewById(R.id.view_perspective_live_reg);
    RelativeLayout perspective_live_register=(RelativeLayout) view.findViewById(R.id.view_perspective_live_register);
    TextView perspective_live_coordinators_title=(TextView) view.findViewById(R.id.view_perspective_live_coordinators);
    TextView perspective_live_coordinators=(TextView) view.findViewById(R.id.view_perspective_live_coordinator_text);

    perspective_live_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_live_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_live_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    perspective_live_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_live_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_live_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_live_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_live_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://talenttantra.com/registration.php";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    //live ends

    //mys
    TextView perspective_mys_rules=(TextView) view.findViewById(R.id.view_perspective_mys_rules);
    TextView perspective_mys_date_title=(TextView) view.findViewById(R.id.view_perspective_mys_dates);
    TextView perspective_mys_date=(TextView) view.findViewById(R.id.view_perspective_mys_date);
    perspective_mys_date.setText(Html.fromHtml("5<sup>th</sup> january 2018\n<br/>6<sup>th</sup> january 2018\n<br/>7<sup>th</sup> january 2018"));
    TextView perspective_mys_reg_title=(TextView) view.findViewById(R.id.view_perspective_mys_reg_title);
    TextView perspective_mys_reg=(TextView) view.findViewById(R.id.view_perspective_mys_reg);
    RelativeLayout perspective_mys_register=(RelativeLayout) view.findViewById(R.id.view_perspective_mys_register);
    TextView perspective_mys_coordinators_title=(TextView) view.findViewById(R.id.view_perspective_mys_coordinators);
    TextView perspective_mys_coordinators=(TextView) view.findViewById(R.id.view_perspective_mys_coordinator_text);

    perspective_mys_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_mys_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_mys_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    perspective_mys_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_mys_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_mys_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_mys_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    perspective_mys_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://talenttantra.com/registration.php/mysterio";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    //mys ends




}

public void initTechnova(){
    LinearLayout view_technova=(LinearLayout) view.findViewById(R.id.view_technova);
    final LinearLayout view_technova_fried=(LinearLayout) view.findViewById(R.id.technova_fried);
    final LinearLayout view_technova_tekfo=(LinearLayout) view.findViewById(R.id.technova_tekfo);
    final LinearLayout view_technova_build=(LinearLayout) view.findViewById(R.id.technova_build);
    final LinearLayout view_technova_robo=(LinearLayout) view.findViewById(R.id.technova_robo);
    final LinearLayout view_technova_cod=(LinearLayout) view.findViewById(R.id.technova_cod);



    final SmartTabLayout view_perspective_tabs=(SmartTabLayout) view.findViewById(R.id.viewpagertab_technova);


    ViewPager viewPager=(ViewPager) view.findViewById(R.id.viewpager_technova);
    ViewPagerItemAdapter adapter = new ViewPagerItemAdapter(ViewPagerItems.with(getActivity())
            .add("fried circuits", R.layout.technova_fried)
            .add("tekfo hunt", R.layout.technova_tekfo)
            .add("build-da-bridge", R.layout.technova_build)
            .add("robo ranger", R.layout.technova_robo)
            .add("codaventure", R.layout.technova_cod)
            .create());

    view_perspective_tabs.setOnTabClickListener(new SmartTabLayout.OnTabClickListener() {

        public void onTabClicked(int position) {
            switch(position){
                case 0:view_perspective_tabs.animate();
                    view_technova_fried.setVisibility(View.VISIBLE);
                    view_technova_tekfo.setVisibility(View.GONE);
                    view_technova_build.setVisibility(View.GONE);
                    view_technova_robo.setVisibility(View.GONE);
                    view_technova_cod.setVisibility(View.GONE);
                    break;
                case 1:view_perspective_tabs.animate();
                    view_technova_tekfo.setVisibility(View.VISIBLE);
                    view_technova_fried.setVisibility(View.GONE);
                    view_technova_build.setVisibility(View.GONE);
                    view_technova_robo.setVisibility(View.GONE);
                    view_technova_cod.setVisibility(View.GONE);
                    break;
                case 2:view_perspective_tabs.animate();
                    view_technova_build.setVisibility(View.VISIBLE);
                    view_technova_fried.setVisibility(View.GONE);
                    view_technova_tekfo.setVisibility(View.GONE);
                    view_technova_robo.setVisibility(View.GONE);
                    view_technova_cod.setVisibility(View.GONE);
                    break;
                case 3:view_perspective_tabs.animate();
                    view_technova_robo.setVisibility(View.VISIBLE);
                    view_technova_fried.setVisibility(View.GONE);
                    view_technova_tekfo.setVisibility(View.GONE);
                    view_technova_build.setVisibility(View.GONE);
                    view_technova_cod.setVisibility(View.GONE);
                    break;
                case 4:view_perspective_tabs.animate();
                    view_technova_cod.setVisibility(View.VISIBLE);
                    view_technova_robo.setVisibility(View.VISIBLE);
                    view_technova_fried.setVisibility(View.GONE);
                    view_technova_tekfo.setVisibility(View.GONE);
                    view_technova_build.setVisibility(View.GONE);
                    view_technova_robo.setVisibility(View.GONE);
                    break;

            }
        }
    });

    viewPager.setAdapter(adapter);
    view_perspective_tabs.setViewPager(viewPager);

    //fried
    TextView technova_fried_rules=(TextView) view.findViewById(R.id.view_technova_fried_rules);
    TextView technova_fried_date_title=(TextView) view.findViewById(R.id.view_technova_fried_dates);
    TextView technova_fried_date=(TextView) view.findViewById(R.id.view_technova_fried_date);
    technova_fried_date.setText(Html.fromHtml("<br/>7<sup>th</sup> january 2018"));
    TextView technova_fried_reg_title=(TextView) view.findViewById(R.id.view_technova_fried_reg_title);
    TextView technova_fried_reg=(TextView) view.findViewById(R.id.view_technova_fried_reg);
    RelativeLayout technova_fried_register=(RelativeLayout) view.findViewById(R.id.view_technova_fried_register);
    TextView technova_fried_coordinators_title=(TextView) view.findViewById(R.id.view_technova_fried_coordinators);
    TextView technova_fried_coordinators=(TextView) view.findViewById(R.id.view_technova_fried_coordinator_text);

    technova_fried_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_fried_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_fried_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    technova_fried_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_fried_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_fried_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_fried_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_fried_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://www.talenttantra.com/registration.php/friedcircuits";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    //fried ends

    //tekfo
    TextView technova_tekfo_rules=(TextView) view.findViewById(R.id.view_technova_tekfo_rules);
    TextView technova_tekfo_date_title=(TextView) view.findViewById(R.id.view_technova_tekfo_dates);
    TextView technova_tekfo_date=(TextView) view.findViewById(R.id.view_technova_tekfo_date);
    technova_tekfo_date.setText(Html.fromHtml("<br/>5<sup>th</sup> january 2018"));
    TextView technova_tekfo_reg_title=(TextView) view.findViewById(R.id.view_technova_tekfo_reg_title);
    TextView technova_tekfo_reg=(TextView) view.findViewById(R.id.view_technova_tekfo_reg);
    RelativeLayout technova_tekfo_register=(RelativeLayout) view.findViewById(R.id.view_technova_tekfo_register);
    TextView technova_tekfo_coordinators_title=(TextView) view.findViewById(R.id.view_technova_tekfo_coordinators);
    TextView technova_tekfo_coordinators=(TextView) view.findViewById(R.id.view_technova_tekfo_coordinator_text);

    technova_tekfo_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_tekfo_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_tekfo_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    technova_tekfo_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_tekfo_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_tekfo_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_tekfo_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_tekfo_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://www.talenttantra.com/registration.php/tekfohunt";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    //tekfo ends

    //build
    TextView technova_build_rules=(TextView) view.findViewById(R.id.view_technova_build_rules);
    TextView technova_build_date_title=(TextView) view.findViewById(R.id.view_technova_build_dates);
    TextView technova_build_date=(TextView) view.findViewById(R.id.view_technova_build_date);
    technova_build_date.setText(Html.fromHtml("<br/>6<sup>th</sup> january 2018"));
    TextView technova_build_reg_title=(TextView) view.findViewById(R.id.view_technova_build_reg_title);
    TextView technova_build_reg=(TextView) view.findViewById(R.id.view_technova_build_reg);
    RelativeLayout technova_build_register=(RelativeLayout) view.findViewById(R.id.view_technova_build_register);
    TextView technova_build_coordinators_title=(TextView) view.findViewById(R.id.view_technova_build_coordinators);
    TextView technova_build_coordinators=(TextView) view.findViewById(R.id.view_technova_build_coordinator_text);

    technova_build_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_build_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_build_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    technova_build_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_build_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_build_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_build_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_build_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://www.talenttantra.com/registration.php/build-da-bridge";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    //build ends

    //robo
    TextView technova_robo_rules=(TextView) view.findViewById(R.id.view_technova_robo_rules);
    TextView technova_robo_date_title=(TextView) view.findViewById(R.id.view_technova_robo_dates);
    TextView technova_robo_date=(TextView) view.findViewById(R.id.view_technova_robo_date);
    technova_robo_date.setText(Html.fromHtml("<br/>7<sup>th</sup> january 2018"));
    TextView technova_robo_reg_title=(TextView) view.findViewById(R.id.view_technova_robo_reg_title);
    TextView technova_robo_reg=(TextView) view.findViewById(R.id.view_technova_robo_reg);
    RelativeLayout technova_robo_register=(RelativeLayout) view.findViewById(R.id.view_technova_robo_register);
    TextView technova_robo_coordinators_title=(TextView) view.findViewById(R.id.view_technova_robo_coordinators);
    TextView technova_robo_coordinators=(TextView) view.findViewById(R.id.view_technova_robo_coordinator_text);

    technova_robo_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_robo_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_robo_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    technova_robo_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_robo_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_robo_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_robo_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_robo_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://www.talenttantra.com/registration.php/roboranger";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    //robo ends

    //code
    TextView technova_cod_rules=(TextView) view.findViewById(R.id.view_technova_cod_rules);
    TextView technova_cod_date_title=(TextView) view.findViewById(R.id.view_technova_cod_dates);
    TextView technova_cod_date=(TextView) view.findViewById(R.id.view_technova_cod_date);
    technova_cod_date.setText(Html.fromHtml("<br/>6<sup>th</sup> january 2018"));
    TextView technova_cod_reg_title=(TextView) view.findViewById(R.id.view_technova_cod_reg_title);
    TextView technova_cod_reg=(TextView) view.findViewById(R.id.view_technova_cod_reg);
    RelativeLayout technova_cod_register=(RelativeLayout) view.findViewById(R.id.view_technova_cod_register);
    TextView technova_cod_coordinators_title=(TextView) view.findViewById(R.id.view_technova_cod_coordinators);
    TextView technova_cod_coordinators=(TextView) view.findViewById(R.id.view_technova_cod_coordinator_text);

    technova_cod_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_cod_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_cod_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    technova_cod_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_cod_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_cod_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_cod_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    technova_cod_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://www.talenttantra.com/registration.php/codaventure";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    //code ends
}

public void initWinterRunway(){
    TextView winter_runway_dates_title=(TextView) view.findViewById(R.id.winter_runway_dates);
    winter_runway_dates_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    TextView winter_runway_date1=(TextView) view.findViewById(R.id.winter_runway_date1);
    RelativeLayout winter_runway_register=(RelativeLayout) view.findViewById(R.id.winter_runway_register);
    winter_runway_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://www.talenttantra.com/registration.php/winter_runway";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });

    winter_runway_date1.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    winter_runway_date1.setText(Html.fromHtml("18<sup>th</sup> december 2017,<br/> first audition at photostant, jorhat\n<br/>2<sup>nd</sup> january 2018 <br/> second audition at ku campus\n<br/>2<sup>nd</sup> - 5<sup>th</sup> january 2018 <br/> grooming session\n<br/>6<sup>th</sup> january 2018 <br/> final competition"));



    TextView winter_runway_rules=(TextView) view.findViewById(R.id.winter_runway_rules);
    winter_runway_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    TextView winter_runway_reg_title=(TextView) view.findViewById(R.id.winter_runway_reg_title);
    winter_runway_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    TextView winter_runway_reg=(TextView) view.findViewById(R.id.winter_runway_reg);
    winter_runway_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    TextView winter_runway_coordinators=(TextView) view.findViewById(R.id.winter_runway_coordinators);
    winter_runway_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    TextView winter_runway_coordinators_text=(TextView) view.findViewById(R.id.winter_runway_coordinators_text);
    winter_runway_coordinators_text.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));

    TextView winter_runway_limit=(TextView) view.findViewById(R.id.winter_runway_limit);
    winter_runway_limit.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));

}


public void initRangmanch(){

    final LinearLayout view_rangmanch=(LinearLayout) view.findViewById(R.id.view_rangmanch);
    final LinearLayout view_rangmanch_skit=(LinearLayout) view.findViewById(R.id.rangmanch_skit);
    final LinearLayout view_rangmanch_just=(LinearLayout) view.findViewById(R.id.rangmanch_just);

    final NavigationTabStrip navigationTabStrip = (NavigationTabStrip) view.findViewById(R.id.tabs_rangmanch);
    navigationTabStrip.setTabIndex(0,true);
    navigationTabStrip.setOnTabStripSelectedIndexListener(new NavigationTabStrip.OnTabStripSelectedIndexListener() {
        @Override
        public void onStartTabSelected(String title, int index) {
            if(index==0){

                //SELFIE
                view_rangmanch_skit.setVisibility(View.VISIBLE);
                view_rangmanch_just.setVisibility(View.GONE);

            }else if(index==1){
                //MOVIE

                view_rangmanch_just.setVisibility(View.VISIBLE);
                view_rangmanch_skit.setVisibility(View.GONE);


            }
        }

        @Override
        public void onEndTabSelected(String title, int index) {

        }
    });

    //Skit
    TextView rangmanch_skit_rules=(TextView) view.findViewById(R.id.view_rangmanch_skit_rules);
    TextView rangmanch_skit_date_title=(TextView) view.findViewById(R.id.view_rangmanch_skit_dates);
    TextView rangmanch_skit_date=(TextView) view.findViewById(R.id.view_rangmanch_skit_date);
    rangmanch_skit_date.setText(Html.fromHtml("<br/>5<sup>th</sup> january 2018"));
    TextView rangmanch_skit_reg_title=(TextView) view.findViewById(R.id.view_rangmanch_skit_reg_title);
    TextView rangmanch_skit_reg=(TextView) view.findViewById(R.id.view_rangmanch_skit_reg);
    RelativeLayout rangmanch_skit_register=(RelativeLayout) view.findViewById(R.id.view_rangmanch_skit_register);
    TextView rangmanch_skit_coordinators_title=(TextView) view.findViewById(R.id.view_rangmanch_skit_coordinators);
    TextView rangmanch_skit_coordinators=(TextView) view.findViewById(R.id.view_rangmanch_skit_coordinator_text);

    rangmanch_skit_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    rangmanch_skit_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    rangmanch_skit_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    rangmanch_skit_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    rangmanch_skit_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    rangmanch_skit_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    rangmanch_skit_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    rangmanch_skit_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://www.talenttantra.com/registration.php/skitplay";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    //Skit ends

   //just
    TextView rangmanch_just_rules=(TextView) view.findViewById(R.id.view_rangmanch_just_rules);
    TextView rangmanch_just_date_title=(TextView) view.findViewById(R.id.view_rangmanch_just_dates);
    TextView rangmanch_just_date=(TextView) view.findViewById(R.id.view_rangmanch_just_date);
    rangmanch_just_date.setText(Html.fromHtml("<br/>6<sup>th</sup> january 2018"));
    TextView rangmanch_just_reg_title=(TextView) view.findViewById(R.id.view_rangmanch_just_reg_title);
    TextView rangmanch_just_reg=(TextView) view.findViewById(R.id.view_rangmanch_just_reg);
    RelativeLayout rangmanch_just_register=(RelativeLayout) view.findViewById(R.id.view_rangmanch_just_register);
    TextView rangmanch_just_coordinators_title=(TextView) view.findViewById(R.id.view_rangmanch_just_coordinators);
    TextView rangmanch_just_coordinators=(TextView) view.findViewById(R.id.view_rangmanch_just_coordinator_text);

    rangmanch_just_rules.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    rangmanch_just_date.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    rangmanch_just_date_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"rib.ttf"));
    rangmanch_just_reg_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    rangmanch_just_reg.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    rangmanch_just_coordinators_title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    rangmanch_just_coordinators.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
    rangmanch_just_register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String url="http://www.talenttantra.com/registration.php/justaminute";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
    });
    //just ends

}

public void initRecycler(){
 event_view=(DiscreteScrollView) view.findViewById(R.id.item_picker);
 Events events=Events.get();
    List<Event_data> data=events.getData();
 event_view.setAdapter(new EventsAdapter(data));
    event_view.addScrollListener(this);
    event_view.addOnItemChangedListener(this);


}

public void initTexts(){
    title=(TextSwitcher) view.findViewById(R.id.event_title);
    date_feat=(TextSwitcher) view.findViewById(R.id.event_date);
   date_feat.setFactory(new ViewSwitcher.ViewFactory() {
       @Override
       public View makeView() {
           TextView textView = new TextView(getContext());
           textView.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
           textView.setHeight(150);
           textView.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL);

           textView.setTextColor(Color.parseColor("#ffffff"));
           textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
           return textView;
       }
   });
    title.setFactory(new ViewSwitcher.ViewFactory() {
        @Override
        public View makeView() {
            TextView textView = new TextView(getContext());
            textView.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"kg.ttf"));
            textView.setGravity(Gravity.CENTER);

            textView.setTextColor(Color.parseColor("#ffffff"));
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 45);
            return textView;
        }
    });


    Animation in = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_top);
    Animation out = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_top);
    title.setInAnimation(in);
    title.setOutAnimation(out);
    date_feat.setInAnimation(in);
    date_feat.setOutAnimation(out);

}

    @Override
    public void onCurrentItemChanged(@Nullable EventsAdapter.ViewHolder viewHolder, int adapterPosition) {
          Events events=Events.get();
          List<Event_data> data=events.getData();
          title.setText(data.get(adapterPosition).getEvent_name());
          if(adapterPosition <= 2){
              date_feat.setVisibility(View.VISIBLE);
              date_feat.setText(Html.fromHtml(event_feat_date_data.dates[adapterPosition]));
          }else{
              date_feat.setVisibility(View.GONE);
          }
          switchcases(adapterPosition);

    }

    @Override
    public void onScroll(float scrollPosition, int currentPosition, int newPosition, @Nullable EventsAdapter.ViewHolder currentHolder, @Nullable EventsAdapter.ViewHolder newCurrent) {

    }


}
