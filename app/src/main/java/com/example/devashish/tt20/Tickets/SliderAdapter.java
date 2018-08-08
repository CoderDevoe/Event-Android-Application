package com.example.devashish.tt20.Tickets;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.devashish.tt20.R;

/**
 * Created by Devashish on 12/30/2017.
 */

public class SliderAdapter extends RecyclerView.Adapter<SliderCard> {


    @Override
    public SliderCard onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.layout_slider_card, parent, false);
        return new SliderCard(view,view.getContext());
    }

    @Override
    public void onBindViewHolder(SliderCard holder, int position) {
      holder.setContent(new Card_data().getDays()[position],new Card_data().getPass()[position],new Card_data().getPrice()[position],new Card_data().getLists()[position],new Card_data().getUrls()[position]);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
