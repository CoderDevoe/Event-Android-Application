package com.example.devashish.tt20.Guidelines;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.devashish.tt20.R;
import com.example.devashish.tt20.Utility.FragmentLifecycle;
import com.fujiyuu75.sequent.Animation;
import com.fujiyuu75.sequent.Sequent;

/**
 * A simple {@link Fragment} subclass.
 */
public class Guideline extends android.support.v4.app.Fragment implements FragmentLifecycle {
    View view;

    public Guideline() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_guideline, container, false);
        LinearLayout lin=(LinearLayout) view.findViewById(R.id.guide);
        setRetainInstance(true);
        return view;
    }

    @Override
    public void onPauseFragment() {

    }

    @Override
    public void onResumeFragment() {

    }
}
