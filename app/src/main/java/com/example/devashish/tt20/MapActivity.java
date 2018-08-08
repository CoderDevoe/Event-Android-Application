package com.example.devashish.tt20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowCloseListener;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowLongClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerDragListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

public class MapActivity extends AppCompatActivity implements GoogleMap.OnMarkerClickListener,
        GoogleMap.OnInfoWindowClickListener,
        GoogleMap.OnMarkerDragListener,
        GoogleMap.OnInfoWindowLongClickListener,
        GoogleMap.OnInfoWindowCloseListener
{
    private static final LatLng KU_GATE=new LatLng(26.723598, 94.075107);
    private static final LatLng ADMINISTRATION_BLOCK=new LatLng(26.724219, 94.075400);
    private static final LatLng RECEPTION = new LatLng(26.723954, 94.075536);
    private static final LatLng ENGINEERING_OLD_BLOCK=new LatLng(26.724034, 94.075812);
    private static final LatLng ENGINEERING_NEW_BLOCK=new LatLng(26.723863, 94.076447);
    private static final LatLng WORKSHOP=new LatLng(26.723388, 94.077166);
    private static final LatLng BOYS_HOSTEL_1 = new LatLng(26.725178, 94.079148);
    private static final LatLng CRICKET_FIELD = new LatLng(26.726063, 94.079237);
    private static final LatLng BHUKKAD = new LatLng(26.725656, 94.078705);
    private static final LatLng STORE = new LatLng(26.725651, 94.078501);
    private static final LatLng BARBER_SHOP = new LatLng(26.725651, 94.078501);
    private static final LatLng GIRLS_HOSTEL_2 = new LatLng(26.725730, 94.078182);
    private static final LatLng GIRLS_HOSTEL_1 = new LatLng(26.725745, 94.077868);
    private static final LatLng FOOTBALL_FIELD= new LatLng(26.725762, 94.076882);
    private static final LatLng BASKET_BALL_COURT_FIELD = new LatLng(26.725628, 94.076120);
    private static final LatLng TENNIS_COURT = new LatLng(26.725946, 94.076297);
    private static final LatLng VOLLEY_BALL_COURT = new LatLng(26.725603, 94.076310);
    private static final LatLng KTM = new LatLng(26.725085, 94.075598);
    private static final LatLng SOB_BLOCK = new LatLng(26.724668, 94.075778);
    private static final LatLng CAFETERIA = new LatLng(26.724610, 94.075529);
    private static final LatLng REGISTRATION = new LatLng(26.723447, 94.075378);
    private static final LatLng FALSETTO = new LatLng(26.723398, 94.075562);


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_map);

    }

    @Override
    public void onInfoWindowClick(Marker marker) {

    }



    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onInfoWindowClose(Marker marker) {

    }

    @Override
    public void onInfoWindowLongClick(Marker marker) {

    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

    }
}
