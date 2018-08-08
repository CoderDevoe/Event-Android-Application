package com.example.devashish.tt20.FrontUI;


import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.devashish.tt20.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutDialogFragment extends android.support.v4.app.DialogFragment {
  View view;

    public AboutDialogFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater=LayoutInflater.from(getActivity());
        view= inflater.inflate(R.layout.fragment_about_dialog,null);
        AlertDialog.Builder dialogbuilder=new AlertDialog.Builder(getActivity());
        initUI();
        dialogbuilder.setView(view);
        AlertDialog dialog =dialogbuilder.create();
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        return dialog;
    }

public void initUI(){
        TextView title=(TextView) view.findViewById(R.id.diagt);
        title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        TextView desctext=(TextView) view.findViewById(R.id.diagdesc);

        TextView exit=(TextView) view.findViewById(R.id.exit);
        exit.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"ass.ttf"));
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    RelativeLayout rel=(RelativeLayout) view.findViewById(R.id.exit_lay);
    rel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dismiss();
        }
    });
}

}
