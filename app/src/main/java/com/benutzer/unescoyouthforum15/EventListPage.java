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
        }
    };

    String eventsList[];
    String categoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list_page);

        Bundle bundle = getIntent().getExtras();
        categoryName = ((String) bundle.get("category"));

        loadEventList();
        setListenerToEventList();
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
                        int event = Integer.parseInt((((TextView) view.findViewById(R.id.hiddenViewEventId)).getText()).toString());
                        createEventPage(event);
                    }
                }
        );
    }

    private void createEventPage(int id){
        Intent intent = new Intent(this, EventPage.class);
        intent.putExtra("eventId", id);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_list_page, menu);
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
