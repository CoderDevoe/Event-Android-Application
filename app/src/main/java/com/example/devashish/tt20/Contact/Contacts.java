package com.example.devashish.tt20.Contact;


import android.content.Intent;

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
public class Contacts extends android.support.v4.app.Fragment implements FragmentLifecycle {
View view;

    public Contacts() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_contacts, container, false);

       LinearLayout conview=(LinearLayout) view.findViewById(R.id.conview);

        LinearLayout ttemail=(LinearLayout) view.findViewById(R.id.ttemail);
        ttemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "talenttantra@kazirangauniversity.in");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Talent Tantra 2018");
                intent.putExtra(Intent.EXTRA_TEXT, "");

                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
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
