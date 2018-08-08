package com.example.devashish.tt20.Tickets;

import android.widget.ArrayAdapter;

import com.example.devashish.tt20.R;

/**
 * Created by Devashish on 12/30/2017.
 */

public class Card_data {
     String[] days={"ONE DAY","ALL DAYS","VIP PASS"};
    String[] pass={"[|Pass|]","[|Combo|Pass|]","[|With|Seating|]"};
    int[] price={R.drawable.rib_one,R.drawable.rib_all,R.drawable.rib_vip};
    String[][] lists={{"one day pass without seating for 5th, 6th or 7th january 2018","please note: passes are only for entry and concerts.","event registrations will be charged separately."},{"three day pass for all three days of talent tantra 2018:","5th, 6th and 7th january 2018","please note: passes are only for entry and concerts.","event registrations will be charged separately."},{"one day pass with seating for 5th, 6th or 7th january 2018","please note: passes are only for entry and concerts.","event registrations will be charged separately."}};
    String[] urls={"http://www.talenttantra.com/ticket-form.php?selected=one","http://www.talenttantra.com/ticket-form.php?selected=all","http://www.talenttantra.com/ticket-form.php?selected=vip"};

    public String[] getDays() {
        return days;
    }

    public String[] getPass() {
        return pass;
    }

    public int[] getPrice() {
        return price;
    }

    public String[][] getLists() {
        return lists;
    }

    public String[] getUrls() {
        return urls;
    }
}
