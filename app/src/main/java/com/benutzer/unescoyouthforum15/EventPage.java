package com.benutzer.unescoyouthforum15;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.LayoutDirection;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class EventPage extends BaseDrawerActivity {
    ImageView eventImage;
    ScrollView eventTextView;

    Handler handleEventData = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            displayEventData();
        }
    };
    String eventId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);
        super.onCreateDrawer();

        Bundle bundle = getIntent().getExtras();
        eventId = bundle.get("eventId").toString();
        loadEventData();
        //displayEventData();
    }

    private void loadEventData(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                //code to load event image and information from site using event id

                handleEventData.sendEmptyMessage(0);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    private void displayEventData(){
        eventImage = (ImageView) findViewById(R.id.eventPageImageId);
        eventTextView = (ScrollView) findViewById(R.id.scrollDescViewId);

        editImageViewListDisplayMetrics();
        designEventDescString(eventTextView);
        eventImage.setImageResource(R.drawable.unescobanner);
    }

    private void editImageViewListDisplayMetrics(){
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);

        int sw = dm.widthPixels;
        int sh = dm.heightPixels;
        RelativeLayout.LayoutParams params = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        //params.width = sw;
        params.height = sh/2;
        params.leftMargin = 0;
        params.topMargin = -50;
        eventImage.setLayoutParams(params);
        eventTextView.setFillViewport(true);
        RelativeLayout.LayoutParams sparams = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        sparams.height = sh/8;
        sparams.topMargin = sh/2 - 50;
        sparams.bottomMargin = 30;
        eventTextView.setLayoutParams(sparams);
    }

    private void designEventDescString(ScrollView scrollView){
        TextView textViewName = (TextView) scrollView.findViewById(R.id.scrollTextViewEventName);
        textViewName.setText("Name : *****************************************************************" + getResources().getString(R.string.eventName));

        TextView textViewTime = (TextView) scrollView.findViewById(R.id.scrollTextViewEventTime);
        textViewTime.setText(" Time : " + getResources().getString(R.string.eventTime));

        TextView textViewLocationVenue = (TextView) scrollView.findViewById(R.id.scrollTextViewEventLocationVenue);
        textViewLocationVenue.setText(" Venue : " + getResources().getString(R.string.eventLocationVenue));

        TextView textViewLocationStreet = (TextView) scrollView.findViewById(R.id.scrollTextViewEventLocationStreet);
        textViewLocationStreet.setText(" Street : " + getResources().getString(R.string.eventLocationStreet));

        TextView textViewLocationCity = (TextView) scrollView.findViewById(R.id.scrollTextViewEventLocationCity);
        textViewLocationCity.setText(" City : " + getResources().getString(R.string.eventLocationCity));

        TextView textViewLocationPin = (TextView) scrollView.findViewById(R.id.scrollTextViewEventLocationPin);
        textViewLocationPin.setText(" PIN : " + getResources().getString(R.string.eventLocationPin));

        TextView textViewTheme = (TextView) scrollView.findViewById(R.id.scrollTextViewEventTheme);
        textViewTheme.setText(" Theme : " + getResources().getString(R.string.eventTheme));

        TextView textViewSummary = (TextView) scrollView.findViewById(R.id.scrollTextViewEventSummary);
        textViewSummary.setText(" Summary : " + getResources().getString(R.string.eventSummary));
    }

    public void speakerListGenerator(View view){
        Intent intent = new Intent(this ,EventSpeakerPage.class);

        /*
        code to retrieve the event id to be passed to new activity
         */
        intent.putExtra("eventId", eventId);

        startActivity(intent);
    }

    public void directionMapGenerator(View view){
        Intent intent = new Intent(this, EventMapPage.class);

        /*
        code to retrieve the event id to be passed to new activity
         */
        intent.putExtra("eventId", eventId);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_page, menu);
        return true;
    }
}
