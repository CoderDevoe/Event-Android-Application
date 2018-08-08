package com.example.devashish.tt20.Events;

import com.example.devashish.tt20.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Devashish on 12/8/2017.
 */

public class Events {
    public static Events get(){
        return new Events();
    }
    private Events(){

    }
    public List<Event_data> getData(){
        return Arrays.asList(
                new Event_data(R.drawable.lagori,"[|Lagori|]","",0),
                new Event_data(R.drawable.sunburn,"[|Sunburn|]","",0),
                new Event_data(R.drawable.amittriv,"[|Amit|Trivedi|]","",0),
                new Event_data(R.drawable.moksh,"[|Moksh|Mantra|]","",0),
                new Event_data(R.drawable.singphonic,"[|Sing|Phonic|]","",0),
                new Event_data(R.drawable.falsetto,"[|Falsetto|]","",0),
                new Event_data(R.drawable.burniton,"[|Burn|It|On|]","",0),
                new Event_data(R.drawable.destroix,"[|Destroix|]","",0),
                new Event_data(R.drawable.sports,"[|Sports|]","",0),
                new Event_data(R.drawable.mattermind,"[|Matter|Mind|]","",0),
                new Event_data(R.drawable.focusia,"[|Focusia|]","",0),
                new Event_data(R.drawable.perspective,"[|Perspective|]","",0),
                new Event_data(R.drawable.technova,"[|Technova|]","",0),
                new Event_data(R.drawable.winterrunway,"[|Winter|Runway|]","",0),
                new Event_data(R.drawable.rangmanch,"[|RangManch|]","",0));
    }
}
