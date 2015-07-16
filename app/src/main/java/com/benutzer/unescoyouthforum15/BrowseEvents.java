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


public class BrowseEvents extends ActionBarActivity {
    Handler handleCategoryDisplay = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            displayCategoryList();
        }
    };
    String category[];
    ListAdapter listAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_events);
        listView = (ListView) findViewById(R.id.browseEventListID);

        loadCategoryList();
        setListenerToCategoryList();
    }

    private void loadCategoryList(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                /*
                database linking code and retrieval for loading category name list
                 */
                /*
                initialise category (Array) for retrieving details of category
                 */
                category = new String[]{"1","2", "3", "4"};
                handleCategoryDisplay.sendEmptyMessage(0);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private void displayCategoryList(){
        listAdapter = new CategoryAdapter(this, category);
        listView.setAdapter(listAdapter);
    }

    private void setListenerToCategoryList(){
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String categoryName = ((TextView) view.findViewById(R.id.hiddenViewId)).getText().toString();
                        createEventList(categoryName);
                    }
                }
        );
    }

    private void createEventList(String category){
        Intent intent = new Intent(this, EventListPage.class);
        intent.putExtra("category", category);

        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_browse_events, menu);
        return true;
    }

}
