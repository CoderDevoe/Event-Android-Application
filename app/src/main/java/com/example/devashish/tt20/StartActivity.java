package com.example.devashish.tt20;


import android.content.Intent;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.cunoraz.gifview.library.GifView;


public class StartActivity extends AppCompatActivity {
    GifView gifView1,gifView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Hide Status Bar
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else {
            View decorView = getWindow().getDecorView();
            // Hide Status Bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        gifView1 = (GifView) findViewById(R.id.gif_main);
        gifView2 = (GifView) findViewById(R.id.gif_main1);
        gifView1.setVisibility(View.VISIBLE);
        gifView2.setVisibility(View.VISIBLE);
        gifView1.play();
        gifView2.play();

       new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                StartAnim();
            }
        }, 6000);

    }
    private void StartAnim(){
        new Load().execute("");
    }
    private class Load extends AsyncTask<String,Void,String> {
        @Override
        protected void onPreExecute() {

            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            finish();
        }

        @Override
        protected String doInBackground(String... strings) {

            Intent intent=new Intent(StartActivity.this,MainActivity.class);
            startActivity(intent);
            return null;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
