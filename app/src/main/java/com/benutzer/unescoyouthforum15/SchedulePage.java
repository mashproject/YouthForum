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


public class SchedulePage extends BaseDrawerActivity {
    Handler handleScheduleDisplay = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            displayScheduleList();
            setListenerToScheduleList();
        }
    };
    ListView listView;
    ListAdapter listAdapter;
    String scheduleList[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_page);
        super.onCreateDrawer();

        listView = (ListView) findViewById(R.id.schedulePageListViewId);

        loadScheduleList();
    }

    private void loadScheduleList(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                /*
                database linking and data retrieval code
                 */
                scheduleList = new String[]{"1", "2", "3", "4"};
                handleScheduleDisplay.sendEmptyMessage(0);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private void displayScheduleList(){
        listAdapter = new ScheduleAdapter(this, scheduleList);
        listView.setAdapter(listAdapter);
    }

    private void setListenerToScheduleList(){
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String event = scheduleList[position];
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
        getMenuInflater().inflate(R.menu.menu_schedule_page, menu);
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

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
