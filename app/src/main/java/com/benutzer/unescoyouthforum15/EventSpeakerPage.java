package com.benutzer.unescoyouthforum15;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;


public class EventSpeakerPage extends ActionBarActivity {
    Handler handleSpeakerDisplay = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            displaySpeakerData();
        }
    };
    String eventId;
    String speakerName[];
    ListAdapter listAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_speaker_page);
        listView = (ListView) findViewById(R.id.speakerListViewId);

        //gathering data from past activity that was passed via intent extras
        Bundle bundle = getIntent().getExtras();
        eventId = bundle.getString("eventId");

        loadSpeakerList();
    }

    private void loadSpeakerList(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                /*
                database linking code and retrieval using eventId
                 */
                /*
                initialise speaker name list for retrieving name of speakers in an event
                 */
                speakerName = new String[]{"1","2", "3", "4"};
                handleSpeakerDisplay.sendEmptyMessage(0);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private void displaySpeakerData(){
        listAdapter = new SpeakerAdapter(this, speakerName, eventId);
        listView.setAdapter(listAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_speaker_page, menu);
        return true;
    }
}
