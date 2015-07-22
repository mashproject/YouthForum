package com.benutzer.unescoyouthforum15;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;


public class NewsFeedPage extends BaseDrawerActivity {
    ListView listView;
    ListAdapter listAdapter;
    String[] newsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed_page);
        super.onCreateDrawer();

        listView = (ListView) findViewById(R.id.newsFeedListViewId);

        loadNewsList();
        //in handler
        displayNewsList();
    }

    private void loadNewsList(){
        /*
        load list in array newsList from server
         */
        newsList = new String[]{"1","2","3","4"};
    }

    private void displayNewsList(){
        listAdapter = new NewsAdapter(this, newsList);
        listView.setAdapter(listAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_news_feed_page, menu);
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
