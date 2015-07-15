package com.benutzer.unescoyouthforum15;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;


public class EventPage extends ActionBarActivity {

    Handler handleEventData = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            displayEventData();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);
        loadEventData();
    }

    private void loadEventData(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                /*
                code to load event image and information from site
                 */
                handleEventData.sendEmptyMessage(0);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

    private void displayEventData(){
        ImageView eventImage = (ImageView) findViewById(R.id.eventPageImageId);
        ScrollView eventTextView = (ScrollView) findViewById(R.id.scrollDescViewId);

        designEventDescString(eventTextView);
        eventImage.setImageResource(R.drawable.splashimage2);
    }

    private void designEventDescString(ScrollView scrollView){
        //TextView textView = new TextView(this);
        scrollView.addView(new TextView(this){
            @Override
            public void setText(CharSequence text, BufferType type) {
                super.setText("Name : " + getResources().getString(R.string.eventName));
            }
        });
        scrollView.addView(new TextView(this){
            @Override
            public void setText(CharSequence text, BufferType type) {
                super.setText("Timing : " + getResources().getString(R.string.eventTime));
            }
        });
        scrollView.addView(new TextView(this){
            @Override
            public void setText(CharSequence text, BufferType type) {
                super.setText("Venue : " + getResources().getString(R.string.eventLocationVenue));
            }
        });
        scrollView.addView(new TextView(this){
            @Override
            public void setText(CharSequence text, BufferType type) {
                super.setText("Street : " + getResources().getString(R.string.eventLocationStreet));
            }
        });
        scrollView.addView(new TextView(this){
            @Override
            public void setText(CharSequence text, BufferType type) {
                super.setText("City : " + getResources().getString(R.string.eventLocationCity));
            }
        });
        scrollView.addView(new TextView(this){
            @Override
            public void setText(CharSequence text, BufferType type) {
                super.setText("Pin : " + getResources().getString(R.string.eventLocationPin));
            }
        });
        scrollView.addView(new TextView(this){
            @Override
            public void setText(CharSequence text, BufferType type) {
                super.setText("Summary : " + getResources().getString(R.string.eventSummary));
            }
        });

    }

    public void speakerListGenerator(View view){
        int eventId = 1;
        Intent intent = new Intent(this ,EventSpeakerPage.class);

        /*
        code to retrieve the event id to be passed to new activity
         */
        intent.putExtra("eventId", eventId);

        startActivity(intent);
    }

    public void directionMapGenerator(View view){
        int eventId = 1; //would not be hardcoded
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
