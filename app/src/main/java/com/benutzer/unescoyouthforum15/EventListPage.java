package com.benutzer.unescoyouthforum15;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class EventListPage extends ActionBarActivity {
    ListAdapter listAdapter;
    ListView listView;

    Handler handleEventListDisplay = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            displayEventList();
            setListenerToEventList();
        }
    };

    String eventsList[];
    String categoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list_page);
        listView = (ListView) findViewById(R.id.eventListViewId);

        Bundle bundle = getIntent().getExtras();
        categoryName = ((String) bundle.get("category"));

        loadEventList();

    }

    private void loadEventList(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                /*
                database linking code and retrieval for loading event name list
                 */
                /*
                initialise event  list(Array) for retrieving details of category
                 */
                eventsList = new String[]{"1","2", "3", "4"};
                handleEventListDisplay.sendEmptyMessage(0);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private void displayEventList(){
        listAdapter = new EventAdapter(this, eventsList);
        listView.setAdapter(listAdapter);
    }

    private void setListenerToEventList(){
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                       String event = ((TextView) view.findViewById(R.id.hiddenViewEventId)).getText().toString();

                        createEventPage(event);
                    }
                }
        );
    }

    private void createEventPage(String id){
        Intent intenta = new Intent(this, EventPage.class);
        intenta.putExtra("eventId", id);

        startActivity(intenta);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_list_page, menu);
        return true;
    }
}
