package com.example.devashish.tt20.Tickets;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.devashish.tt20.R;


import mehdi.sakout.fancybuttons.FancyButton;
import util.android.textviews.FontTextView;

/**
 * Created by Devashish on 12/30/2017.
 */

public class SliderCard extends RecyclerView.ViewHolder {
    FontTextView Days,Pass;
    ImageView Price;
    ListView listView;
    FancyButton Buy;
    Context context;

    public SliderCard(View itemView,Context context) {
        super(itemView);
        this.context=context;
        Days=(FontTextView) itemView.findViewById(R.id.days);
        Pass=(FontTextView) itemView.findViewById(R.id.pass);
        Price=(ImageView) itemView.findViewById(R.id.price);
        listView=(ListView) itemView.findViewById(R.id.list);
        Buy=(FancyButton) itemView.findViewById(R.id.buy);
    }
    void setContent(String days, String pass, int price, String[] listitems, final String url){
        Days.setText(days);
        Pass.setText(pass);
        Price.setImageResource(price);

      ArrayAdapter<String> adapter=new ArrayAdapter<String>(context,R.layout.list_text);

        adapter.addAll(listitems);
        listView.setAdapter(adapter);

        Buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                context.startActivity(i);
            }
        });
    }




}
