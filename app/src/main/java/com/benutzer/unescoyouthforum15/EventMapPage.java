package com.benutzer.unescoyouthforum15;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class EventMapPage extends BaseDrawerActivity {
    String eventId;
    Handler handleMapDisplay = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            displayStaticMap();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_map_page);
        super.onCreateDrawer();
        //gathering data from past activity that was passed via intent extras
        Bundle bundle = getIntent().getExtras();
        eventId = bundle.get("eventId").toString();

        loadStaticMap();
    }

    private void loadStaticMap(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                /*
                load static image url from database using eventId
                 */
                /*
                load image from url
                 */
                handleMapDisplay.sendEmptyMessage(0);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private void displayStaticMap(){
        ImageView imageView = (ImageView) findViewById(R.id.staticMapImageViewId);

        /*
        code to load downloaded image from sdcard
         */
        imageView.setImageResource(R.drawable.iconplaceholder);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_map_page, menu);
        return true;
    }
}
